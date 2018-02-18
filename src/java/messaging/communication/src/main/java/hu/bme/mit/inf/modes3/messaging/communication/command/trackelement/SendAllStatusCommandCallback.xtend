package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusListener
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class SendAllStatusCommandCallback implements ISendAllStatusCommandCallback, ISendAllStatusListener {

	val Logger logger
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ISendAllStatusListener sendAllStatusListener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		logger = factory.getLogger(this.class.name)
		dispatcher.sendAllStatusHandler = new SendAllStatusCommandClient(this)
	}

	override onSendAllStatus() {
		sendAllStatusListener?.onSendAllStatus
	}
}
