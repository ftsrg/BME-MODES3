package hu.bme.mit.inf.modes3.components.controller.command

import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TurnoutCommandHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommandOrBuilder

package class TurnoutCommandClient implements TurnoutCommandHandler {
	private var hu.bme.mit.inf.modes3.components.controller.command.TrackElementCommandCallback callback

	new(hu.bme.mit.inf.modes3.components.controller.command.TrackElementCommandCallback controller) {
		callback = controller
	}

	override handleMessage(TurnoutCommandOrBuilder message) {
		val id = message.turnoutID
		val state = message.state
		callback.onTurnoutCommand(id, state)
	}

}
