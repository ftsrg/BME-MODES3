package hu.bme.mit.inf.modes3.messaging.mms.handlers.status

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateOrBuilder

interface TurnoutStateHandler {
	def void handleTurnoutState(TurnoutStateOrBuilder event);
}
