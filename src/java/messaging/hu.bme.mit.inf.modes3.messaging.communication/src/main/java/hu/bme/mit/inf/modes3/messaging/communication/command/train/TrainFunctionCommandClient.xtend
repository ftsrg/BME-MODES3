package hu.bme.mit.inf.modes3.messaging.communication.command.train

import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainFunctionCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.command.TrainFunctionCommand
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class TrainFunctionCommandClient implements IMessageHandler<TrainFunctionCommand> {
	private var ITrainFunctionCommandListener callback

	new(ITrainFunctionCommandListener controller) {
		callback = controller
	}

	override handleMessage(TrainFunctionCommand message) {
		val trainId = message.trainId
		val trainFunction = message.trainFunction
		callback.onTrainFunctionCommand(trainId, trainFunction)
	}

}
