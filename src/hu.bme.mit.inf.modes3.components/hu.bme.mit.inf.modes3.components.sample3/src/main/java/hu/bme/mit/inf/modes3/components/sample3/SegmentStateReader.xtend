package hu.bme.mit.inf.modes3.components.sample3

import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder

class SegmentStateReader implements SegmentStateHandler {
	var AbstractSegmentController delegateTo 
	new(AbstractSegmentController to){
		delegateTo = to
	}
	
	
	
	override handleMessage(SegmentStateOrBuilder message) {
		val id = message.segmentID
		val state = message.state
		delegateTo.onSegmentStateChange(id, state)
	}
	
}