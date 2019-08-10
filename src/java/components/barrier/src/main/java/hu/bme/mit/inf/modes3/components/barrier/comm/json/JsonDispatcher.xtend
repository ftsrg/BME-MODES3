package hu.bme.mit.inf.modes3.components.barrier.comm.json

import com.google.gson.Gson
import hu.bme.mit.inf.modes3.messaging.messages.status.BarrierStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * A dispatcher that can serialize a Java class into JSON (and then to byte[]) and vice versa.
 * 
 * @author benedekh
 */
class JsonDispatcher extends AbstractMessageDispatcher {

	val Logger logger

	/**
	 * @param factory the logger factory
	 */
	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
	}

	override dispatchMessage(byte[] rawMessage) {
		// left empty on purpose
	}

	override convertMessageToRaw(Object message) throws IllegalArgumentException {
		try {
			val barrierMessage = message as BarrierStateMessage
			val gson = new Gson
			val str = gson.toJson(barrierMessage)
			return str.bytes
		} catch (Exception ex) {
			logger.error(ex.message)
			throw new IllegalArgumentException
		}
	}
}
