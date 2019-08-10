package hu.bme.mit.inf.modes3.messaging.communication.state.dcc

import hu.bme.mit.inf.modes3.messaging.communication.state.dcc.interfaces.IDccStateSender
import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations
import hu.bme.mit.inf.modes3.messaging.messages.status.DccOperationsStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Sends DCC states.
 * 
 * @author benedekh
 */
class DccStateSender implements IDccStateSender {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var MessagingService mms

	/**
	 * @param mms the messaging service to the track
	 * @param factory the logger factory
	 */
	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendDccState(DccOperations dccOperations) {
		mms.sendMessage(new DccOperationsStateMessage(dccOperations))
		logger.debug('''DccOperationsState message sent with dccOperations=«dccOperations»''')
	}

}
