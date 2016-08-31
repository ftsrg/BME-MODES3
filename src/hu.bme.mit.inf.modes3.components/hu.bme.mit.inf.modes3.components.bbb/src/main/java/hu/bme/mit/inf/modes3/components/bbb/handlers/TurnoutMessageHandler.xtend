package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.controller.command.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.components.controller.state.TrackElementStateSender

/**
 * The message handler of turnout related commands received on the subscribed
 * topic. This class transmits the received turnout commands to the actual
 * actuators, so the respective turnouts statuses can be queried.
 * 
 * @author benedekh, hegyibalint
 */
class TurnoutMessageHandler implements ITurnoutCommandListener {

	// the actuator that can access the referred turnout
	val turnoutController = new ExpanderTurnoutController

	// segment state sender to the network
	var TrackElementStateSender trackElementStateSender

	// to receive commands from the network
	var TrackElementCommandCallback commandCallback

	new(TrackElementStateSender _trackElementStateSender, TrackElementCommandCallback _commandCallback) {
		trackElementStateSender = _trackElementStateSender
		commandCallback = _commandCallback

		commandCallback.turnoutCommandListener = this
	}

	/**
	 * If the embedded controller manages the referred turnout, then its status will be queried and sent back.
	 * 
	 * @param turnoutId the turnout's ID whose status should be queried
	 */
	private def handleGetTurnoutStatus(int turnoutId) {
		if (turnoutController.controllerManagesTurnout(turnoutId)) {
			val turnoutStatus = turnoutController.getTurnoutStatus(turnoutId)
			trackElementStateSender.sendTurnoutState(turnoutId, turnoutStatus)
		}
	}

	/**
	 * If the embedded controller manages the referred turnout, then it will be set straight.
	 * 
	 * @param turnoutId the turnout's ID that should be straight
	 */
	private def handleSetTurnoutStraight(int turnoutId) {
		if (turnoutController.controllerManagesSection(turnoutId)) {
			turnoutController.setTurnoutStraight(turnoutId)
			trackElementStateSender.sendTurnoutState(turnoutId, TurnoutState.STRAIGHT)
		}
	}

	/**
	 * If the embedded controller manages the referred turnout, then it will be set divergent.
	 * 
	 * @param turnoutId the turnout's ID that should be divergent
	 */
	private def handleSetTurnoutDivergent(int turnoutId) {
		if (turnoutController.controllerManagesSection(turnoutId)) {
			turnoutController.setTurnoutDivergent(turnoutId)
			trackElementStateSender.sendTurnoutState(turnoutId, TurnoutState.DIVERGENT)
		}
	}

	override onTurnoutCommand(int turnoutId, TurnoutState state) {
		switch (state) {
			case TurnoutState.STRAIGHT: handleSetTurnoutStraight(turnoutId)
			case TurnoutState.DIVERGENT: handleSetTurnoutDivergent(turnoutId)
		}
	}

}
