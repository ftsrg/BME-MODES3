package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces

/**
 * A callback that registers a listener for the train speed states.
 * 
 * @author benedekh
 */
interface ITrainSpeedStateCallback {
	/**
	 * Sets a listener for the train speed states. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setTrainSpeedStateListener(ITrainSpeedStateListener trainReferenceSpeedListener)
}
