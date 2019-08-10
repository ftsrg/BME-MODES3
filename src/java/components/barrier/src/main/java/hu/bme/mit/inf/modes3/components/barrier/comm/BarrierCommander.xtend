package hu.bme.mit.inf.modes3.components.barrier.comm

import hu.bme.mit.inf.modes3.messaging.messages.status.BarrierStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * A commander that sends commands to the barrier.
 * 
 * @author benedekh
 */
class BarrierCommander {

	val MessagingService communicationStack
	val Logger logger

	/**
	 * @param communicationStack the messaging service to the barrier
	 * @param loggerFactory the logger factory
	 */
	new(MessagingService communicationStack, ILoggerFactory loggerFactory) {
		this.logger = loggerFactory.getLogger(this.class.name)
		this.communicationStack = communicationStack
		this.communicationStack.start
	}
	
	/**
	 * Send a barrier message to the barrier.
	 * 
	 * @param barrierState the state of the barrier
	 */
	def sendBarrierMessage(String barrierState) {
		try {
			val message = new BarrierStateMessage(barrierState)
			communicationStack.sendMessage(message)
		} catch (Exception ex) {
			logger.error(ex.message)
		}
	}

}
