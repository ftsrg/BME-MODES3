package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.components.common.AbstractComponent
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue

class SampleComponent extends AbstractComponent implements SegmentStateHandler {
	
	override void init() {
		val dispatcher = new ProtobufMessageDispatcher
		dispatcher.segmentStateHandler = this
		
		super.dispatcher = dispatcher
		super.start		
	}
	
	def void sendSegmentControlMessage() {
		decision(true)
	}
	
	private def decision(boolean sendMessage) {
		if (sendMessage) {
			val message = SegmentControl.newBuilder
			message.segmentID = 12
			message.controlState = SegmentStateValue.DISABLED
			
			mms.sendMessage(message.build)
		}
	}
	
	override handleMessage(SegmentStateOrBuilder message) {
		println('SegmentState handler called')
		
		println('=================')
		println('Protobuf message:')
		println('-----------------')
		print(message)
		println('=================')
		
	}
	
}
