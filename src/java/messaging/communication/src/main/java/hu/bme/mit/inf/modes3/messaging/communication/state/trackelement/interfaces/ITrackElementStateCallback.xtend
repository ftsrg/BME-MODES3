package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

/**
 * A callback that registers listeners for the track element (section or turnout = segment) states.
 * 
 * @author benedekh
 */
interface ITrackElementStateCallback {
	/**
	 * Sets a listener for the segment states. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setSegmentStateListener(ISegmentStateListener segmentStateListener)


	/**
	 * Sets a listener for the turnout states. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setTurnoutStateListener(ITurnoutStateListener turnoutStateListener)


	/**
	 * Sets a listener for the segment occupancy. 
	 * 
	 * @param listener the listener to be set
	 */
	def void setSegmentOccupancyListener(ISegmentOccupancyListener segmentOccupancyListener)
}
