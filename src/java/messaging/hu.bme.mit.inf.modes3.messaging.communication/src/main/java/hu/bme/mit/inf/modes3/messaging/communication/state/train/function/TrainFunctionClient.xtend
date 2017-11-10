package hu.bme.mit.inf.modes3.messaging.communication.state.train.function

import hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces.ITrainFunctionListener
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainFunctionStateMessage

package class TrainFunctionClient implements IMessageHandler<TrainFunctionStateMessage> {
	private var ITrainFunctionListener callback

	new(ITrainFunctionListener controller) {
		callback = controller
	}

	override handleMessage(TrainFunctionStateMessage message) {
		val trainId = message.trainId
		val trainFunction = message.trainFunction
		callback.onTrainFunction(trainId, trainFunction)
	}
}
