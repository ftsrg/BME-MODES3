package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseToOrBuilder
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator

class YakinduRelaseToHandler implements MessageHandler<YakinduReleaseToOrBuilder> {

	private var IYakinduMessageHandler handler

	new(IYakinduMessageHandler _handler) {
		handler = _handler
	}

	override handleMessage(YakinduReleaseToOrBuilder message) {
		handler.releaseTo(message.targetID,
			ConnectionDirectionTransformator.toInternalDirection(message.direction))
	}

}
