package hu.bme.mit.inf.modes3.messaging.communication.state.dcc

import hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces.IDccStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces.IDccStateListener
import hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces.IDccStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class DccStateRegistry implements IDccStateRegistry {
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	@Accessors(#[PUBLIC_GETTER, PRIVATE_SETTER]) transient var DccOperations dccOperationsState

	@Accessors(#[PACKAGE_GETTER, PACKAGE_SETTER]) val DccStateCallback dccStateCallback
	@Accessors(#[PRIVATE_GETTER, PUBLIC_SETTER]) var IDccStateChangeListener dccOperationsChangeListener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		dccStateCallback = new DccStateCallback(dispatcher, new IDccStateListener() {

			override onDccOperationsState(DccOperations dccOperations) {
				logger.trace('''DccOperationsMessage message arrived dccOperations=«dccOperations»''')
				if (dccOperationsState != dccOperations) {
					logger.
						trace('''DccOperationsMessage changed compared to cached values. Cached = «dccOperationsState» new =«dccOperations»''')
					dccOperationsChangeListener?.onDccOperationsStateChange(dccOperationsState, dccOperations)
					dccOperationsState = dccOperations
				}
			}

		})
	}

}
