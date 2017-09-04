package hu.bme.mit.inf.modes3.messaging.communication.state.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITurnoutStateChangeListener {
	def void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue);
}
