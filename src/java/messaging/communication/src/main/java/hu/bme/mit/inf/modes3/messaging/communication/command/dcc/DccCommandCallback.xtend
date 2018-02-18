package hu.bme.mit.inf.modes3.messaging.communication.command.dcc

import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class DccCommandCallback implements IDccCommandListener, IDccCommandCallback {
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger

	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var IDccCommandListener dccCommandListener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		val dccCommandClient = new DccCommandClient(this)
		dispatcher.dccOperationCommandHandler = dccCommandClient

		this.logger = factory.getLogger(this.class.name)
	}

	override onDccCommand(DccOperations dccOperations) {
		if (dccCommandListener === null) {
			logger.trace('''DccOperationstCommand recieved, but the listener is not set''')
		} else {
			logger.trace('''DccOperationstCommand recieved, «dccOperations»''')
			dccCommandListener.onDccCommand(dccOperations)
		}
	}

}
