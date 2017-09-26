package hu.bme.mit.inf.modes3.components.trackelementstatus

import hu.bme.mit.inf.modes3.components.trackelementstatus.json.TrackElementStatusMessage
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class StatusReporter {

	val CommunicationStack communicationStack
	val Logger logger

	new(CommunicationStack communicationStack, ILoggerFactory loggerFactory) {
		this.logger = loggerFactory.getLogger(this.class.name)
		this.communicationStack = communicationStack
		this.communicationStack.start
	}

	def sendStatusMessage(int id, String status) {
		try {
			val message = new TrackElementStatusMessage(id, status)
			communicationStack.mms.sendMessage(message)
		} catch (Exception ex) {
			logger.error(ex.message)
		}
	}

}
