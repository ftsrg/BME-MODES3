package hu.bme.mit.inf.modes3.messaging.communication.command.dcc

import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.command.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

/**
 * Forwards the {@link DccOperationsCommand} message to the corresponding callback.  
 * 
 * @author benedekh
 */
package class DccCommandClient implements IMessageHandler<DccOperationsCommand> {

	private var IDccCommandListener callback

	/**
	 * @param controller the callback for the DCC Operations command
	 */
	new(IDccCommandListener controller) {
		callback = controller
	}

	override handleMessage(DccOperationsCommand message) {
		val command = message.dccOperations
		callback.onDccCommand(command)
	}

}
