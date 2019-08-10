package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * Sends the track element's (section or turnout = segment) state.
 * 
 * @author benedekh
 */
interface ITrackElementStateSender {
	/**
	 * Sends the segment's occupancy.
	 * 
	 * @param id the ID of the segment
	 * @param state the occupancy of the segment
	 */
	def void sendSegmentOccupation(int id, SegmentOccupancy state)

	/**
	 * Sends the segment's state.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the segment
	 */
	def void sendSegmentState(int id, SegmentState state)

	/**
	 * Sends the turnout's state.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the turnout
	 */
	def void sendTurnoutState(int id, TurnoutState state)
}
