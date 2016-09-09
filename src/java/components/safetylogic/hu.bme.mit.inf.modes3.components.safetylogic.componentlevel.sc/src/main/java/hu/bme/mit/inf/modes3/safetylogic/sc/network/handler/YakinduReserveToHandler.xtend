package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveTo
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator

class YakinduReserveToHandler implements MessageHandler<YakinduReserveTo> {

	private var IYakinduMessageHandler handler

	new(IYakinduMessageHandler _handler) {
		handler = _handler
	}

	override handleMessage(YakinduReserveTo message) {
		handler.reserveTo(message.targetID,
			ConnectionDirectionTransformator.toInternalDirection(message.direction))
	}

}
