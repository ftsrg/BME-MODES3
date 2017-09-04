package hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed

import hu.bme.mit.inf.modes3.messaging.messages.status.TrainReferenceSpeedMessage
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler
import java.util.List

class TrainReferenceSpeedClient implements IMessageHandler<TrainReferenceSpeedMessage> {

	var List<ITrainReferenceSpeedCallback> callbacks = newArrayList

	new(AbstractMessageDispatcher dispatcher) {
		dispatcher.trainReferenceSpeedHandler = this
	}

	def addTrainReferenceSpeedCallback(ITrainReferenceSpeedCallback callback) {
		callbacks.add(callback)
	}

	override handleMessage(TrainReferenceSpeedMessage message) {
		callbacks.forEach [
			it.onTrainReferenceSpeed(message.trainId, message.referenceSpeed, message.direction)
		]
	}

}
