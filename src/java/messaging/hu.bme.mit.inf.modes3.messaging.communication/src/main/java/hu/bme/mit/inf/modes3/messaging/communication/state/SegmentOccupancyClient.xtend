package hu.bme.mit.inf.modes3.messaging.communication.state

import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

class SegmentOccupancyClient implements IMessageHandler<SegmentOccupancyMessage> {
	private var TrackElementStateCallback callback

	new(TrackElementStateCallback controller) {
		callback = controller
	}

	override handleMessage(SegmentOccupancyMessage message) {
		val id = message.segmentId
		val state = message.state
		callback.onSegmentOccupancy(id, state)
	}
}
