package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentStateListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITurnoutStateListener
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancyValue
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentOccupancyListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentOccupancyChangeListener

class TrackElementStateRegistry {
	val segments = new ConcurrentHashMap<Integer, SegmentStateValue>
	val turnouts = new ConcurrentHashMap<Integer, TurnoutStateValue>
	val occupancy = new ConcurrentHashMap<Integer, SegmentOccupancyValue>

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

	}, new ISegmentOccupancyListener() {
		override onSegmentOccupancy(int id, SegmentOccupancyValue state) {
			if(occupancy.get(id) != state) {
				segmentOccupancyListener.onSegmentOccupancyChange(id, occupancy.get(id), state)
				occupancy.put(id, state)
			}
		}

	})

	@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) var ITurnoutStateChangeListener turnoutStateChangeListener
	@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) var ISegmentStateChangeListener segmentStateChangeListener
	@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) var ISegmentOccupancyChangeListener segmentOccupancyListener

	new(ISegmentStateChangeListener segmentStateChangeListener, ITurnoutStateChangeListener turnoutChangeListener, ISegmentOccupancyChangeListener segmentOccupancyListener) {
		this.segmentStateChangeListener = segmentStateChangeListener
		this.turnoutStateChangeListener = turnoutChangeListener
		this.segmentOccupancyListener = segmentOccupancyListener
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
