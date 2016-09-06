package hu.bme.mit.inf.modes3.messaging.mms

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MessagingService {

	@Accessors(#[PRIVATE_GETTER, PRIVATE_SETTER]) static val Logger logger = LoggerFactory.getLogger(MessagingService)

	Transport transport
	IMessageDispatcher dispatcher

	def start(Transport _transport, IMessageDispatcher _dispatcher) {
		this.transport = _transport
		this.dispatcher = _dispatcher

		this.transport.connect()
		while (!Thread.currentThread.isInterrupted) {
			try {
				val rawMessage = transport.receiveMessage
				this.dispatcher.dispatchMessage(rawMessage)
			} catch (Exception e) {
				logger.error(e.message, e)
				// This catch is left blank intentionally
			}

		}
	}

	def sendMessage(Object message) throws IllegalArgumentException {
		transport.sendMessage(dispatcher.convertMessageToRaw(message))
	}

}
