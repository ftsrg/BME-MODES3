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

/** 
 * A class that connects the transport layer with the dispatcher that dispatches the messages transferred over the transport layer.
 * The messaging service can also send a message through the transport layer.
 * 
 * @author baloghlaszlo, benedekh 
 **/
class MessagingService {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger
	protected val ExecutorService dispatcherThreads

	protected val Set<Transport> transports
	@Accessors(PUBLIC_GETTER) AbstractMessageDispatcher dispatcher

	/**
	 * @param transport the transport layer
	 * @param dispatcher a dispatcher that dispatches the messages
	 * @param factory the logger factory
	 */
	new(Transport transport, AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.dispatcherThreads = Executors.newCachedThreadPool
		this.dispatcher = dispatcher
		this.transports = newHashSet
		addTransport(transport)
	}

	/**
	 * Adds a new transport layer, so that messages will be also received through this transport.
	 * @param transport the transport layer to be added
	 */
	def addTransport(Transport transport) {
		this.transports.add(transport)
	}

	/**
	 * Starts the messaging services. Listens to each transport layer and dispatches the arrived
	 * messages by the dispatcher.
	 */
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

	/**
	 * Sends a message through the transport layer.
	 * The message will be serialized by the dispatcher that is used by the messaging service.
	 * 
	 * @param message to be sent serialized and sent over the transport layer
	 */
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

	/**
	 * Stops the messaging service. Stops the dispatchers and closes the connection to each transport layer.
	 */
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

	/**
	 * Fetches the messages from the transport layer and forwards them to the dispatcher.
	 * 
	 * @author baloghlaszlo, benedekh
	 */
	static class DispatchThread implements Runnable {
		val Transport transport
		val IMessageDispatcher dispatcher
		val Logger logger

		/**
	 * @param transport the transport layer
	 * @param dispatcher a dispatcher that dispatches the messages
	 * @param logger the logger
		 */
		new(Transport transport, IMessageDispatcher dispatcher, Logger logger) {
			this.transport = transport
			this.dispatcher = dispatcher
			this.logger = logger
		}
		
		/**
		 * Fetches the messages from the transport layer and forwards them to the dispatcher.
		 */
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
