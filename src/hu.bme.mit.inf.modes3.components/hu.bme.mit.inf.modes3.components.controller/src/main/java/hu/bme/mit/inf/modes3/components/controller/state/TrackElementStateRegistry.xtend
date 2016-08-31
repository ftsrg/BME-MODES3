package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentOccupancyListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentStateListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITurnoutStateListener
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors

class TrackElementStateRegistry {
	val segments = new ConcurrentHashMap<Integer, SegmentState>
	val turnouts = new ConcurrentHashMap<Integer, TurnoutState>
	val occupancy = new ConcurrentHashMap<Integer, SegmentOccupancy>
	@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) var ITurnoutStateChangeListener turnoutStateChangeListener
	@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) var ISegmentStateChangeListener segmentStateChangeListener
	@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) var ISegmentOccupancyChangeListener segmentOccupancyChangeListener
	@Accessors(PACKAGE_GETTER, PACKAGE_SETTER) TrackElementStateCallback trackElementStateCallback = new TrackElementStateCallback(new ISegmentStateListener() {

		override onSegmentState(int id, SegmentState state) {
			if(segments.get(id) != state) {
				segmentStateChangeListener.onSegmentStateChange(id, segments.get(id), state)
				segments.put(id, state)
			}
		}

	}, new ITurnoutStateListener() {

		override onTurnoutState(int id, TurnoutState state) {
			if(turnouts.get(id) != state) {
				turnoutStateChangeListener.onTurnoutStateChange(id, turnouts.get(id), state)
				turnouts.put(id, state)
			}
		}

	}, new ISegmentOccupancyListener() {
		override onSegmentOccupancy(int id, SegmentOccupancy state) {
			if(occupancy.get(id) != state) {
				segmentOccupancyChangeListener.onSegmentOccupancyChange(id, occupancy.get(id), state)
				occupancy.put(id, state)
			}
		}

	})

	new(ISegmentStateChangeListener segmentStateChangeListener, ITurnoutStateChangeListener turnoutChangeListener, ISegmentOccupancyChangeListener segmentOccupancyChangeListener) {
		this.segmentStateChangeListener = segmentStateChangeListener
		this.turnoutStateChangeListener = turnoutChangeListener
		this.segmentOccupancyChangeListener = segmentOccupancyChangeListener
	}

	def getSegmentState(int id) {
		if(segments.get(id) == null) {
			// TODO send msg to query the current state
			synchronized(segments) {
				if(segments.get(id) == null) {
					segments.put(id, SegmentState.ENABLED)
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
					turnouts.put(id, TurnoutState.DIVERGENT)
				}
			}
		}
		turnouts.get(id)
	}

}
