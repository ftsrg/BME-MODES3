package hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection

interface ICanGoToListener {
	def void canGoTo(int targetID, ConnectionDirection direction)
}
