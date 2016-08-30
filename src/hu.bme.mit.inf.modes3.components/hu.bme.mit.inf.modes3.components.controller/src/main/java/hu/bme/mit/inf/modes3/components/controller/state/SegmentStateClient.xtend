package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder

package class SegmentStateClient implements SegmentStateHandler {
	private var TrackElementStateCallback callback
	
	new(TrackElementStateCallback controller){
		callback = controller
	}

	override handleMessage(SegmentStateOrBuilder message) {
		val id = message.segmentID
		val state = message.state
		callback.onSegmentState(id, state)
	} 
	
}
