package hu.bme.mit.inf.modes3.components.controller.turnout

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue

interface TurnoutControlInfoListener {
	def void onTurnoutControlInfo(int id, TurnoutStateValue state)
}