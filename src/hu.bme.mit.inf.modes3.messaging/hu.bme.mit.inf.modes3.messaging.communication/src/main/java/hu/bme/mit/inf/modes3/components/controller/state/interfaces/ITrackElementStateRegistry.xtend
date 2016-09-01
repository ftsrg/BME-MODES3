package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentOccupancy

interface ITrackElementStateRegistry {
	def TurnoutState getTurnoutState(int id)
	def SegmentState getSegmentState(int id)
	def SegmentOccupancy getSegmentOccupancy(int id)
	
	def void setTurnoutStateChangeListener(ITurnoutStateChangeListener listener)
	def void setSegmentStateChangeListener(ISegmentStateChangeListener listener)
	def void setSegmentOccupancyChangeListener(ISegmentOccupancyChangeListener listener)
}