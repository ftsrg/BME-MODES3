package hu.bme.mit.inf.modes3.components.sample3

import hu.bme.mit.inf.modes3.components.common.AbstractComponent
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.SegmentControlHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControlOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.MessageOrBuilder

abstract class AbstractSegmentController extends AbstractComponent{

	override init(){
		val segmentControlReader = new SegmentControlReader(this)
		val segmentStateReader = new SegmentStateReader(this)
		val dispatcher = new ProtobufMessageDispatcher
		dispatcher.segmentControlHandler = segmentControlReader
		dispatcher.segmentStateHandler = segmentStateReader
		
	}
	
	def void onSegmentStateChange(int id, SegmentControl.ControlState state);
	




	

	def sendSegmentState(int segmentId, SegmentControl.ControlState state){
		mms.sendMessage((SegmentControl.newBuilder => [
			segmentID = segmentId;
			controlState = state
		]).build)
	}
	
	def sendSegmentState(int segmentId, boolean isEnabled) {
		sendSegmentState(segmentId, if(isEnabled) SegmentControl.ControlState.ENABLE else SegmentControl.ControlState.DISABLE)
	}

}
