package hu.bme.mit.inf.modes3.messaging.mms

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport
import java.util.Set
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class MessagingService {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger
	protected val ExecutorService dispatcherThreads

	protected val Set<Transport> transports
	@Accessors(PUBLIC_GETTER) AbstractMessageDispatcher dispatcher

	new(Transport transport, AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.dispatcherThreads = Executors.newCachedThreadPool
		this.dispatcher = dispatcher
		this.transports = newHashSet
		addTransport(transport)
	}

	def addTransport(Transport transport) {
		this.transports.add(transport)
	}

	def start() {
		try {
			transports.forEach [
				it.connect;
				dispatcherThreads.execute(new DispatchThread(it, dispatcher, logger))
			]
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	def sendMessage(Object message) throws IllegalArgumentException {
		val rawMessage = dispatcher.convertMessageToRaw(message)
		transports.forEach [
			try {
				it.sendMessage(rawMessage)
			} catch (Exception ex) {
				logger.error(ex.message, ex)
			}
		]
	}

	def stop() {
		try {
			dispatcherThreads.shutdown()
			transports.forEach [
				try {
					it.close
				} catch (Exception ex) {
					logger.error(ex.message, ex)
				}
			]
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
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
					dispatcher.dispatchMessage(rawMessage)
				} catch (Exception e) {
					logger.error('''transport: «transport», errorMessage: «e.message»''', e)
					if (Thread.currentThread.isInterrupted) {
						Thread.currentThread.interrupt
					}
				}
			}
		}
	}

}
