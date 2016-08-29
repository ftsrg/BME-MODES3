package hu.bme.mit.inf.modes3.components.controller.segment

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import java.util.concurrent.ConcurrentHashMap

class CachedStateSegmentController extends SegmentCallBackController {
	val states = new ConcurrentHashMap<Integer, SegmentStateValue>
	var SegmentStateChangeListener segmentStateChangeListener
	var SegmentControlInfoListener segmentControlInfoListener
	
	new(SegmentStateChangeListener segmentStateChangeListener){
		this.segmentStateChangeListener = segmentStateChangeListener
	}

	override onSegmentStateInfo(int id, SegmentStateValue state) {
		if(!states.get(id)?.equals(state)) {
			segmentStateChangeListener.onSegmentStateChange(id, state)
		}
		states.put(id, state);
	}

	def getState(int id) {
		val state = states.get(id)
		if(state == null) {

			states.put(id, SegmentStateValue.ENABLED)
			return SegmentStateValue.ENABLED
		// TODO refresh
		}
		return state
	}
	
	override onSegmentControlInfo(int id, SegmentStateValue state) {
		segmentControlInfoListener.onSegmentControlInfo(id, state)
	}

	

}
