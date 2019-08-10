package hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection

/**
 * Handles a ReserveTo message in the state machines protocol.
 * 
 * @author benedekh
 */
interface IReserveToListener {
	/**
	 * The segment that connects from the given direction should be reserved.
	 * 
	 * @param targetID the target segment ID
	 * @param direction the connection direction of the segment
	 */
	def void reserveTo(int targetID, ConnectionDirection direction)
}
