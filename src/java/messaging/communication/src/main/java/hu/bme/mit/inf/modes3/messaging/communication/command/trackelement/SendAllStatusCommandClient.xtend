package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement

import hu.bme.mit.inf.modes3.messaging.messages.command.SendAllStatusCommand
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

/**
 * Forwards the {@link SendAllStatusCommand} message to the corresponding callback.  
 * 
 * @author benedekh
 */
package class SendAllStatusCommandClient implements IMessageHandler<SendAllStatusCommand> {

	val SendAllStatusCommandCallback callback
	
	/**
	 * @param callback the callback for the send all status command
	 */
	new(SendAllStatusCommandCallback callback) {
		this.callback = callback
	}

	override handleMessage(SendAllStatusCommand message) {
		callback.onSendAllStatus
	}

}
