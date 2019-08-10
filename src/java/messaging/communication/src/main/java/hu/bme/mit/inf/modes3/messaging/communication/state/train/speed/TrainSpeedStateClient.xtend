package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed

import hu.bme.mit.inf.modes3.messaging.messages.status.TrainReferenceSpeedMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateListener

/**
 * Forwards the {@link TrainReferenceSpeedMessage} message to the corresponding callback.
 * 
 * @author benedekh
 */
class TrainSpeedStateClient implements IMessageHandler<TrainReferenceSpeedMessage> {
	private var ITrainSpeedStateListener callback

	/**
	 * @param controller the callback for the train reference speed
	 */
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
