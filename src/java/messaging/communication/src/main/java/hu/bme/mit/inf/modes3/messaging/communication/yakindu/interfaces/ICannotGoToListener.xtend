package hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection

interface ICannotGoToListener {
	def void cannotGoTo(int targetID, ConnectionDirection direction)
}
