package hu.bme.mit.inf.modes3.components.trackelementstatus

import hu.bme.mit.inf.modes3.components.trackelementstatus.wrapper.ITrackSupervisorWrapper
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import org.eclipse.xtend.lib.annotations.Accessors

class TrackSupervisor implements ITrackSupervisor {

	val ConcurrentMap<Integer, SegmentOccupancy> segmentOccupancyStatuses
	val ConcurrentMap<Integer, TurnoutState> turnoutStatuses

	@Accessors(PUBLIC_SETTER) var ITrackSupervisorWrapper supervisorWrapper

	new() {
		this.segmentOccupancyStatuses = new ConcurrentHashMap<Integer, SegmentOccupancy>
		this.turnoutStatuses = new ConcurrentHashMap<Integer, TurnoutState>
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		segmentOccupancyStatuses.put(id, newValue)
		supervisorWrapper.sendSegmentStatusMessage(id, newValue.toString.toLowerCase)
	}

	override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		turnoutStatuses.put(id, newValue)
		supervisorWrapper.sendTurnoutStatusMessage(id, newValue.toString.toLowerCase)
	}

}
