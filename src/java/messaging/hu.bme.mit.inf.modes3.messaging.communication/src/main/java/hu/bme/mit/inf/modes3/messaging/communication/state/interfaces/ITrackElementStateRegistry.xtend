package hu.bme.mit.inf.modes3.messaging.communication.state.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import java.util.List

interface ITrackElementStateRegistry {
	def TurnoutState getTurnoutState(int id)
	def SegmentState getSegmentState(int id)
	def SegmentOccupancy getSegmentOccupancy(int id)
	
	def List<Integer> getSegments()
	
	def List<Integer> getTurnouts()
	
	def void setTurnoutStateChangeListener(ITurnoutStateChangeListener listener)
	def void setSegmentStateChangeListener(ISegmentStateChangeListener listener)
	def void setSegmentOccupancyChangeListener(ISegmentOccupancyChangeListener listener)
}
