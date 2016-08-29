package hu.bme.mit.inf.modes3.components.sample3

import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.SegmentControlHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControlOrBuilder

class SegmentControlReader implements SegmentControlHandler {
	var AbstractSegmentController delegateTo 
	new(AbstractSegmentController to){
		delegateTo = to
	}
	
	override handleMessage(SegmentControlOrBuilder message) {
		val id = message.segmentID
		val state = message.controlState
		delegateTo.onSegmentStateChange(id, state)
	}
}