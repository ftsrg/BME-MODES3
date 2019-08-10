package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Handles the track element (section or turnout = segment) state messages.
 * 
 * @author benedekh
 */
package class TrackElementStateCallback implements ITrackElementStateCallback, ISegmentStateListener, ITurnoutStateListener, ISegmentOccupancyListener {
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ISegmentStateListener segmentStateListener
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITurnoutStateListener turnoutStateListener
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ISegmentOccupancyListener segmentOccupancyListener

	/**
	 * @param dispatcher a dispatcher that dispatches the messages
	 */
	new(AbstractMessageDispatcher dispatcher) {
		val segmentStateClient = new SegmentStateClient(this)
		val turnoutStateClient = new TurnoutStateClient(this)
		val segmentOccupancyClient = new SegmentOccupancyClient(this)

		dispatcher.segmentStateHandler = segmentStateClient
		dispatcher.turnoutStateHandler = turnoutStateClient
		dispatcher.segmentOccupancyHandler = segmentOccupancyClient
	}

	override onSegmentState(int id, SegmentState state) {
		segmentStateListener?.onSegmentState(id, state)
	}

	override onTurnoutState(int id, TurnoutState state) {
		turnoutStateListener?.onTurnoutState(id, state)
	}

	override onSegmentOccupancy(int id, SegmentOccupancy state) {
		segmentOccupancyListener?.onSegmentOccupancy(id, state)
	}
}
