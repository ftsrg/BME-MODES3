package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces

/**
 * A callback that registers a listener for the turnout and the segment commands.
 * 
 * @author baloghlaszlo, benedekh
 */
interface ITrackElementCommandCallback {
	/**
	 * Sets a listener for the segment commands. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setSegmentCommandListener(ISegmentCommandListener listener)
	/**
	 * Sets a listener for the turnout commands. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setTurnoutCommandListener(ITurnoutCommandListener listener)
}
