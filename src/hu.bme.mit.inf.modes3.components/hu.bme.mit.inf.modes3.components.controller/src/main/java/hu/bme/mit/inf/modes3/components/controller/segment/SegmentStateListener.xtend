package hu.bme.mit.inf.modes3.components.controller.segment

import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder

package class SegmentStateListener implements SegmentStateHandler {
	private var SegmentCallBackController callback
	
	new(SegmentCallBackController controller){
		callback = controller
	}

	override handleMessage(SegmentStateOrBuilder message) {
		val id = message.segmentID
		val state = message.state
		callback.onSegmentStateInfo(id, state)
	} 
	
}
