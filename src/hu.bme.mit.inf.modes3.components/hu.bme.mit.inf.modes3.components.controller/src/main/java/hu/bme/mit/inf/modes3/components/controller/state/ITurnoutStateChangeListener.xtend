package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue

interface ITurnoutStateChangeListener {
	def void onTurnoutStateChange(int id, TurnoutStateValue oldValue, TurnoutStateValue newValue);
}
