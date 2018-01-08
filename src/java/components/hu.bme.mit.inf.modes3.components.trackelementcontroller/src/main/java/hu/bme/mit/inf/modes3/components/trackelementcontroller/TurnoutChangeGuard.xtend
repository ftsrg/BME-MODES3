package hu.bme.mit.inf.modes3.components.trackelementcontroller

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import hu.bme.mit.inf.modes3.utils.conf.SegmentDirection

class TurnoutChangeGuard {

	val int turnoutId
	val ITrackElementStateRegistry registry

	new(int turnoutId, ITrackElementStateRegistry registry) {
		this.turnoutId = turnoutId
		this.registry = registry
	}

	/**
	 * Direction change is allowed if neither the turnout, nor the facing segments are occupied. 
	 */
	def isDirectionChangeAllowed() {
		val turnoutSegmentIds = LayoutConfiguration.INSTANCE.getSegmentIdsOfTurnout(turnoutId)
		val facingSegment = LayoutConfiguration.INSTANCE.getTurnoutVicinitySegmentsByDirection(turnoutId, SegmentDirection.FACING)

		val segmentIds = newHashSet
		segmentIds.addAll(turnoutSegmentIds)
		segmentIds.addAll(facingSegment)

		return segmentIds.forall[registry.getSegmentOccupancy(it) == SegmentOccupancy.FREE]
	}
}
