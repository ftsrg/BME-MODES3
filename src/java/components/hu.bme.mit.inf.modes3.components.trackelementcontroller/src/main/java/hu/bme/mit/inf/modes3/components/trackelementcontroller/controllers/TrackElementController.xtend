package hu.bme.mit.inf.modes3.components.trackelementcontroller.controllers

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioManager
import hu.bme.mit.inf.modes3.components.trackelementcontroller.config.Configuration
import hu.bme.mit.inf.modes3.components.trackelementcontroller.config.ExpanderConfigInterpreter
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.update.IAllStatusUpdateListener
import java.util.HashMap
import java.util.List
import java.util.Map.Entry
import org.slf4j.ILoggerFactory

class TrackElementController extends AbstractRailRoadCommunicationComponent implements IAllStatusUpdateListener, ISegmentCommandListener, ITurnoutCommandListener, PhysicalTurnoutController.ITurnoutStateChangedListener {

	Configuration config
	val int id

	private HashMap<Integer, PhysicalSegmentController> segmentControllers = newHashMap()

	private List<PhysicalTurnoutController> turnoutControllers = newArrayList()

	Object turnoutStateChangedBarrier = new Object();

	new(int turnoutID, CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)

		id = turnoutID

		// TODO move out configuration files from resources and get the path of them from parameters
		// loading configurations
		config = Configuration::loadPinoutConfig(turnoutID, factory)
		val pinout = ExpanderConfigInterpreter.loadPinoutConfig(factory);
		GpioManager.loadGpioMappingFromFile("gpio.json")

		logger.info('''segments: «config.sectionNames»''')
		logger.info('''turnout expander: «config.turnoutExpanders»''')

		// for each and every segment we need to create a segmentController class
		for (String section : config.sectionNames) {
			try {
				var segmentId = Integer.parseInt(section);
				var expander = config.getSectionExpander(Integer.parseInt(section));
				var controller = new PhysicalSegmentController(pinout, expander, factory);
				segmentControllers.put(segmentId, controller);

				// because we do know, that all pin that we will use will be low at this time,
				// we could send an message over network about the segment's status (disabled)
				locator.trackElementStateSender.sendSegmentState(segmentId, controller.segmentState);
				
			} catch (NumberFormatException exp) {
				// TODO if section is not a number, it is a problem!
			}
		}

		// we will have an turnoutController class as well
		// in only one case, there will be two turnout controller to work with, therefore
		// we need a list of the controllers also
		for (String turnout : config.turnoutExpanders) {
			var controller = new PhysicalTurnoutController(pinout, turnout, factory);
			controller.turnoutStateChangedListener = this;
			turnoutControllers.add(controller);
		}

		// adding component as segmentCommandListener
		locator.trackElementCommandCallback.segmentCommandListener = this;
		locator.trackElementCommandCallback.turnoutCommandListener = this;
		
		locator.sendAllStatusCallback.statusUpdateListener = this;
	}

	override run() {
		Thread.currentThread.join
	}

	override onSegmentCommand(int id, SegmentState state) {

		// if new segment command received on network, we need to check if it's our obligation to handle or not
		if (!segmentControllers.keySet.contains(id)) {
			return;
		}

		logger.info('''Segment state change command received on segment #«id»: «state»''');

		// set state of segment
		segmentControllers.get(id).segmentState = state;

		// also we need to send segmentState over network
		locator.trackElementStateSender.sendSegmentState(id, segmentControllers.get(id).segmentState);
	}

	override onTurnoutCommand(int id, TurnoutState state) {

		// if new turnout command received on network, we need to check if it's our obligation to handle or not
		if (this.id != id) {
			return;
		}

		logger.info('''Turnout state change command received on turnout #«id»: «state»''');

		// sending for every controller the new state
		for (PhysicalTurnoutController controller : turnoutControllers) {
			if (!controller.turnoutState.equals(state)) {
				controller.turnoutState = state;
			}
		}

		// we do not need to send state back to the network, the pin change will trigger a state message
	}

	override onStateChanged(TurnoutState newState) {
		synchronized (turnoutStateChangedBarrier) {

			logger.info('''state changed! new state: «newState»''')

			if (newState == TurnoutState.ILLEGAL) {
				// TODO handle it in a correct
				return;
			}

			// we have to set all the turnout controllers to the new state to be absolutely sure
			// that all turnout are in the same position (it is vital in the case of T3)
			if (id == 3) {
				for (PhysicalTurnoutController controller : turnoutControllers) {
					if (!controller.turnoutState.equals(newState)) {
						controller.turnoutState = newState;
					}
				}
			}

			// need to send segmentState over network
			locator.trackElementStateSender.sendTurnoutState(id, newState);

		}
	}
	
	override onAllStatusUpdate() {
		for(Entry<Integer, PhysicalSegmentController> segment: segmentControllers.entrySet){
			locator.trackElementStateSender.sendSegmentState(segment.key, segment.value.segmentState)
		}
		for(PhysicalTurnoutController turnoutController: turnoutControllers){
			locator.trackElementStateSender.sendTurnoutState(id, turnoutController.turnoutState)
		}
	}

}
