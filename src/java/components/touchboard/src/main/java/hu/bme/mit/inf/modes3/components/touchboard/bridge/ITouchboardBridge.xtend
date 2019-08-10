package hu.bme.mit.inf.modes3.components.touchboard.bridge

import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * The bridge between the touchboard application and the communication network.
 * 
 * @author benedekh
 */
interface ITouchboardBridge {
	/**
	 * @return the train commander
	 */
	def ITrainCommander getTrainCommander()

	/**
	 * @param segmentId the ID of the segment
	 * @return the recent state of the segment
	 */
	def SegmentState getSegmentState(int segmentId)

	/**
	 * @param turnoutId the ID of the turnout
	 * @return the recent state of the turnout
	 */
	def TurnoutState getTurnoutState(int turnoutId)

	/**
	 * Send a segment command message over the communication network.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the segment
	 */
	def void sendSegmentCommand(int segmentId, SegmentState state)

	/**
	 * Send a turnout command message over the communication network.
	 * 
	 * @param id the ID of the turnout
	 * @param state the state of the turnout
	 */
	def void sendTurnoutCommandWithTurnoutId(int turnoutId, TurnoutState state)

	/**
	 * Send a SendAllStatus command over the communication network.
	 */
	def void sendAllStatusCommand()

}
