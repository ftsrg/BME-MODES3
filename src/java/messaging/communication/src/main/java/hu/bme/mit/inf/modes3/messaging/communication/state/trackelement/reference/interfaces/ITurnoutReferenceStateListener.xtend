package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITurnoutReferenceStateListener {
	def void onTurnoutReferenceState(int id, TurnoutState state)
}
