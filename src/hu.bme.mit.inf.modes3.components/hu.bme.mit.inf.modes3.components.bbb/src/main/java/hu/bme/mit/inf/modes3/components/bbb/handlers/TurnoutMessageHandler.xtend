package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.bbb.utils.TurnoutStatus
import hu.bme.mit.inf.modes3.components.controller.command.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.components.controller.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue

/**
 * The message handler of turnout related commands received on the subscribed
 * topic. This class transmits the received turnout commands to the actual
 * actuators, so the respective turnouts statuses can be queried.
 * 
 * @author benedekh, hegyibalint
 */
class TurnoutMessageHandler {

	// the actuator that can access the referred turnout
	val turnoutController = new ExpanderTurnoutController

	// segment state sender to the network
	var TrackElementStateSender trackElementStateSender

	new(TrackElementStateSender _trackElementStateSender) {
		trackElementStateSender = _trackElementStateSender
	}

	/**
	 * If the embedded controller manages the referred turnout, then its status will be queried and sent back.
	 * 
	 * @param turnoutId the turnout's ID whose status should be queried
	 */
	private def handleGetTurnoutStatus(int turnoutId) {
		if (turnoutController.controllerManagesTurnout(turnoutId)) {
			// TODO logging
			val turnoutStatus = turnoutController.getTurnoutStatus(turnoutId)
			val status = if (turnoutStatus == TurnoutStatus.STRAIGHT)
					TurnoutStateValue.STRAIGHT
				else
					TurnoutStateValue.DIVERGENT
			trackElementStateSender.sendTurnoutState(turnoutId, status)
		}
	}

}
