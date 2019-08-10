package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * A listener for the {@link TurnoutState}. 
 * 
 * @author benedekh
 */
interface ITurnoutReferenceStateListener {
	/**
	 * Processes the turnout reference state.
	 * 
	 * @param id the ID of the turnout
	 * @param state the state of the turnout
	 */
	def void onTurnoutReferenceState(int id, TurnoutState state)
}
