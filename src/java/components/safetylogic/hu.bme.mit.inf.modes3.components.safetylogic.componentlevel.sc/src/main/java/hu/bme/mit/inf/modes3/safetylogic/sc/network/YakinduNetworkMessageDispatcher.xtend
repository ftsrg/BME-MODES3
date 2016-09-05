package hu.bme.mit.inf.modes3.safetylogic.sc.network

import com.google.protobuf.GeneratedMessageV3
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message.MessageType
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseToOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultToOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveToOrBuilder
import org.eclipse.xtend.lib.annotations.Accessors

class YakinduNetworkMessageDispatcher implements IMessageDispatcher {

	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<YakinduReleaseToOrBuilder> releaseToHandler;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<YakinduReserveToOrBuilder> reserveToHandler;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<YakinduReserveResultToOrBuilder> reserveResultToHandler;

	override dispatchMessage(byte[] rawMessage) {
		val message = Message.parseFrom(rawMessage)
		switch (message.type as MessageType) {
			case YAKINDU_RELEASE_TO: releaseToHandler?.handleMessage(message.yakinduReleaseTo)
			case YAKINDU_RESERVE_RESULT_TO: reserveResultToHandler?.handleMessage(message.yakinduReserveResultTo)
			case YAKINDU_RESERVE_TO: reserveToHandler?.handleMessage(message.yakinduReserveTo)
			default: return
		}
	}

	override convertMessageToRaw(Object message) throws IllegalArgumentException {
		try {
			internalConvertMessageToRaw(message as GeneratedMessageV3);
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e.message, e)
		}
	}

	def dispatch byte[] internalConvertMessageToRaw(YakinduReleaseTo _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.YAKINDU_RELEASE_TO
		message.yakinduReleaseTo = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(YakinduReserveTo _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.YAKINDU_RESERVE_TO
		message.yakinduReserveTo = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(YakinduReserveResultTo _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.YAKINDU_RESERVE_RESULT_TO
		message.yakinduReserveResultTo = _message
		message.build.toByteArray
	}

}
