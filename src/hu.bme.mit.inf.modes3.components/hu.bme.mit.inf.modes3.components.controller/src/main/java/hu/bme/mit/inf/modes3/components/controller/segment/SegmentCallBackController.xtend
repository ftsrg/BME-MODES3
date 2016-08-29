package hu.bme.mit.inf.modes3.components.controller.segment

import hu.bme.mit.inf.modes3.components.common.AbstractComponent
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState

abstract class SegmentCallBackController extends AbstractComponent {

	override init(){
		val dispatcher = new ProtobufMessageDispatcher
		val segmentStateListener = new SegmentStateListener(this)
		val segmentCommandListener = new SegmentControlListener(this)
		dispatcher.segmentStateHandler = segmentStateListener
		dispatcher.segmentControlHandler = segmentCommandListener 
	}
	

	
	def void onSegmentStateInfo(int id, SegmentStateValue state);
	def void onSegmentControlInfo(int id, SegmentStateValue state);
	
	
	def sendSegmentControlState(int segmentId, SegmentStateValue state){
		mms.sendMessage((SegmentControl.newBuilder => [
			segmentID = segmentId;
			controlState = state
		]).build)
	}
	
	def sendSegmentControlState(int segmentId, boolean isEnabled) {
		sendSegmentControlState(segmentId, if(isEnabled) SegmentStateValue.ENABLED else SegmentStateValue.DISABLED)
	}
	

	
	def sendSegmentStateInfo(int segmentId, SegmentStateValue state){
		mms.sendMessage((SegmentState.newBuilder => [
			segmentID = segmentId
			it.state = state
		]).build)
	}
	
	def sendSegmentStateInfo(int segmentId, boolean isEnabled){
		sendSegmentStateInfo(segmentId, if(isEnabled) SegmentStateValue.ENABLED else SegmentStateValue.DISABLED)
	}
	

}
