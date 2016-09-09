package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator

class YakinduReleaseToHandler implements MessageHandler<YakinduReleaseTo> {

	private var IYakinduMessageHandler handler

	new(IYakinduMessageHandler _handler) {
		handler = _handler
	}

	override handleMessage(YakinduReleaseTo message) {
		handler.releaseTo(message.targetID,
			ConnectionDirectionTransformator.toInternalDirection(message.direction))
	}

}
