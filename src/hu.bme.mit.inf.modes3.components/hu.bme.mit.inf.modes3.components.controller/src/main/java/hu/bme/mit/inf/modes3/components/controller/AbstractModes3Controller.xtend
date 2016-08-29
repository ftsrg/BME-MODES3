package hu.bme.mit.inf.modes3.components.controller

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import java.util.HashMap

abstract class AbstractModes3Controller extends Modes3CallBackController {
	val states = new HashMap<Integer, SegmentStateValue>
	
	override onSegmentStateInfo(int id, SegmentStateValue state){
		if(states.get(id).equals(state)){
			onSegmentStateChange(id, state)
		}
		states.put(id, state);
	}
	
	def getState(int id){
		val state = states.get(id)
		if(state == null){
//			mms.sendMessage((SegmentControl.newBuilder => [
//			segmentID = segmentId;
//			controlState = state
//		]).build)
		}
		return state
	}
	
	def void onSegmentStateChange(int id, SegmentStateValue state);
	
}