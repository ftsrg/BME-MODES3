package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder

class SampleComponent implements SegmentStateHandler {
	
	//protected def SampleComponent() { }
	
	private MessagingService mms;
	
	new(MessagingService _mms) {
		this.mms = _mms
		mms.segmentStateHandler = this
		mms.start
	}
	
	override handleSegmentState(SegmentStateOrBuilder event) {
		println('SegmentStateHandler called')
		println(event)
		
		//decision(event)
	}
	
	def void sendSegmentControlMessage() {
		decision(true)
	}
	
	private def decision(boolean sendMessage) {
		if (sendMessage) {
			val message = SegmentControl.newBuilder
			message.segmentID = 12
			message.controlState = SegmentControl.ControlState.DISABLE
			
			mms.sendMessage(message.build)
		}
	}
	
}