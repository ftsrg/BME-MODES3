package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITurnoutReferenceStateSender {
	def void sendTurnoutReferenceState(int id, TurnoutState state)
}
