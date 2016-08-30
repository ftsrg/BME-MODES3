package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import java.util.concurrent.ConcurrentHashMap

class TrackElementStateRegistry implements ISegmentStateListener, ITurnoutStateListener {
	val segments = new ConcurrentHashMap<Integer, SegmentStateValue>
	val turnouts = new ConcurrentHashMap<Integer, TurnoutStateValue>

	val TrackElementStateCallback callback = new TrackElementStateCallback(this, this)

	override onSegmentState(int id, SegmentStateValue state) {
		segments.put(id, state)
	}

	override onTurnoutState(int id, TurnoutStateValue state) {
		turnouts.put(id, state)
	}

	def getSegmentState(int id) {
		if(segments.get(id) == null) {
			// TODO send msg to query the current state
			synchronized(segments) {
				if(segments.get(id) == null) {
					segments.put(id, SegmentStateValue.ENABLED)
				}
			}
		}
		segments.get(id)
	}

	def getTurnoutState(int id) {
		if(turnouts.get(id) == null) {
			// TODO send msg to query the current state
			synchronized(turnouts) {
				if(turnouts.get(id) == null) {
					turnouts.put(id, TurnoutStateValue.DIVERGENT)
				}
			}
		}
		turnouts.get(id)
	}

}
