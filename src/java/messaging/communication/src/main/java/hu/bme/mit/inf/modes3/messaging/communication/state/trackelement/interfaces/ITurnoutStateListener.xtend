package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * A listener for the turnout's state.
 * 
 * @author benedekh
 */
interface ITurnoutStateListener {
	/**
	 * Processes the turnout state.
	 * 
	 * @param id the ID of the turnout
	 * @param state the state of the turnout
	 */
	def void onTurnoutState(int id, TurnoutState state)
}
