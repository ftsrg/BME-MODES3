package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current

import hu.bme.mit.inf.modes3.messaging.messages.status.TrainCurrentSpeedMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

class TrainCurrentSpeedClient implements IMessageHandler<TrainCurrentSpeedMessage> {
	private var ITrainCurrentSpeedListener callback

	new(ITrainCurrentSpeedListener controller) {
		callback = controller
	}

	override handleMessage(TrainCurrentSpeedMessage message) {
		val trainId = message.trainId
		val currentSpeed = message.currentSpeed
		val direction = message.direction
		callback.onTrainCurrentSpeed(trainId, currentSpeed, direction)
	}
}
