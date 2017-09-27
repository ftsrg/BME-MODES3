package hu.bme.mit.inf.modes3.components.barrier

import hu.bme.mit.inf.modes3.components.barrier.json.BarrierStateMessage
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class BarrierCommander {

	val CommunicationStack communicationStack
	val Logger logger

	new(CommunicationStack communicationStack, ILoggerFactory loggerFactory) {
		this.logger = loggerFactory.getLogger(this.class.name)
		this.communicationStack = communicationStack
		this.communicationStack.start
	}

	def sendBarrierMessage(String barrierState) {
		try {
			val message = new BarrierStateMessage(barrierState)
			communicationStack.mms.sendMessage(message)
		} catch (Exception ex) {
			logger.error(ex.message)
		}
	}

}
