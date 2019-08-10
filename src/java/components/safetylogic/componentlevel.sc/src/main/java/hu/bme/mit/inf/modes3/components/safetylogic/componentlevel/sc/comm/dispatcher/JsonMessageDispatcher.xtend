package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher

import com.google.gson.Gson
import hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces.ICanGoToListener
import hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces.ICannotGoToListener
import hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces.IReleaseToListener
import hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces.IReserveToListener
import hu.bme.mit.inf.modes3.messaging.messages.yakindu.YakinduProtocolMessage
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * A dispatcher that can serialize a Java class into JSON (and then to byte[]) and vice versa.
 * 
 * @author benedekh
 */
class JsonMessageDispatcher extends AbstractMessageDispatcher {

	val Logger logger

	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ICanGoToListener canGoToListener
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ICannotGoToListener cannotGoToListener
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var IReleaseToListener releaseToListener
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var IReserveToListener reserveToListener
	
	/**
	 * @param factory the logger factory
	 */
	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
	}

	override dispatchMessage(byte[] rawMessage) {
		try {
			val rawString = new String(rawMessage)
			val protocolMessage = (new Gson).fromJson(rawString, YakinduProtocolMessage)
			val targetID = protocolMessage.targetID
			val direction = protocolMessage.direction

			switch (protocolMessage.type) {
				case CAN_GO_TO: canGoToListener?.canGoTo(targetID, direction)
				case CANNOT_GO_TO: cannotGoToListener?.cannotGoTo(targetID, direction)
				case RESERVE_TO: reserveToListener?.reserveTo(targetID, direction)
				case RELEASE_TO: releaseToListener?.releaseTo(targetID, direction)
			}
		} catch(Exception ex) {
			logger.error(ex.message)
		}
	}

	override convertMessageToRaw(Object message) throws IllegalArgumentException {
		try {
			val protocolMessage = message as YakinduProtocolMessage
			val str = (new Gson).toJson(protocolMessage)
			return str.bytes
		} catch(Exception ex) {
			logger.error(ex.message)
			throw new IllegalArgumentException
		}
	}
}
