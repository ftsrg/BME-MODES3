package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultToOrBuilder
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator

class IYakinduReserveResultToHandler implements MessageHandler<YakinduReserveResultToOrBuilder> {
	private var IYakinduMessageHandler handler

	new(IYakinduMessageHandler _handler) {
		handler = _handler
	}

	override handleMessage(YakinduReserveResultToOrBuilder message) {
		handler.reserveResultTo(message.targetID,
			ConnectionDirectionTransformator.toInternalDirection(message.direction), message.result)
	}
}
