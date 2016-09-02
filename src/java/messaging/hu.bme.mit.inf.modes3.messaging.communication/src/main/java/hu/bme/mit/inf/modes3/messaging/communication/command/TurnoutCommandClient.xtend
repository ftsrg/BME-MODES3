package hu.bme.mit.inf.modes3.messaging.communication.command

import hu.bme.mit.inf.modes3.messaging.communication.enums.EnumTransformator
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TurnoutCommandHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommandOrBuilder

package class TurnoutCommandClient implements TurnoutCommandHandler {
	private var TrackElementCommandCallback callback

	new(TrackElementCommandCallback controller) {
		callback = controller
	}

	override handleMessage(TurnoutCommandOrBuilder message) {
		val id = message.turnoutID
		val state = EnumTransformator.toGeneral(message.state)
		callback.onTurnoutCommand(id, state)
	}

}
