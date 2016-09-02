package hu.bme.mit.inf.modes3.messaging.communication.command.interfaces

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState

interface ITrackElementCommander {
	
	def void sendSegmentCommand(int id, SegmentState state)
	def void sendTurnoutCommand(int id, TurnoutState state)
	
}
