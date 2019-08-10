package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * An in-memory cache that notifies the listeners if the reference state of a turnout has changed.
 * 
 * @author benedekh
 */
interface ITurnoutReferenceStateRegistry {
	/**
	 * @param id the ID of the turnout
	 * @return the recent reference state of the turnout
	 */
	def TurnoutState getTurnoutReferenceState(int id)
	
	/**
	 * Registers a turnout reference state change listener.
	 * 
	 * @param listener the listener to be registered
	 */
	def void setTurnoutReferenceStateChangeListener(ITurnoutReferenceStateChangeListener listener)
}
