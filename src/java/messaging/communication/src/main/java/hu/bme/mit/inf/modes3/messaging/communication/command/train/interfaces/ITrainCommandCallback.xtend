package hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces

/**
 * A callback that registers a listener for the train commands.
 * 
 * @author benedekh
 */
interface ITrainCommandCallback {
	/**
	 * Sets a listener for the train reference speed command.
	 * 
	 * @param listener the listener to be set
	 */
	def void setTrainReferenceSpeedCommandListener(ITrainReferenceSpeedCommandListener listener)
}
