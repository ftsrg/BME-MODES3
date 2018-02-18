package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed

import hu.bme.mit.inf.modes3.messaging.messages.status.TrainReferenceSpeedMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateListener

class TrainSpeedStateClient implements IMessageHandler<TrainReferenceSpeedMessage> {
	private var ITrainSpeedStateListener callback

	new(ITrainSpeedStateListener controller) {
		callback = controller
	}

	override handleMessage(TrainReferenceSpeedMessage message) {
		val trainId = message.trainId
		val referenceSpeed = message.referenceSpeed
		val direction = message.direction
		callback.onTrainSpeedState(trainId, referenceSpeed, direction)
	}
}
