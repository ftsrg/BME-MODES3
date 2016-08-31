package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * The message handler of turnout related commands received on the subscribed
 * topic. This class transmits the received turnout commands to the actual
 * actuators, so the respective turnouts statuses can be queried.
 * 
 * @author benedekh, hegyibalint
 */
class TurnoutMessageHandler implements ITurnoutCommandListener {

	// the actuator that can access the referred turnout
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ExpanderTurnoutController turnoutController

	// to receive commands from the network
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ITrackElementCommandCallback commandCallback

	new(ITrackElementCommandCallback _commandCallback, ExpanderTurnoutController _turnoutController) {
		turnoutController = _turnoutController
		commandCallback = _commandCallback
		
		commandCallback.turnoutCommandListener = this
	}

	/**
	 * If the embedded controller manages the referred turnout, then it will be set straight.
	 * 
	 * @param turnoutId the turnout's ID that should be straight
	 */
	private def handleSetTurnoutStraight(int turnoutId) {
		if (turnoutController.controllerManagesSection(turnoutId)) {
			turnoutController.setTurnoutStraight(turnoutId)
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
		}
	}

	override onTurnoutCommand(int turnoutId, TurnoutState state) {
		switch (state) {
			case TurnoutState.STRAIGHT: handleSetTurnoutStraight(turnoutId)
			case TurnoutState.DIVERGENT: handleSetTurnoutDivergent(turnoutId)
		}
	}

}
