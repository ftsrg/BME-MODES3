package hu.bme.mit.inf.modes3.messaging.communication.state.train.function

import hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces.ITrainFunctionListener
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainFunctionMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class TrainFunctionClient implements IMessageHandler<TrainFunctionMessage> {
	private var ITrainFunctionListener callback

	new(ITrainFunctionListener controller) {
		callback = controller
	}

	override handleMessage(TrainFunctionMessage message) {
		val trainId = message.trainId
		val trainFunction = message.trainFunction
		callback.onTrainFunction(trainId, trainFunction)
	}
}
