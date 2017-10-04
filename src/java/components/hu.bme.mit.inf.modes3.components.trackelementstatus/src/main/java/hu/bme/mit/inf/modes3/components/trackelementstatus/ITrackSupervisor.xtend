package hu.bme.mit.inf.modes3.components.trackelementstatus

import hu.bme.mit.inf.modes3.components.trackelementstatus.wrapper.ITrackSupervisorWrapper
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITrackSupervisor {
	def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue)

	def void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue)
	
	def void setSupervisorWrapper(ITrackSupervisorWrapper supervisorWrapper)
}
