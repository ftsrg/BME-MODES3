package hu.bme.mit.inf.modes3.components.controller.segment

import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.SegmentControlHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControlOrBuilder

package class SegmentControlListener implements SegmentControlHandler {
	private var SegmentCallBackController callback
	
	new(SegmentCallBackController controller){
		callback = controller
	}
	
	
	override handleMessage(SegmentControlOrBuilder message) {
		val id = message.segmentID
		val state = message.controlState
		callback.onSegmentControlInfo(id, state)
	}
	
}
