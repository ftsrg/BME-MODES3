package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces

/**
 * A callback that registers a listener for the send all status command.
 * 
 * @author benedekh
 */
interface ISendAllStatusCommandCallback {
	/**
	 * Sets a listener for the send all status command. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setSendAllStatusListener(ISendAllStatusListener listener)
}