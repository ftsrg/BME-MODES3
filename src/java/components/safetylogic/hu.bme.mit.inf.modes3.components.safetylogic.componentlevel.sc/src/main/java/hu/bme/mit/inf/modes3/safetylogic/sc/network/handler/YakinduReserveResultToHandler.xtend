package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultTo
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator

class YakinduReserveResultToHandler implements MessageHandler<YakinduReserveResultTo> {
	private var IYakinduMessageHandler handler

	new(IYakinduMessageHandler _handler) {
		handler = _handler
	}

	override handleMessage(YakinduReserveResultTo message) {
		handler.reserveResultTo(message.targetID,
			ConnectionDirectionTransformator.toInternalDirection(message.direction), message.result)
	}
}
