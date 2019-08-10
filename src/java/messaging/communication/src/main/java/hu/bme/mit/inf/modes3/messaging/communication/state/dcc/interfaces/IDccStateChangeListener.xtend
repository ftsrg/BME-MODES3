package hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations

/**
 * A listener that is called if the DCC state has changed.
 * 
 * @author benedekh
 */
interface IDccStateChangeListener {
	/**
	 * The event handler that is invoked if the DCC operations state has changed.
	 * 
	 * @param oldValue the previous operation state
	 * @param newValue the new operation state
	 */
	def void onDccOperationsStateChange(DccOperations oldValue, DccOperations newValue)
}
