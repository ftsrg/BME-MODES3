package hu.bme.mit.inf.modes3.messaging.communication.command.dcc

import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.command.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class DccCommandClient implements IMessageHandler<DccOperationsCommand> {

	private var IDccCommandListener callback

	new(IDccCommandListener controller) {
		callback = controller
	}

	override handleMessage(DccOperationsCommand message) {
		val command = message.dccOperations
		callback.onDccCommand(command)
	}

}
