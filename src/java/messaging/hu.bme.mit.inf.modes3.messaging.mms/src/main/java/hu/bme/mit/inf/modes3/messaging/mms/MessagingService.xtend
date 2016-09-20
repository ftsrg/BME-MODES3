package hu.bme.mit.inf.modes3.messaging.mms

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MessagingService {

	@Accessors(#[PRIVATE_GETTER, PRIVATE_SETTER]) static val Logger logger = LoggerFactory.getLogger(MessagingService)
	
	/** 
	 * Thread for dispatching the incoming events into the correct functions.
	 * 
	 * The separate thread is needed for a block-free receiving of events from
	 * the transport.
	 */
	Thread dispatchThread

	Transport transport
	IMessageDispatcher dispatcher

	/**
	 * Starts the messaging service. This will connect to the specified endpoints,
	 * create a new thread, and starts receiveiving messages from the transport.
	 */
	def start(Transport transport, IMessageDispatcher dispatcher) {
		this.dispatcher = dispatcher

		this.transport = transport
		this.transport.connect()
		
		dispatchThread = new Thread(new DispatchThread(transport, dispatcher))
		dispatchThread.start

	}

	/**
	 * Send a message to all specified endpoints. This message is handling the
	 * object passed as a message to the @link{Dispatcher.convertMessageToRaw}
	 * method, where the message is converted to it's serialized byte[] form.
	 */
	def sendMessage(Object message) throws IllegalArgumentException {
		transport.sendMessage(dispatcher.convertMessageToRaw(message))
	}

	/**
	 * This class is passed to dispatchThread in the constructor. This class
	 * implements the receive loop. 
	 */
	static class DispatchThread implements Runnable {
		val Transport transport
		val IMessageDispatcher dispatcher

		new(Transport t, IMessageDispatcher d) {
			transport = t
			dispatcher = d
		}

		override run() {
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

	}

}
