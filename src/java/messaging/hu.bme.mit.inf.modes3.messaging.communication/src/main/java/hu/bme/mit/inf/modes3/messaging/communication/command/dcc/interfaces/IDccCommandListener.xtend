package hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations

interface IDccCommandListener {
	def void onDccCommand(DccOperations dccOperations)
}
