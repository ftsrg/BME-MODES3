package hu.bme.mit.inf.modes3.components.controller.turnout

import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TurnoutControlHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutControlOrBuilder

package class TurnoutControlListener implements TurnoutControlHandler {
	private var TurnoutCallBackController callback

	new(TurnoutCallBackController controller) {
		callback = controller
	}

	override handleMessage(TurnoutControlOrBuilder message) {
		val id = message.turnoutID
		val state = message.controlState
		callback.onTurnoutControlInfo(id, state)
	}

}
