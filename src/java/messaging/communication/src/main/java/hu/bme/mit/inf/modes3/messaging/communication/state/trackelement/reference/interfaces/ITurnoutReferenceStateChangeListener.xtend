package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * A listener for the change of {@link TurnoutState}. 
 * 
 * @author benedekh
 */
interface ITurnoutReferenceStateChangeListener {
	/**
	 * Processes the change of the turnout's reference state.
	 * 
	 * @param id the ID of the turnout
	 * @param oldValue the old reference state of the turnout
	 * @param newValue the new reference state of the turnout
	 */
	def void onTurnoutReferenceStateChange(int id, TurnoutState oldValue, TurnoutState newValue)
}
