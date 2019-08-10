package hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations

/**
 * An in-memory cache that notifies the listener ({@link #dccOperationsChangeListener}) 
 * only if the DCC operation state has changed.
 * 
 * @author benedekh
 */
interface IDccStateRegistry {
	/**
	 * @reutrn the latest DCC operations state
	 */
	def DccOperations getDccOperationsState()

	/**
	 * Set a listener that will be invoked if the DCC oeprations state has changed.
	 * 
	 * @param listener the listener to be set
	 */
	def void setDccOperationsChangeListener(IDccStateChangeListener listener)
}
