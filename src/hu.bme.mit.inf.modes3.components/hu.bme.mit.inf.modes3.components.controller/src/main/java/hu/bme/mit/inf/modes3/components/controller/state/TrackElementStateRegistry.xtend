package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors

class TrackElementStateRegistry {
	val segments = new ConcurrentHashMap<Integer, SegmentStateValue>
	val turnouts = new ConcurrentHashMap<Integer, TurnoutStateValue>

	//TODO remove this accessor somehow
	@Accessors(PACKAGE_GETTER, PACKAGE_SETTER) TrackElementStateCallback trackElementStateCallback = new TrackElementStateCallback(new ISegmentStateListener() {

		override onSegmentState(int id, SegmentStateValue state) {
			if(segments.get(id) != state) {
				segmentStateChangeListener.onSegmentStateChange(id, segments.get(id), state)
				segments.put(id, state)
			}
		}

	}, new ITurnoutStateListener() {

		override onTurnoutState(int id, TurnoutStateValue state) {
			if(turnouts.get(id) != state) {
				turnoutStateChangeListener.onTurnoutStateChange(id, turnouts.get(id), state)
				turnouts.put(id, state)
			}
		}

	})

	var ITurnoutStateChangeListener turnoutStateChangeListener
	var ISegmentStateChangeListener segmentStateChangeListener

	new(ISegmentStateChangeListener segmentStateChangeListener, ITurnoutStateChangeListener turnoutChangeListener) {
		this.segmentStateChangeListener = segmentStateChangeListener
		this.turnoutStateChangeListener = turnoutChangeListener
	}

	new() {
		this.segmentStateChangeListener = new ISegmentStateChangeListener() {
			override onSegmentStateChange(int id, SegmentStateValue oldValue, SegmentStateValue newValue) {
			}
		}
		this.turnoutStateChangeListener = new ITurnoutStateChangeListener() {
			override onTurnoutStateChange(int id, TurnoutStateValue oldValue, TurnoutStateValue newValue) {
			}
		}
		trackElementStateCallback.class // just to remove the unused warning on this field
	}

	new(ISegmentStateChangeListener segmentStateChangeListener) {
		this.segmentStateChangeListener = segmentStateChangeListener
		this.turnoutStateChangeListener = new ITurnoutStateChangeListener() {
			override onTurnoutStateChange(int id, TurnoutStateValue oldValue, TurnoutStateValue newValue) {
			}
		}
	}

	new(ITurnoutStateChangeListener turnoutStateChangeListener) {
		this.turnoutStateChangeListener = turnoutStateChangeListener
		this.segmentStateChangeListener = new ISegmentStateChangeListener() {
			override onSegmentStateChange(int id, SegmentStateValue oldValue, SegmentStateValue newValue) {
			}
		}
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
