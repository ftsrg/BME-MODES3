package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.components.common.ProtobufAbstractComponent
import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue

class SampleComponent extends ProtobufAbstractComponent implements SegmentStateHandler {
	
	override void onInit() {
		dispatcher.segmentStateHandler = this
	}
	
	def void sendSegmentControlMessage() {
		decision(true)
	}
	
	private def decision(boolean sendMessage) {
		if (sendMessage) {
			val message = SegmentCommand.newBuilder
			message.segmentID = 12
			message.state = SegmentStateValue.DISABLED
			 
			mms.sendMessage(message.build)
		}
	}
	
	override handleMessage(SegmentStateOrBuilder message) {
		println(
		'''SegmentState handler called')
		
		=================
		Protobuf message:
		-----------------
		«message»
		=================''')
		
	}
	
}
