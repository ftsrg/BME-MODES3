package hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection

interface IReleaseToListener {
	def void releaseTo(int targetID, ConnectionDirection direction)
}
