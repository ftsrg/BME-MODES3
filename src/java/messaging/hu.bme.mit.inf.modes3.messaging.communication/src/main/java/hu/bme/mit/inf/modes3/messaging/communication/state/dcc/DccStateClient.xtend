package hu.bme.mit.inf.modes3.messaging.communication.state.dcc

import hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces.IDccStateListener
import hu.bme.mit.inf.modes3.messaging.messages.status.DccOperationsStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class DccStateClient implements IMessageHandler<DccOperationsStateMessage> {
	private var IDccStateListener callback

	new(IDccStateListener controller) {
		callback = controller
	}

	override handleMessage(DccOperationsStateMessage message) {
		val dccOperations = message.dccOperations
		callback.onDccOperationsState(dccOperations)
	}
}
