package hu.bme.mit.inf.modes3.components.barrier

import hu.bme.mit.inf.modes3.components.barrier.wrapper.ITrackSupervisorWrapper
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy

interface ITrackSupervisor {
	def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue)

	def void setSupervisorWrapper(ITrackSupervisorWrapper supervisorWrapper)
}
