package hu.bme.mit.inf.modes3.components.controller.segment

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import java.util.concurrent.ConcurrentHashMap

abstract class CachedStateSegmentController extends SegmentCallBackController {
	val states = new ConcurrentHashMap<Integer, SegmentStateValue>
	
	override  onSegmentStateInfo(int id, SegmentStateValue state){
		if(!states.get(id)?.equals(state)){
			onSegmentStateChange(id, state)
		}
		states.put(id, state);
	}
	
	def getState(int id){
		val state = states.get(id)
		if(state == null){
			
			states.put(id, SegmentStateValue.ENABLED)
			return SegmentStateValue.ENABLED
			//TODO refresh
		}
		return state
	}
	
	def void onSegmentStateChange(int id, SegmentStateValue state);
	
}
