package hu.bme.mit.inf.modes3.messaging.communication.command.train

import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainReferenceSpeedCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.command.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class TrainReferenceSpeedCommandClient implements IMessageHandler<TrainReferenceSpeedCommand> {

	private var ITrainReferenceSpeedCommandListener callback

	new(ITrainReferenceSpeedCommandListener controller) {
		callback = controller
	}

	override handleMessage(TrainReferenceSpeedCommand message) {
		val trainId = message.trainId
		val referenceSpeed = message.referenceSpeed
		val direction = message.direction
		callback.onTrainReferenceSpeedAndDirectionCommand(trainId, referenceSpeed, direction	)
	}

}
