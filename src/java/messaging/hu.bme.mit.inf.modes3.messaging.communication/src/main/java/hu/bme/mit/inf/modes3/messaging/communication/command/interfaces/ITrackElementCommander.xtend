package hu.bme.mit.inf.modes3.messaging.communication.command.interfaces

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState

interface ITrackElementCommander {
	
	def void sendSegmentCommand(int id, SegmentState state)
	def void sendTurnoutCommand(int segmentId, TurnoutState state)
	def void sendTurnoutCommandWithTurnoutId(int id, TurnoutState state)
	def void sendAllStatusCommand()
	def void stopEntireRailRoad()
	def void setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction)
	def void stopTrains()
	def void startEntireRailRoad()
	
}
