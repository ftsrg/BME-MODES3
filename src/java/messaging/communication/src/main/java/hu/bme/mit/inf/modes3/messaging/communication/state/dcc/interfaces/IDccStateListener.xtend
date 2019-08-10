package hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations

/**
 * A listener for the {@link DccOperations} state. 
 * 
 * @author benedekh
 */
interface IDccStateListener {
	/**
	 * Processes the DCC operations state.
	 * 
	 * @param dccOperations the DCC operations state
	 */
	def void onDccOperationsState(DccOperations dccOperations)
}
