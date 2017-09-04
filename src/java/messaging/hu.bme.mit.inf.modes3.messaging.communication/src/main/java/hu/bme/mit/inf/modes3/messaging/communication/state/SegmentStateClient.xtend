package hu.bme.mit.inf.modes3.messaging.communication.state

import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class SegmentStateClient implements IMessageHandler<SegmentStateMessage> {
	private var TrackElementStateCallback callback

	new(TrackElementStateCallback controller) {
		callback = controller
	}

	override handleMessage(SegmentStateMessage message) {
		val id = message.segmentId
		val state = message.state
		callback.onSegmentState(id, state)
	}

}
