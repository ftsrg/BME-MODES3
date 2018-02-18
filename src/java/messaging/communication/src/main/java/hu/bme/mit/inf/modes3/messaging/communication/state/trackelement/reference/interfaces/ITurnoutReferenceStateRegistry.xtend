package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITurnoutReferenceStateRegistry {
	def TurnoutState getTurnoutReferenceState(int id)
	def void setTurnoutReferenceStateChangeListener(ITurnoutReferenceStateChangeListener listener)
}
