package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusListener
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class SendAllStatusCommandCallback implements ISendAllStatusListener {

	val Logger logger
	var ISendAllStatusListener listener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		logger = factory.getLogger(this.class.name)
		dispatcher.sendAllStatusHandler = new SendAllStatusCommandClient(this)
	}

	def setStatusUpdateListener(ISendAllStatusListener listener) {
		this.listener = listener
	}

	override onSendAllStatus() {
		listener?.onSendAllStatus

	}
}
