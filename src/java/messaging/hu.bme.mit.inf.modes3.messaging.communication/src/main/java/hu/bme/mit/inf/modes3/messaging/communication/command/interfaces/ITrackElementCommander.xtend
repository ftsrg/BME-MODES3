package hu.bme.mit.inf.modes3.messaging.communication.command.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITrackElementCommander {

	def void sendSegmentCommand(int id, SegmentState state)

	/**
	 * Send a command to a turnout, denoted by its segment ID. (The ID of the segment which indicates the turnout's occupancy.)
	 */
	def void sendTurnoutCommand(int segmentId, TurnoutState state)

	/**
	 * Send a command to a turnout, denoted by its ID.
	 */
	def void sendTurnoutCommandWithTurnoutId(int id, TurnoutState state)

	def void sendAllStatusCommand()

	def void stopEntireRailRoad()

	def void setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction)

	def void stopTrains()

	def void startEntireRailRoad()

}
