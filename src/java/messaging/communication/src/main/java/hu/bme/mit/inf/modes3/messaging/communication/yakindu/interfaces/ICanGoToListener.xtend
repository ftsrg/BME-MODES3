package hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection

/**
 * Handles a CanGoTo message in the state machines protocol.
 * 
 * @author benedekh
 */
interface ICanGoToListener {
	/**
	 * The train is allowed to go the segment that connects from the given direction.
	 * 
	 * @param targetID the target segment ID
	 * @param direction the connection direction of the segment
	 */
	def void canGoTo(int targetID, ConnectionDirection direction)
}
