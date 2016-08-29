package hu.bme.mit.inf.modes3.components.controller

import hu.bme.mit.inf.modes3.components.common.AbstractComponent
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder

abstract class Modes3CallBackController extends AbstractComponent implements SegmentStateHandler{

	override init(){
		val dispatcher = new ProtobufMessageDispatcher
		dispatcher.segmentStateHandler = this
	}
	
	override handleMessage(SegmentStateOrBuilder message) {
		val id = message.segmentID
		val state = message.state
		onSegmentStateInfo(id, state)
	}
	
	def void onSegmentStateInfo(int id, SegmentStateValue state);
	
	
	def sendSegmentState(int segmentId, SegmentStateValue state){
		mms.sendMessage((SegmentControl.newBuilder => [
			segmentID = segmentId;
			controlState = state
		]).build)
	}
	
	def sendSegmentState(int segmentId, boolean isEnabled) {
		sendSegmentState(segmentId, if(isEnabled) SegmentStateValue.ENABLED else SegmentStateValue.DISABLED)
	}

}