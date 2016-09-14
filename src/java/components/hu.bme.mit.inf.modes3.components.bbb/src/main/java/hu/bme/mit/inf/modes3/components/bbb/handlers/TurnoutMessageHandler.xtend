package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState

/**
 * This class transmits the received turnout commands to the actual
 * actuators, so the respective turnouts statuses can be queried.
 * 
 * @author benedekh, hegyibalint
 */
package class TurnoutMessageHandler implements ITurnoutCommandListener {

	// the actuator that can access the referred turnout
	protected val ITurnoutControllerStrategy turnoutController

	new(ITrackElementCommandCallback commandCallback, ITurnoutControllerStrategy _turnoutController) {
		turnoutController = _turnoutController
		commandCallback.turnoutCommandListener = this
	}

	/**
	 * If the embedded controller manages the referred turnout, then it will be set straight.
	 * 
	 * @param turnoutId the turnout's ID that should be straight
	 */
	private def handleSetTurnoutStraight(int turnoutId) {
		if (turnoutController.controllerManagesTurnout(turnoutId)) {
			turnoutController.setTurnoutStraight(turnoutId)
		}
	}

	/**
	 * If the embedded controller manages the referred turnout, then it will be set divergent.
	 * 
	 * @param turnoutId the turnout's ID that should be divergent
	 */
	private def handleSetTurnoutDivergent(int turnoutId) {
		if (turnoutController.controllerManagesTurnout(turnoutId)) {
			turnoutController.setTurnoutDivergent(turnoutId)
		}
	}

	override onTurnoutCommand(int turnoutId, TurnoutState state) {
		switch (state) {
			case TurnoutState.STRAIGHT: handleSetTurnoutStraight(turnoutId)
			case TurnoutState.DIVERGENT: handleSetTurnoutDivergent(turnoutId)
		}
	}

}
