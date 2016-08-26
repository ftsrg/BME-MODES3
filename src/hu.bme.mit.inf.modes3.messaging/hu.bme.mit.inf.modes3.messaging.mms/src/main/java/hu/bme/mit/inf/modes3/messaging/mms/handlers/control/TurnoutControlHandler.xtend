package hu.bme.mit.inf.modes3.messaging.mms.handlers.control

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutControlOrBuilder

interface TurnoutControlHandler {
	def void handleTurnoutControl(TurnoutControlOrBuilder event);
}
