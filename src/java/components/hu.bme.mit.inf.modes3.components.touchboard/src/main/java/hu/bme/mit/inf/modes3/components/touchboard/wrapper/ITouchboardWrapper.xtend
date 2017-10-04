package hu.bme.mit.inf.modes3.components.touchboard.wrapper

import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITouchboardWrapper {
	def ITrainCommander getTrainCommander()

	def SegmentState getSegmentState(int segmentId)

	def TurnoutState getTurnoutState(int turnoutId)

	def void sendSegmentCommand(int segmentId, SegmentState state)

	def void sendTurnoutCommandWithTurnoutId(int turnoutId, TurnoutState state)

	def void sendAllStatusCommand()

}
