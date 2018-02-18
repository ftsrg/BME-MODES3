package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import java.util.ArrayList
import java.util.Collections
import java.util.HashSet
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrackElementStateRegistry implements ITrackElementStateRegistry {
	val segments = new ConcurrentHashMap<Integer, SegmentState>
	val turnouts = new ConcurrentHashMap<Integer, TurnoutState>
	val occupancy = new ConcurrentHashMap<Integer, SegmentOccupancy>
	@Accessors(#[PROTECTED_GETTER]) val Logger logger
	@Accessors(#[PROTECTED_GETTER]) val turnoutStateChangeListeners = new HashSet<ITurnoutStateChangeListener>
	@Accessors(#[PROTECTED_GETTER]) val segmentStateChangeListeners = new HashSet<ISegmentStateChangeListener>
	@Accessors(#[PROTECTED_GETTER]) val segmentOccupancyChangeListeners = new HashSet<ISegmentOccupancyChangeListener>
	@Accessors(#[PROTECTED_GETTER]) val ITrackElementStateCallback trackElementStateCallback

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		trackElementStateCallback = new TrackElementStateCallback(dispatcher)
		trackElementStateCallback.segmentStateListener = new ISegmentStateListener() {

			override onSegmentState(int id, SegmentState state) {
				logger.trace('''segmentState message arrived id=«id» state=«state»''')
				val oldState = segments.get(id)
				if(oldState != state) {
					logger.trace('''segmentState changed compared to cached values. Cached = «oldState» new =«state»''')
					segments.put(id, state)
					segmentStateChangeListeners.forEach[onSegmentStateChange(id, oldState, state)]
				}
			}

		}
		trackElementStateCallback.turnoutStateListener = new ITurnoutStateListener() {

			override onTurnoutState(int id, TurnoutState state) {
				logger.trace('''turnoutState message arrived id=«id» state=«state»''')
				val oldState = turnouts.get(id)
				if(oldState != state) {
					logger.trace('''turnoutState changed compared to cached values. Cached = «oldState» new =«state»''')
					turnouts.put(id, state)
					turnoutStateChangeListeners.forEach[onTurnoutStateChange(id, oldState, state)]
				}
			}

		}
		trackElementStateCallback.segmentOccupancyListener = new ISegmentOccupancyListener() {

			override onSegmentOccupancy(int id, SegmentOccupancy state) {
				logger.trace('''segmentOccupancy message arrived id=«id» state=«state»''')
				val oldState = occupancy.get(id)
				if(oldState != state) {
					logger.trace('''segmentOccupancy changed compared to cached values. Cached = «oldState» new =«state»''')
					occupancy.put(id, state)
					segmentOccupancyChangeListeners.forEach[onSegmentOccupancyChange(id, oldState, state)]
				}
			}

		}
	}

	override getSegmentState(int id) {
		if(segments.get(id) === null) {
			val defaultValue = SegmentState.ENABLED
			logger.trace('''The registry was asked for the state of Segment #«id» but there is no information in the cache, default «defaultValue» state is used instead''')
			segments.put(id, defaultValue)
		}
		segments.get(id)
	}

	override getTurnoutState(int id) {
		if(turnouts.get(id) === null) {
			val defaultValue = TurnoutState.DIVERGENT
			logger.trace('''The registry was asked for the state of Turnout #«id» but there is no information in the cache, default «defaultValue» state is used instead''')
			turnouts.put(id, defaultValue)
		}
		turnouts.get(id)
	}

	override getSegmentOccupancy(int id) {
		if(occupancy.get(id) === null) {
			val defaultValue = SegmentOccupancy.FREE
			logger.trace('''The registry was asked for the occupancy of Segment #«id» but there is no information in the cache, default «defaultValue» state is used instead''')
			occupancy.put(id, defaultValue)
		}
		occupancy.get(id)
	}

	override getSegments() {
		synchronized(segments) {
			return new ArrayList<Integer>(Collections.list(segments.keys));
		}
	}

	override getTurnouts() {
		synchronized(turnouts) {
			return new ArrayList<Integer>(Collections.list(turnouts.keys));
		}
	}
	
	override registerTurnoutStateChangeListener(ITurnoutStateChangeListener listener) {
		turnoutStateChangeListeners.add(listener)
	}
	
	override registerSegmentStateChangeListener(ISegmentStateChangeListener listener) {
		segmentStateChangeListeners.add(listener)
	}
	
	override registerSegmentOccupancyChangeListener(ISegmentOccupancyChangeListener listener) {
		segmentOccupancyChangeListeners.add(listener)
	}

}
