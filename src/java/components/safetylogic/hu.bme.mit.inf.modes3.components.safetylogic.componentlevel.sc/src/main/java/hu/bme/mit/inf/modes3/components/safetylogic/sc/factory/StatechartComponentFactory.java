package hu.bme.mit.inf.modes3.components.safetylogic.sc.factory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.SectionStatemachineRunnable;
import org.yakindu.scr.turnout.ITurnoutStatemachine;
import org.yakindu.scr.turnout.TurnoutStatemachineRunnable;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.ComponentLayoutConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.SectionConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.TurnoutConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageBridgeToInternal;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduHandlerHolder;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter.ProtocolPeriodicRestarterRunnable;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter.SectionCommandToExternalTransmitter;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter.TrackElementStatusToInternalTransmitter;
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry;

public class StatechartComponentFactory {

	protected final Logger logger;
	private final ILoggerFactory factory;

	private Map<Integer, ITurnoutStatemachine> localTurnouts = new TreeMap<>();
	private Map<Integer, ISectionStatemachine> localSections = new TreeMap<>();

	private Map<Integer, TurnoutStatemachineRunnable> turnoutStatemachines = new TreeMap<>();
	private Map<Integer, SectionStatemachineRunnable> sectionStatemachines = new TreeMap<>();

	public StatechartComponentFactory(ILoggerFactory factory) {
		this.factory = factory;
		this.logger = factory.getLogger(this.getClass().getName());
	}

	@Deprecated
	public Map<Integer, ITurnoutStatemachine> getLocalTurnouts() {
		return localTurnouts;
	}

	@Deprecated
	public Map<Integer, ISectionStatemachine> getLocalSections() {
		return localSections;
	}

