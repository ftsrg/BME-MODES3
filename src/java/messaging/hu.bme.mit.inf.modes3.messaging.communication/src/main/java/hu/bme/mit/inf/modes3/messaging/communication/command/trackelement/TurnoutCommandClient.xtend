package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class TurnoutCommandClient implements IMessageHandler<TurnoutCommand> {
	private var ITurnoutCommandListener callback

	new(ITurnoutCommandListener controller) {
		callback = controller
	}

	override handleMessage(TurnoutCommand message) {
		val id = message.turnoutId
		val state = message.state
		callback.onTurnoutCommand(id, state)
	}

}
