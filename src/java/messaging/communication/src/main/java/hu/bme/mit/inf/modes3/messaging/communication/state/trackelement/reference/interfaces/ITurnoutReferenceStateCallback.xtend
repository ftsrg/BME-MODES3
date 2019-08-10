package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces

/**
 * A callback that registers a listener for the turnout reference states.
 * 
 * @author benedekh
 */
interface ITurnoutReferenceStateCallback {
	/**
	 * Sets a listener for the turnout reference states. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setTurnoutReferenceStateListener(ITurnoutReferenceStateListener turnoutReferenceStateListener)
}
