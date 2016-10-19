package hu.bme.mit.inf.modes3.components.bbb

import hu.bme.mit.inf.modes3.components.bbb.config.Configuration
import hu.bme.mit.inf.modes3.components.bbb.controllers.PhysicalSegmentController
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import java.util.HashMap
import org.slf4j.ILoggerFactory
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.components.bbb.config.Pinout
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioManager

class BBBComponent extends AbstractRailRoadCommunicationComponent implements ISegmentCommandListener {

	Configuration config
	val int id

	private HashMap<Integer, PhysicalSegmentController> segmentControllers = newHashMap()

	new(int turnoutID, CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)

		id = turnoutID

		// loading configurations
		config = Configuration::loadPinoutConfig(turnoutID, factory)
		val pinout = Pinout.loadPinoutConfig(factory);
		GpioManager.gpioMapping = "gpio.json"

		logger.info('''segments: «config.sectionNames»''')
		logger.info('''turnout expander: «config.turnoutExpanders»''')

		// for each and every segment we need to create a segmentController class
		for (String section : config.sectionNames) {
			try {
				var segmentId = Integer.parseInt(section);
				var expander = config.getSectionExpander(Integer.parseInt(section));
				segmentControllers.put(segmentId, new PhysicalSegmentController(pinout, expander));
			} catch (NumberFormatException exp) {
				// TODO if section is not a number, it is a problem!
			}
		}
		
		// adding component as segmentCommandListener
		locator.trackElementCommandCallback.segmentCommandListener = this;

//		pinController = new GpioManagerPinController(factory)
//		expanderController = new CapeExpanderController(pinController, factory)
//
//		logger.info('''Segments responsible for: «config.sectionNames»''')
//
//		locator.trackElementCommandCallback.segmentCommandListener = new ISegmentCommandListener() {
//			override onSegmentCommand(int id, SegmentState state) {
//				if(config.sectionNames.contains(id.toString)) {
//					logger.info('''Setting section id «id» to state «state.name»''')
//				}
//			}
//		}
//
//		locator.trackElementCommandCallback.turnoutCommandListener = new ITurnoutCommandListener() {
//			override onTurnoutCommand(int id, TurnoutState state) {
//				if(turnoutID == id) {
//					logger.info('''Setting turnout id «id» to state «state.name»''')
//					config.turnoutExpanders.forEach[expander |
//						expanderController.setTurnoutExpanderLevel(expander, state);	
//					]
//				}
//			}
//		}
//		
//		val turnoutChangeHandler = new TurnoutPinChangedHandler() {
//			override handleTurnoutPinChange(TurnoutState state) {
//				logger.info('''Turnout id «id» changed to «state.name»''')
//				//locator.trackElementStateSender.sendTurnoutState(turnoutID, state)
//			}
//		}
//		
//		turnoutChangeHandler.resolveExpanders(config)
//		expanderController.turnoutExpanderChangedHandler = turnoutChangeHandler
	}

	override run() {
		System.console.readLine("Press ENTER for ending BBB component running");
		logger.info('''Stopping BBBComponent...''')
		GpioManager.cleanup
	}

	override onSegmentCommand(int id, SegmentState state) {
		
		// if new segment command received on network, we need to check if it's our obligation or not
		if (!segmentControllers.keySet.contains(id)) {
			return;
		}
		
		logger.info('''Segment state change command received on segment #«id»: «state»''')
		
		// locator.trackElementStateSender.sendSegmentState(id, state)

		// set state of segment
		segmentControllers.get(id).segmentState = state;

	}

}
