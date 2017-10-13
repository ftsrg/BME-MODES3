package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

interface ITrackElementStateCallback {
	def void setSegmentStateListener(ISegmentStateListener segmentStateListener)

	def void setTurnoutStateListener(ITurnoutStateListener turnoutStateListener)

	def void setSegmentOccupancyListener(ISegmentOccupancyListener segmentOccupancyListener)
}
