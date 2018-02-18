package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement

import hu.bme.mit.inf.modes3.messaging.messages.command.SendAllStatusCommand
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class SendAllStatusCommandClient implements IMessageHandler<SendAllStatusCommand> {

	val SendAllStatusCommandCallback callback

	new(SendAllStatusCommandCallback callback) {
		this.callback = callback
	}

	override handleMessage(SendAllStatusCommand message) {
		callback.onSendAllStatus
	}

}
