package hu.bme.mit.inf.modes3.components.trackelementcontroller

import hu.bme.mit.inf.modes3.components.gpiomanager.GpioManager
import hu.bme.mit.inf.modes3.components.trackelementcontroller.bridge.ITrackElementControllerBridge
import hu.bme.mit.inf.modes3.components.trackelementcontroller.config.Configuration
import hu.bme.mit.inf.modes3.components.trackelementcontroller.config.ExpanderConfigInterpreter
import hu.bme.mit.inf.modes3.components.trackelementcontroller.controllers.PhysicalSegmentController
import hu.bme.mit.inf.modes3.components.trackelementcontroller.controllers.PhysicalTurnoutController
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import java.util.HashMap
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioWriter

class TrackElementController implements ITrackElementController, PhysicalTurnoutController.ITurnoutStateChangedListener {

	private static val GPIO_JSON = '''gpio.json'''

	val Configuration config
	val ExpanderConfigInterpreter pinout
	val int id

	@Accessors(PUBLIC_SETTER) var ITrackElementControllerBridge trackElementControllerBridge
	var TurnoutChangeGuard guard

	val ILoggerFactory factory
	val Logger logger

	val HashMap<Integer, PhysicalSegmentController> segmentControllers = newHashMap
	val List<PhysicalTurnoutController> turnoutControllers = newArrayList

	new(int turnoutID, ILoggerFactory factory) {
		this.factory = factory
		logger = factory.getLogger(this.class.name)
		id = turnoutID

		// TODO move out configuration files from resources and get the path of them from parameters
		// loading configurations
		config = Configuration::loadPinoutConfig(turnoutID, factory)
		pinout = ExpanderConfigInterpreter.loadPinoutConfig(factory)
		GpioManager::loadGpioMappingFromFile(GPIO_JSON)
		// TODO Check validity
		GpioManager::setGpioWriter(new GpioWriter)

		logger.info('''segments: «config.sectionNames»''')
		logger.info('''turnout expander: «config.turnoutExpanders»''')
	}

	override setTrackElementControllerBridge(ITrackElementControllerBridge bridge) {
		this.trackElementControllerBridge = bridge
		this.guard = new TurnoutChangeGuard(id, trackElementControllerBridge.trackElementStateRegistry)

		// for each and every segment we need to create a segmentController class
		config.sectionNames.forEach [
			try {
				var segmentId = Integer.parseInt(it)
				var expander = config.getSectionExpander(Integer.parseInt(it))
				var controller = new PhysicalSegmentController(pinout, expander, factory)
				segmentControllers.put(segmentId, controller)

				// because we do know, that all pin that we will use will be low at this time,
				// we could send an message over network about the segment's status (disabled)
				trackElementControllerBridge.sendSegmentState(segmentId, controller.segmentState)
			} catch(NumberFormatException exp) {
				logger.warn('''«it» is not a valid number as a segement ID. Error message: «exp.message»''', exp)
			}
		]

		// we will have an turnoutController class as well
		// in only one case, there will be two turnout controller to work with, therefore
		// we need a list of the controllers also
		config.turnoutExpanders.forEach [
			var controller = new PhysicalTurnoutController(pinout, it, factory)
			controller.turnoutStateChangedListener = this
			turnoutControllers.add(controller)
		]
	}

	override run() {
		Thread.currentThread.join
	}

	override onSegmentCommand(int id, SegmentState state) {
		// if new segment command received on network, we need to check if it's our obligation to handle or not
		if(!segmentControllers.keySet.contains(id)) {
			return
		}

		logger.info('''Segment state change command received on segment #«id»: «state»''')

		// set state of segment
		segmentControllers.get(id).segmentState = state

		// also we need to send segmentState over network
		trackElementControllerBridge.sendSegmentState(id, segmentControllers.get(id).segmentState)
	}

	override onTurnoutCommand(int id, TurnoutState state) {
		// if it is an illegal state
		// if new turnout command received on network, we need to check if it's our obligation to handle or not
		// if we handle this turnout, but the direction change is not allowed
		if((state == TurnoutState.ILLEGAL) || (this.id != id) || (this.id == id && !guard.isDirectionChangeAllowed())) {
			return
		}

		logger.info('''Turnout state change command received on turnout #«id»: «state»''')

		// sending for every controller the new state
		turnoutControllers.forEach[logger.info('''«it.turnoutState»''')]
		turnoutControllers.filter[it.turnoutState != state].forEach[it.turnoutState = state]

	// we do not need to send state back to the network, the pin change will trigger a state message
	}

	override synchronized onStateChanged(TurnoutState newState) {
		logger.info('''Turnout state changed! new state: «newState»''')

		if(newState == TurnoutState.ILLEGAL) {
			return
		}

		// we have to set all the turnout controllers to the new state to be absolutely sure
		// that all turnout are in the same position (it is vital in the case of T3)
		if(id == 3) {
			turnoutControllers.filter[it.turnoutState != newState].forEach[it.turnoutState = newState]
		}

		// need to send segmentState over network
		trackElementControllerBridge.sendTurnoutState(id, newState)
	}

	override onSendAllStatus() {
		segmentControllers.entrySet.forEach [
			trackElementControllerBridge.sendSegmentState(it.key, it.value.segmentState)
		]
		turnoutControllers.forEach[trackElementControllerBridge.sendTurnoutState(id, it.turnoutState)]
	}

}
