package hu.bme.mit.inf.modes3.messaging.communication.state.interfaces

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState

interface ITrackElementStateRegistry {
	def TurnoutState getTurnoutState(int id)
	def SegmentState getSegmentState(int id)
	def SegmentOccupancy getSegmentOccupancy(int id)
	
	def void setTurnoutStateChangeListener(ITurnoutStateChangeListener listener)
	def void setSegmentStateChangeListener(ISegmentStateChangeListener listener)
	def void setSegmentOccupancyChangeListener(ISegmentOccupancyChangeListener listener)
}
