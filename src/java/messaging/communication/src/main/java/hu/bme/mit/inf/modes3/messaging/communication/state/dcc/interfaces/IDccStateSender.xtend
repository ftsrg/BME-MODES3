package hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations

/**
 * Sends DCC states.
 * 
 * @author benedekh
 */
interface IDccStateSender {
	
	/**
	 * Sends a DCC operations state.
	 * 
	 * @param dccOperations the DCC operations state to be sent
	 */
	def void sendDccState(DccOperations dccOperations)
}
