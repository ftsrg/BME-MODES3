package hu.bme.mit.inf.modes3.messaging.communication.state.dcc

import hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces.IDccStateCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces.IDccStateListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

package class DccStateCallback implements IDccStateCallback, IDccStateListener {
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var IDccStateListener dccStateListener

	new(AbstractMessageDispatcher dispatcher) {
		val dccStateClient = new DccStateClient(this)
		dispatcher.dccOperationStateHandler = dccStateClient
	}

	override onDccOperationsState(DccOperations dccOperations) {
		dccStateListener?.onDccOperationsState(dccOperations)
	}

}
