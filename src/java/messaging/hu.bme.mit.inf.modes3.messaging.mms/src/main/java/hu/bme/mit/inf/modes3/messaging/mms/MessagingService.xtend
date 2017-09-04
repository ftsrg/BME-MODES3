package hu.bme.mit.inf.modes3.messaging.mms

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class MessagingService {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger
	Thread dispatchThread

	Transport transport
	@Accessors(PUBLIC_GETTER) AbstractMessageDispatcher dispatcher

	new(Transport transport, AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.transport = transport
		this.dispatcher = dispatcher
	}

	def start() {
		transport.connect
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
			while (!Thread.currentThread.isInterrupted) {
				try {
					val rawMessage = transport.receiveMessage
					this.dispatcher.dispatchMessage(rawMessage)
				} catch (InterruptedException e) {
					logger.error(e.message, e)
					Thread.currentThread.interrupt
				} catch (Exception e) {
					logger.error(e.message, e)
				}
			}
		}

	}

	def stop() {
		dispatchThread?.interrupt
	}

}
