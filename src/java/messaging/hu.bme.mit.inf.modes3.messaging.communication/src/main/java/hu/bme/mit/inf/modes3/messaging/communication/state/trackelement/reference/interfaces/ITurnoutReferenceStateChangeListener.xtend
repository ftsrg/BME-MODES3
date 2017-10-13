package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITurnoutReferenceStateChangeListener {
	def void onTurnoutReferenceStateChange(int id, TurnoutState oldValue, TurnoutState newValue)
}
