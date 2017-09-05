package hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations

interface IDccStateChangeListener {
	def void onDccOperationsStateChange(DccOperations oldValue, DccOperations newValue)
}
