package hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces

/**
 * A callback that registers a listener for the DCC states.
 * 
 * @author benedekh
 */
interface IDccStateCallback {
	/**
	 * Sets a listener for the DCC states. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setDccStateListener(IDccStateListener listener)
}