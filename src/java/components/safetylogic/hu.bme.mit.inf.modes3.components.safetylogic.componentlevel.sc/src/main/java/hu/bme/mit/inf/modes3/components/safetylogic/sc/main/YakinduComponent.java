package hu.bme.mit.inf.modes3.components.safetylogic.sc.main;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.ILoggerFactory;
import org.yakindu.scr.section.SectionStatemachineRunnable;
import org.yakindu.scr.turnout.TurnoutStatemachineRunnable;

import hu.bme.mit.inf.modes3.components.common.AbstractCommunicationComponent;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.LayoutConfigurationException;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.LayoutConfigurationLoader;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.ComponentLayoutConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.LayoutConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.factory.StatechartComponentFactory;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageBridgeToExternal;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageBridgeToInternal;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageDispatcher;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.factory.YakinduCommunicationStackFactory;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduCanGoToHandler;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduCannotGoToHandler;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduHandlerHolder;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduReleaseToHandler;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduReserveToHandler;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter.ProtocolPeriodicRestarterRunnable;
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry;

public class YakinduComponent extends AbstractCommunicationComponent {

	private ILoggerFactory loggerFactory;

	protected Set<SectionStatemachineRunnable> sectionStatemachines;
	protected Set<Thread> sectionStatemachineThreads = new HashSet<>();

	protected Set<TurnoutStatemachineRunnable> turnoutStatemachines;
	protected Set<Thread> turnoutStatemachineThreads = new HashSet<>();

	protected ProtocolPeriodicRestarterRunnable periodicRestarter;
	protected Thread periodicRestarterThread;

	protected CommunicationStack incomingYakinduStack;
	protected CommunicationStack outgoingYakinduStack;

	public YakinduComponent(CommunicationStack trackInfoStack, ILoggerFactory factory) {
		super(trackInfoStack, factory);
		this.loggerFactory = factory;
	}

	public void createStatechartsAndInitializeComponent(String componentName, ArgumentRegistry argumentRegistryForProtobuf)
			throws IOException, LayoutConfigurationException {
		// 1 stack for outgoing yakindu messages
		getLogger().debug("Creating communication stack for outgoing yakindu messages started.");
		if (argumentRegistryForProtobuf != null) {
			outgoingYakinduStack = YakinduCommunicationStackFactory.createProtobufStack(argumentRegistryForProtobuf, loggerFactory);
		} else {
			outgoingYakinduStack = YakinduCommunicationStackFactory.createLocalStack(loggerFactory);
		}
		YakinduMessageBridgeToExternal bridgeToExternal = new YakinduMessageBridgeToExternal(outgoingYakinduStack.getMms(), loggerFactory);
		YakinduHandlerHolder outgoingHandlerHolder = new YakinduHandlerHolder(bridgeToExternal, bridgeToExternal, bridgeToExternal, bridgeToExternal);
		getLogger().debug("Creating communication stack for outgoing yakindu messages finished.");

		// 1 stack for track info in-out (super.communication used for this purpose)
		TrackCommunicationServiceLocator trackCommunication = new TrackCommunicationServiceLocator(super.communication, loggerFactory);

		// load layout configuration for component
		getLogger().debug("Loading layout configuration for component started.");
		LayoutConfiguration layoutConfiguration = LayoutConfigurationLoader.loadLayoutConfiguration();
		ComponentLayoutConfiguration componentConfiguration = LayoutConfigurationLoader.getLayoutConfigurationForComponent(layoutConfiguration, componentName);
		getLogger().debug("Loading layout configuration for component finished.");

		// initialize statemachines based on layout
		StatechartComponentFactory statechartFactory = new StatechartComponentFactory(loggerFactory);

		// initialize and generate section and turnout statecharts plus register the track element commander (which enables to send section commands to the
		// track), and the yakindu outgoing message handlers (that forward yakindu network messages via the network)
		ITrackElementCommander trackElementCommander = trackCommunication.getTrackElementCommander();
		getLogger().debug("Generating and connecting statecharts started.");
		statechartFactory.initializeSectionAndTurnoutStatecharts(componentConfiguration, trackElementCommander, outgoingHandlerHolder);
		getLogger().debug("Generating and connecting statecharts finished.");

		// register the change listeners (that receive track info for statecharts)
		ITrackElementStateRegistry stateRegistry = trackCommunication.getTrackElementStateRegistry();
		statechartFactory.createTrackElementStatusTransmitter(stateRegistry);

		// register yakindu incoming message handler to a stack
		getLogger().debug("Creating communication stack for incoming yakindu messages started.");
		YakinduMessageBridgeToInternal messageBridgeToInternal = statechartFactory.createMessageBridge();
		YakinduMessageDispatcher incomingMessageDispatcher = new YakinduMessageDispatcher(loggerFactory);
		incomingMessageDispatcher.setReserveToHandler(new YakinduReserveToHandler(messageBridgeToInternal));
		incomingMessageDispatcher.setReleaseToHandler(new YakinduReleaseToHandler(messageBridgeToInternal));
		incomingMessageDispatcher.setCannotGoToHandler(new YakinduCannotGoToHandler(messageBridgeToInternal));
		incomingMessageDispatcher.setCanGoToHandler(new YakinduCanGoToHandler(messageBridgeToInternal));

		// 1 stack for incoming yakindu messages
		if (argumentRegistryForProtobuf != null) {
			incomingYakinduStack = YakinduCommunicationStackFactory.createProtobufStackFromDispatcher(argumentRegistryForProtobuf, incomingMessageDispatcher, loggerFactory);
		} else {
			incomingYakinduStack = YakinduCommunicationStackFactory.createLocalStack(loggerFactory);
		}
		getLogger().debug("Creating communication stack for incoming yakindu messages finished.");

		// get the initialized statemachines
		sectionStatemachines = statechartFactory.getSectionStatemachineRunnables();
		turnoutStatemachines = statechartFactory.getTurnoutStatemachineRunnables();

		// periodic yakindu protocol restarter
		periodicRestarter = statechartFactory.createPeriodicProtocolRestarter();
	}

	@Override
	public void run() {
		// start the communication stacks
		super.communication.start();
		incomingYakinduStack.start();
		outgoingYakinduStack.start();

		// start the statemachines
		if (sectionStatemachines != null) {
			getLogger().debug("Starting section statemachines.");
			sectionStatemachines.forEach(sm -> {
				sm.init();
				sm.enter();
				Thread thread = new Thread(sm);
				sectionStatemachineThreads.add(thread);
			});
		}
		if (turnoutStatemachines != null) {
			getLogger().debug("Starting turnout statemachines.");
			turnoutStatemachines.forEach(sm -> {
				sm.init();
				sm.enter();
				Thread thread = new Thread(sm);
				turnoutStatemachineThreads.add(thread);
			});
		}

		sectionStatemachineThreads.forEach(thread -> thread.start());
		turnoutStatemachineThreads.forEach(thread -> thread.start());

		if (periodicRestarter != null) {
			getLogger().debug("Starting periodic yakindu protocol restarter.");
			periodicRestarterThread = new Thread(periodicRestarter);
			periodicRestarterThread.start();
		}
	}

	public void interrupt() {
		getLogger().debug("Interrupting periodic yakindu protocol restarter.");
		periodicRestarterThread.interrupt();
		getLogger().debug("Interrupting section statemachines.");
		sectionStatemachineThreads.forEach(thread -> thread.interrupt());
		getLogger().debug("Interrupting turnout statemachines.");
		turnoutStatemachineThreads.forEach(thread -> thread.interrupt());
	}

}
