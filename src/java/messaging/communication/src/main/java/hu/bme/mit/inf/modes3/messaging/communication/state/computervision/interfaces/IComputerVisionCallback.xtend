package hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces

/**
 * A callback that registers a listener for the Computer Vision Informations.
 * 
 * @author benedekh
 */
interface IComputerVisionCallback {
	/**
	 * Sets a listener for the Computer Vision Informations. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setComputerVisionListener(IComputerVisionListener listener)
}
