package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * A commander that sends the track element commands (section or turnout = segment) to the railway track.
 * 
 * @author benedekh
 */
interface ITrackElementCommander {

	/**
	 * Sends a command to the segment denoted by its ID.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the segment
	 */
	def void sendSegmentCommand(int id, SegmentState state)

	/**
	 * Send a command to a turnout, denoted by its segment ID. (The ID of the segment which indicates the turnout's occupancy.)
	 * 
	 * @param segmentId the ID of the turnout as a segment
	 * @param state the state of the turnout
	 */
	def void sendTurnoutCommand(int segmentId, TurnoutState state)

	/**
	 * Send a command to a turnout, denoted by its ID.
	 * 
	 * @param id the ID of the turnout
	 * @param state the state of the turnout
	 */
	def void sendTurnoutCommandWithTurnoutId(int id, TurnoutState state)

	/**
	 * Sends a send all status command.
	 */
	def void sendAllStatusCommand()

}
