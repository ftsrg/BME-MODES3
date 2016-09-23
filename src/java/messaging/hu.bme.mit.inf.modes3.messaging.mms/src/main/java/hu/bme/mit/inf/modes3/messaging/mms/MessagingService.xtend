package hu.bme.mit.inf.modes3.messaging.mms

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class MessagingService {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger
	Thread dispatchThread

	Transport transport
	IMessageDispatcher dispatcher

	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
	}

	def start(Transport _transport, IMessageDispatcher _dispatcher) {
		this.transport = _transport
		this.dispatcher = _dispatcher

		this.transport.connect()
		dispatchThread = new Thread(new DispatchThread(transport, dispatcher, logger))
		dispatchThread.start
	}

	def sendMessage(Object message) throws IllegalArgumentException {
		transport.sendMessage(dispatcher.convertMessageToRaw(message))
	}

	static class DispatchThread implements Runnable {
		val Transport transport
		val IMessageDispatcher dispatcher
		val Logger logger

		new(Transport t, IMessageDispatcher d, Logger logger) {
			transport = t
			dispatcher = d
			this.logger = logger
		}

		override run() {
			while(!Thread.currentThread.isInterrupted) {
				try {
					val rawMessage = transport.receiveMessage
					this.dispatcher.dispatchMessage(rawMessage)
				} catch(Exception e) {
					logger.error(e.message, e)
				// This catch is left blank intentionally
				}

			}
		}

	}
	
	def stop() {
		dispatchThread?.interrupt
	}

}
