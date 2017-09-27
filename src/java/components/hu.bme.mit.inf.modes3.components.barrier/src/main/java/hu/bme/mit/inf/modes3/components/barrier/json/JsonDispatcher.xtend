package hu.bme.mit.inf.modes3.components.barrier.json

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class JsonDispatcher implements IMessageDispatcher {

	val Logger logger

	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
	}

	override dispatchMessage(byte[] rawMessage) {
		// left empty on purpose
	}

	override convertMessageToRaw(Object message) throws IllegalArgumentException {
		try {
			return (message as BarrierStateMessage).serialize
		} catch (Exception ex) {
			logger.error(ex.message)
			throw new IllegalArgumentException
		}
	}
}
