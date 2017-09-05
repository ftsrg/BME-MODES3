package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference

import hu.bme.mit.inf.modes3.messaging.messages.status.TrainReferenceSpeedMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

class TrainReferenceSpeedClient implements IMessageHandler<TrainReferenceSpeedMessage> {
	private var ITrainReferenceSpeedListener callback

	new(ITrainReferenceSpeedListener controller) {
		callback = controller
	}

	override handleMessage(TrainReferenceSpeedMessage message) {
		val trainId = message.trainId
		val referenceSpeed = message.referenceSpeed
		val direction = message.direction
		callback.onTrainReferenceSpeed(trainId, referenceSpeed, direction)
	}
}
