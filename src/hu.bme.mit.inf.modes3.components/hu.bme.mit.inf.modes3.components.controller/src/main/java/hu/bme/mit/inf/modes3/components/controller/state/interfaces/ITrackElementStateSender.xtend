package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState

interface ITrackElementStateSender {
	def void sendSegmentOccupation(int id, SegmentOccupancy state)

	def void sendSegmentState(int id, SegmentState state)

	def void sendTurnoutState(int id, TurnoutState state)
}
