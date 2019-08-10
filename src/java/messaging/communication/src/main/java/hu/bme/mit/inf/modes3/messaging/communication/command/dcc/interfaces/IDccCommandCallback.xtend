package hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces

/**
 * A callback that registers a listener for the DCC commands.
 * 
 * @author benedekh
 */
interface IDccCommandCallback {
	/**
	 * Sets a listener for the DCC commands. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setDccCommandListener(IDccCommandListener listener)
}
