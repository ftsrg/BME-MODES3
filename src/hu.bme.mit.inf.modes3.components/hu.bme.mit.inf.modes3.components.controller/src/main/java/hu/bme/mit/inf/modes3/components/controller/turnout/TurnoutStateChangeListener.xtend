package hu.bme.mit.inf.modes3.components.controller.turnout

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue

interface TurnoutStateChangeListener {
	def void onTurnoutStateChange(int id, TurnoutStateValue state);
}
