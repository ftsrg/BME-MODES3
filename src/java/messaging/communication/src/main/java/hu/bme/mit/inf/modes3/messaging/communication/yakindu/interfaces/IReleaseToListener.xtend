package hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection

/**
 * Handles a ReleaseTo message in the state machines protocol.
 * 
 * @author benedekh
 */
interface IReleaseToListener {
	/**
	 * The segment that connects from the given direction should not be reserved anymore (should be released).
	 * 
	 * @param targetID the target segment ID
	 * @param direction the connection direction of the segment
	 */
	def void releaseTo(int targetID, ConnectionDirection direction)
}
