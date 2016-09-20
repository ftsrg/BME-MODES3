package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * This class transmits the received turnout commands to the actual
 * actuators, so the respective turnouts statuses can be queried.
 * 
 * @author benedekh, hegyibalint
 */
package class TurnoutMessageHandler implements ITurnoutCommandListener {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	// the actuator that can access the referred turnout
	protected val ITurnoutControllerStrategy turnoutController

	new(ITrackElementCommandCallback commandCallback, ITurnoutControllerStrategy _turnoutController, ILoggerFactory factory) {
		turnoutController = _turnoutController
		commandCallback.turnoutCommandListener = this

		this.logger = factory.getLogger(this.class.name)
	}

	/**
	 * If the embedded controller manages the referred turnout, then it will be set straight.
	 * 
	 * @param turnoutId the turnout's ID that should be straight
	 */
	private def handleSetTurnoutStraight(int turnoutId) {
		if(turnoutController.controllerManagesTurnout(turnoutId)) {
			turnoutController.setTurnoutStraight(turnoutId)
		}
	}

	/**
	 * If the embedded controller manages the referred turnout, then it will be set divergent.
	 * 
	 * @param turnoutId the turnout's ID that should be divergent
	 */
	private def handleSetTurnoutDivergent(int turnoutId) {
		if(turnoutController.controllerManagesTurnout(turnoutId)) {
			turnoutController.setTurnoutDivergent(turnoutId)
		}
	}

	override onTurnoutCommand(int turnoutId, TurnoutState state) {
		logger.info('''Turnout ''' + turnoutId + ''' command ''' + state + ''' received.''')

		switch (state) {
			case TurnoutState.STRAIGHT: handleSetTurnoutStraight(turnoutId)
			case TurnoutState.DIVERGENT: handleSetTurnoutDivergent(turnoutId)
		}
	}

}
