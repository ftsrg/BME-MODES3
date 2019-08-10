package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * A listener that is called if a turnout's state has changed.
 * 
 * @author benedekh
 */
interface ITurnoutStateChangeListener {
	/**
	 * Processes the change of the turnout's state.
	 * 
	 * @param id the ID of the turnout
	 * @param oldValue the old state of the turnout
	 * @param newValue the new state of the turnout
	 */
	def void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue)
}
