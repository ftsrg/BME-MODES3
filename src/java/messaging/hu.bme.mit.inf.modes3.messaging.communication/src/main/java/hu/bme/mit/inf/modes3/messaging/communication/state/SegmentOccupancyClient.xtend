package hu.bme.mit.inf.modes3.messaging.communication.state

import hu.bme.mit.inf.modes3.messaging.communication.enums.EnumTransformator
import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentOccupancyHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancyOrBuilder

class SegmentOccupancyClient implements SegmentOccupancyHandler {
	private var TrackElementStateCallback callback
	
	new(TrackElementStateCallback controller){
		callback = controller
	}
	
	override handleMessage(SegmentOccupancyOrBuilder message) {
		val id = message.segmentID
		val state = EnumTransformator.toGeneral(message.state)
		callback.onSegmentOccupancy(id, state)
	}
}
