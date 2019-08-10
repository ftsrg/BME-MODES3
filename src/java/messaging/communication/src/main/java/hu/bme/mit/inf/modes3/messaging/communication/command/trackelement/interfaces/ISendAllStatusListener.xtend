package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces

/**
 * A listener for the send all status command. 
 * 
 * @author benedekh
 */
interface ISendAllStatusListener {
	/**
	 * Executes the actions that are triggered by the command. 
	 */
	def void onSendAllStatus();
}
