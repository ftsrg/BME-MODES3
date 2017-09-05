package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import java.util.ArrayList
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrackElementStateRegistry implements ITrackElementStateRegistry {
	val segments = new ConcurrentHashMap<Integer, SegmentState>
	val turnouts = new ConcurrentHashMap<Integer, TurnoutState>
	val occupancy = new ConcurrentHashMap<Integer, SegmentOccupancy>
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	@Accessors(#[PRIVATE_GETTER, PUBLIC_SETTER]) var ITurnoutStateChangeListener turnoutStateChangeListener
	@Accessors(#[PRIVATE_GETTER, PUBLIC_SETTER]) var ISegmentStateChangeListener segmentStateChangeListener
	@Accessors(#[PRIVATE_GETTER, PUBLIC_SETTER]) var ISegmentOccupancyChangeListener segmentOccupancyChangeListener
	@Accessors(#[PACKAGE_GETTER, PACKAGE_SETTER]) TrackElementStateCallback trackElementStateCallback

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		trackElementStateCallback = new TrackElementStateCallback(dispatcher, new ISegmentStateListener() {

			override onSegmentState(int id, SegmentState state) {
				logger.trace('''segmentState message arrived id=«id» state=«state»''')
				if (segments.get(id) != state) {
					logger.
						trace('''segmentState changed compared to cached values. Cached = «segments.get(id)» new =«state»''')
					segmentStateChangeListener?.onSegmentStateChange(id, segments.get(id), state)
					segments.put(id, state)
				}
			}

		}, new ITurnoutStateListener() {

			override onTurnoutState(int id, TurnoutState state) {
				logger.trace('''turnoutState message arrived id=«id» state=«state»''')
				if (turnouts.get(id) != state) {
					logger.
						trace('''turnoutState changed compared to cached values. Cached = «turnouts.get(id)» new =«state»''')
					turnoutStateChangeListener?.onTurnoutStateChange(id, turnouts.get(id), state)
					turnouts.put(id, state)
				}
			}

		}, new ISegmentOccupancyListener() {
			override onSegmentOccupancy(int id, SegmentOccupancy state) {
				logger.trace('''segmentOccupancy message arrived id=«id» state=«state»''')
				if (occupancy.get(id) != state) {
					logger.
						trace('''segmentOccupancy changed compared to cached values. Cached = «occupancy.get(id)» new =«state»''')
					segmentOccupancyChangeListener?.onSegmentOccupancyChange(id, occupancy.get(id), state)
					occupancy.put(id, state)
				}
			}

		})
	}

	override getSegmentState(int id) {
		if (segments.get(id) === null) {
			synchronized (segments) {
				if (segments.get(id) === null) {
					logger.
						trace('''The registry was asked for the state of Segment #«id» but there is no information in the cache''')
					segments.put(id, SegmentState.ENABLED)
				}
			}
		}
		segments.get(id)
	}

	override getTurnoutState(int id) {
		if (turnouts.get(id) === null) {
			synchronized (turnouts) {
				if (turnouts.get(id) === null) {
					logger.
						trace('''The registry was asked for the state of Turnout #«id» but there is no information in the cache''')
					turnouts.put(id, TurnoutState.DIVERGENT)
				}
			}
		}
		turnouts.get(id)
	}

	override getSegmentOccupancy(int id) {
		if (occupancy.get(id) === null) {
			synchronized (occupancy) {
				if (occupancy.get(id) === null) {
					logger.
						trace('''The registry was asked for the occupancy of Segment #«id» but there is no information in the cache''')
					occupancy.put(id, SegmentOccupancy.OCCUPIED)
				}
			}
		}
		occupancy.get(id)
	}

	override getSegments() {
		synchronized (segments) {
			return new ArrayList<Integer>(Collections.list(segments.keys));
		}
	}

	override getTurnouts() {
		synchronized (turnouts) {
			return new ArrayList<Integer>(Collections.list(turnouts.keys));
		}
	}

}
