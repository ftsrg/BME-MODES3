package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * Sends the turnout's reference state.
 * 
 * @author benedekh
 */
interface ITurnoutReferenceStateSender {
	/**
	 * Sends the turnout's reference state.
	 * 
	 * @param id the ID of the turnout
	 * @param state the reference state of the turnout
	 */
	def void sendTurnoutReferenceState(int id, TurnoutState state)
}
