package hu.bme.mit.inf.modes3.components.safetylogic.sc.factory;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.SynchronizedSectionStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine;
import org.yakindu.scr.turnout.SynchronizedTurnoutStatemachine;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.ComponentLayoutConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.SectionConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.TurnoutConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageBridgeToInternal;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduHandlerHolder;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter.SectionCommandToExternalTransmitter;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter.TrackElementStatusToInternalTransmitter;
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry;

public class YakinduStatechartComponentFactory {

	private Map<Integer, ITurnoutStatemachine> localTurnouts = new TreeMap<>();
	private Map<Integer, ISectionStatemachine> localSections = new TreeMap<>();

	@Deprecated
	public Map<Integer, ITurnoutStatemachine> getLocalTurnouts() {
		return localTurnouts;
	}

	@Deprecated
	public Map<Integer, ISectionStatemachine> getLocalSections() {
		return localSections;
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
		List<TurnoutConfiguration> turnoutConfigurations = componentLayout.getTurnouts();
		List<SectionConfiguration> sectionConfigurations = componentLayout.getSections();

		clearCache();
		generateLocalSectionStatecharts(sectionConfigurations, trackElementCommander);
		generateLocalTurnoutStatecharts(turnoutConfigurations);

		SectionStatechartConfigurationInitializer sectionFactory = new SectionStatechartConfigurationInitializer(localTurnouts, localSections,
				sectionConfigurations, remoteTrackElementHandlers);
		TurnoutStatechartsFactory turnoutFactory = new TurnoutStatechartsFactory(localTurnouts, localSections, turnoutConfigurations,
				remoteTrackElementHandlers);

		turnoutFactory.connectTurnoutsToNeighbours();
		sectionFactory.connectSectionsToNeighbours();
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
			sectionConfigurations.stream().forEach(section -> {
				ISectionStatemachine sm = new SynchronizedSectionStatemachine();
				int id = section.getOccupancyId();
				sm.getSCISection().setId(id);

				/**
				 * register the track element command handler so that section statechart can send enable/disable section command over the network
				 */
				new SectionCommandToExternalTransmitter(sm, trackElementCommander);

				localSections.put(id, sm);
			});
		}
	}

	/**
	 * generate turnout statecharts based on the turnout configuration
	 */
	private void generateLocalTurnoutStatecharts(List<TurnoutConfiguration> turnoutConfigurations) {
		if (turnoutConfigurations != null) {
			turnoutConfigurations.stream().forEach(turnout -> {
				int id = turnout.getOccupancyId();
				ITurnoutStatemachine sm = new SynchronizedTurnoutStatemachine();
				sm.getSCITurnout().setId(id);
				localTurnouts.put(id, sm);
			});
		}
	}

	/**
	 * Bridge for the yakindu statecharts to accept messages from the network.
	 */
	public YakinduMessageBridgeToInternal createMessageBridge() {
		YakinduMessageBridgeToInternal messageBridge = new YakinduMessageBridgeToInternal();

		localTurnouts.entrySet().stream().forEach(turnoutEntry -> messageBridge.registerTurnoutStatemachine(turnoutEntry.getKey(), turnoutEntry.getValue()));
		localSections.entrySet().stream().forEach(sectionEntry -> messageBridge.registerSectionStatemachine(sectionEntry.getKey(), sectionEntry.getValue()));

		return messageBridge;
	}

	/**
	 * Bridge for the yakindu statecharts to accept section/turnout status information from the track.
	 */
	public TrackElementStatusToInternalTransmitter createTrackElementStatusTransmitter(ITrackElementStateRegistry stateProvider) {
		TrackElementStatusToInternalTransmitter transmitter = new TrackElementStatusToInternalTransmitter(stateProvider);

		localTurnouts.entrySet().stream().forEach(turnoutEntry -> transmitter.registerTurnoutStatemachine(turnoutEntry.getKey(), turnoutEntry.getValue()));
		localSections.entrySet().stream().forEach(sectionEntry -> transmitter.registerSectionStatemachine(sectionEntry.getKey(), sectionEntry.getValue()));

		return transmitter;
	}

}
