package hu.bme.mit.inf.modes3.components.controller.command.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState

interface ITrackElementCommander {
	
	def void sendSegmentCommand(int id, SegmentState state)
	def void sendTurnoutCommand(int id, TurnoutState state)
	
}