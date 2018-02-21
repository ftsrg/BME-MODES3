package hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection

interface IReserveToListener {
	def void reserveTo(int targetID, ConnectionDirection direction)
}
