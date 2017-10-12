package hu.bme.mit.inf.modes3.components.trackelementcontroller.bridge

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITrackElementControllerBridge {
	def void sendSegmentState(int id, SegmentState state)

	def void sendTurnoutState(int id, TurnoutState state)
}
