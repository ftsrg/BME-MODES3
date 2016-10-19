package hu.bme.mit.inf.modes3.messaging.communication.update

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.SendAllStatusOrBuilder

class AllStatusUpdateClient implements MessageHandler<SendAllStatusOrBuilder> {
	
	val SendAllStatusCallback callback
	
	
	new(SendAllStatusCallback callback) {
		this.callback = callback
	}
	
	override handleMessage(SendAllStatusOrBuilder message) {
		callback.onAllStatusUpdate
	}
	
}