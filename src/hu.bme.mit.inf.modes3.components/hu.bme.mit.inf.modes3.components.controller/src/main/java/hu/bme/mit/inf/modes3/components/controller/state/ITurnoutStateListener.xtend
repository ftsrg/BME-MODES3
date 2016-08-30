package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue

interface ITurnoutStateListener {
	def void onTurnoutState(int id, TurnoutStateValue state);
}