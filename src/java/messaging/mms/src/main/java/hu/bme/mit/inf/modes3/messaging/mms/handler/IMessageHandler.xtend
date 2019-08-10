package hu.bme.mit.inf.modes3.messaging.mms.handler

/**
 * A handler for a message.
 * 
 * @param <T> the type of the message
 * 
 * @author benedekh
 */
interface IMessageHandler<T> {
	/**
	 * Processes a message.
	 * 
	 * @param message to be processed
	 */
	def void handleMessage(T message);
}
