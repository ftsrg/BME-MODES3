package hu.bme.mit.inf.modes3.messaging.communication.state

import hu.bme.mit.inf.modes3.messaging.communication.enums.EnumTransformator
import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder

package class SegmentStateClient implements SegmentStateHandler {
	private var TrackElementStateCallback callback
	
	new(TrackElementStateCallback controller){
		callback = controller
	}

	override handleMessage(SegmentStateOrBuilder message) {
		val id = message.segmentID
		val state = EnumTransformator.toGeneral(message.state)
		callback.onSegmentState(id, state)
	} 
	
}
