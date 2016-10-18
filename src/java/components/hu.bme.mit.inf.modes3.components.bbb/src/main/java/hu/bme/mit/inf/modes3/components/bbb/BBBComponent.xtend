package hu.bme.mit.inf.modes3.components.bbb

import hu.bme.mit.inf.modes3.components.bbb.config.Configuration
import hu.bme.mit.inf.modes3.components.bbb.controllers.CapeExpanderController
import hu.bme.mit.inf.modes3.components.bbb.controllers.GpioManagerPinController
import hu.bme.mit.inf.modes3.components.bbb.controllers.strategy.IExpanderController
import hu.bme.mit.inf.modes3.components.bbb.controllers.strategy.IPinController
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import org.slf4j.ILoggerFactory
import hu.bme.mit.inf.modes3.components.bbb.controllers.strategy.ITurnoutPinChangedHandler

class BBBComponent extends AbstractRailRoadCommunicationComponent {

	IPinController pinController
	IExpanderController expanderController
	Configuration config
	val int id

	new(int turnoutID, CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)

		id = turnoutID
		config = Configuration::loadPinoutConfig(turnoutID, factory)
		pinController = new GpioManagerPinController(factory)
		expanderController = new CapeExpanderController(pinController, factory)
		expanderController.turnoutExpanders = config.turnoutExpanders

		logger.info('''Segments responsible for: «config.sectionNames»''')

		locator.trackElementCommandCallback.segmentCommandListener = new ISegmentCommandListener() {
			override onSegmentCommand(int id, SegmentState state) {
				if(config.sectionNames.contains(id.toString)) {
					logger.info('''Setting section id «id» to state «state.name»''')
					expanderController.setSegmentExpanderLevel(config.getSectionExpander(id), state);
				}
			}
		}

		locator.trackElementCommandCallback.turnoutCommandListener = new ITurnoutCommandListener() {
			override onTurnoutCommand(int id, TurnoutState state) {
				if(turnoutID == id) {
					logger.info('''Setting turnout id «id» to state «state.name»''')
					config.turnoutExpanders.forEach[expander |
						expanderController.setTurnoutExpanderLevel(expander, state);	
					]
				}
			}
		}
		
		expanderController.turnoutExpanderChangedHandler = new ITurnoutPinChangedHandler {
			override handleTurnoutPinChange(boolean div, boolean str) {
				if (div && str) {
					return
				}
				if (div) {
					logger.info('''Sending DIVERGENT turnout state''')
					locator.trackElementStateSender.sendTurnoutState(turnoutID, TurnoutState.DIVERGENT)
				}
				if (str) {
					logger.info('''Sending STRAIGHT turnout state''')
					locator.trackElementStateSender.sendTurnoutState(turnoutID, TurnoutState.STRAIGHT)
				}
			}
		}
	}

	override run() {
		while(true) {
			Thread.sleep(7962)
		}
	}

}
