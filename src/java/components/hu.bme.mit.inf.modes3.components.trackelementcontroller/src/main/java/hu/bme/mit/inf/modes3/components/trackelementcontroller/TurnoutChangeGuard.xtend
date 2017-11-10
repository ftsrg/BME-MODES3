package hu.bme.mit.inf.modes3.components.trackelementcontroller

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration

class TurnoutChangeGuard {

	val int turnoutId
	val ITrackElementStateRegistry registry

	new(int turnoutId, ITrackElementStateRegistry registry) {
		this.turnoutId = turnoutId
		this.registry = registry
	}

	/**
	 * Direction change is allowed if neither the turnout, nor the segments (which are connected by recent direction) are occupied. 
	 */
	def isDirectionChangeAllowed(TurnoutState recentDirection) {
		val turnoutSegmentIds = LayoutConfiguration.INSTANCE.getSegmentIdsOfTurnout(turnoutId)
		val connectedSegments = LayoutConfiguration.INSTANCE.getConnectedSegmentsByTurnoutVicinities(turnoutId, recentDirection.toString)

		val segmentIds = newHashSet
		segmentIds.addAll(turnoutSegmentIds)
		segmentIds.addAll(connectedSegments)

		return segmentIds.forall[registry.getSegmentOccupancy(it) == SegmentOccupancy.FREE]
	}
}