	public Set<TurnoutStatemachineRunnable> getTurnoutStatemachineRunnables() {
		Set<TurnoutStatemachineRunnable> runnables = new HashSet<>();
		try {
			turnoutStatemachines.entrySet().forEach(entry -> runnables.add(entry.getValue()));
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return runnables;
	}

	public Set<SectionStatemachineRunnable> getSectionStatemachineRunnables() {
		Set<SectionStatemachineRunnable> runnables = new HashSet<>();
		try {
			sectionStatemachines.entrySet().forEach(entry -> runnables.add(entry.getValue()));
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return runnables;
	}

	/**
	 * @param componentLayout
	 *            stores how local turnouts/sections connect to each other and to remote trakc elements
	 * @param trackElementCommander
	 *            transfers the track element commands (e.g. enable/disable section) to the network
	 * @param remoteTrackElementHandlers
	 *            encapsulates handlers which transfer different yakindu messages to the network
	 */
	public void initializeSectionAndTurnoutStatecharts(ComponentLayoutConfiguration componentLayout, ITrackElementCommander trackElementCommander,
			YakinduHandlerHolder remoteTrackElementHandlers) {
		logger.debug("Section and turnout initialization started.");

		List<TurnoutConfiguration> turnoutConfigurations = componentLayout.getTurnouts();
		List<SectionConfiguration> sectionConfigurations = componentLayout.getSections();

		clearCache();
		generateLocalSectionStatecharts(sectionConfigurations, trackElementCommander);
		generateLocalTurnoutStatecharts(turnoutConfigurations);

		SectionStatechartConfigurationInitializer sectionFactory = new SectionStatechartConfigurationInitializer(localTurnouts, localSections,
				sectionConfigurations, remoteTrackElementHandlers, factory);
		TurnoutStatechartsFactory turnoutFactory = new TurnoutStatechartsFactory(localTurnouts, localSections, turnoutConfigurations,
				remoteTrackElementHandlers, factory);

		turnoutFactory.connectTurnoutsToNeighbours();
		sectionFactory.connectSectionsToNeighbours();

		logger.debug("Section and turnout initialization finished.");
	}

	private void clearCache() {
		localTurnouts.clear();
		localSections.clear();
	}

	/**
	 * generate section statecharts based on the section configuration
	 */
	private void generateLocalSectionStatecharts(List<SectionConfiguration> sectionConfigurations, ITrackElementCommander trackElementCommander) {
		if (sectionConfigurations != null) {
			logger.debug("Generating local section statecharts started.");

			sectionConfigurations.stream().forEach(section -> {
				SectionStatemachineRunnable synchronizedSm = new SectionStatemachineRunnable();
				ISectionStatemachine sm = synchronizedSm;

				int id = section.getOccupancyId();
				sm.getSCISection().setId(id);

				/**
				 * register the track element command handler so that section statechart can send enable/disable section command over the network
				 */
				new SectionCommandToExternalTransmitter(sm, trackElementCommander, factory);

				localSections.put(id, sm);
				sectionStatemachines.put(id, synchronizedSm);
			});

			logger.debug("Generating local section statecharts finished.");
		}
	}

	/**
	 * generate turnout statecharts based on the turnout configuration
	 */
	private void generateLocalTurnoutStatecharts(List<TurnoutConfiguration> turnoutConfigurations) {
		if (turnoutConfigurations != null) {
			logger.debug("Generating local turnout statecharts started.");

			turnoutConfigurations.stream().forEach(turnout -> {
				int id = turnout.getOccupancyId();
				TurnoutStatemachineRunnable synchronizedSm = new TurnoutStatemachineRunnable();
				ITurnoutStatemachine sm = synchronizedSm;

				sm.getSCITurnout().setId(id);
				localTurnouts.put(id, sm);
				turnoutStatemachines.put(id, synchronizedSm);
			});

			logger.debug("Generating local turnout statecharts finished.");
		}
	}

	/**
	 * Bridge for the yakindu statecharts to accept messages from the network.
	 */
	public YakinduMessageBridgeToInternal createMessageBridge() {
		logger.debug("Creating YakinduMessageBridgeToInternal started.");

		YakinduMessageBridgeToInternal messageBridge = new YakinduMessageBridgeToInternal(factory);

		localTurnouts.entrySet().stream().forEach(turnoutEntry -> messageBridge.registerTurnoutStatemachine(turnoutEntry.getKey(), turnoutEntry.getValue()));
		localSections.entrySet().stream().forEach(sectionEntry -> messageBridge.registerSectionStatemachine(sectionEntry.getKey(), sectionEntry.getValue()));

		logger.debug("Creating YakinduMessageBridgeToInternal finished.");

		return messageBridge;
	}

	/**
	 * Bridge for the yakindu statecharts to accept section/turnout status information from the track.
	 */
	public TrackElementStatusToInternalTransmitter createTrackElementStatusTransmitter(ITrackElementStateRegistry stateProvider) {
		logger.debug("Creating TrackElementStatusToInternalTransmitter started.");

		TrackElementStatusToInternalTransmitter transmitter = new TrackElementStatusToInternalTransmitter(stateProvider, factory);

		localTurnouts.entrySet().stream().forEach(turnoutEntry -> transmitter.registerTurnoutStatemachine(turnoutEntry.getKey(), turnoutEntry.getValue()));
		localSections.entrySet().stream().forEach(sectionEntry -> transmitter.registerSectionStatemachine(sectionEntry.getKey(), sectionEntry.getValue()));

		logger.debug("Creating TrackElementStatusToInternalTransmitter finished.");

		return transmitter;
	}

	/**
	 * Creates a runnable which periodically fires the restartProtocol events to the section statecharts.
	 */
	public ProtocolPeriodicRestarterRunnable createPeriodicProtocolRestarter() {
		logger.debug("Creating ProtocolPeriodicRestarterRunnable started.");
		ProtocolPeriodicRestarterRunnable runnable = new ProtocolPeriodicRestarterRunnable();
		localSections.entrySet().stream().forEach(sectionEntry -> runnable.registerSectionStatemachine(sectionEntry.getKey(), sectionEntry.getValue()));
		logger.debug("Creating ProtocolPeriodicRestarterRunnable finished.");
		return runnable;
	}

}
