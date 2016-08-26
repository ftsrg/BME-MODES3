package hu.bme.mit.inf.modes3.messaging.mms.handlers.control

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainFunctionControlOrBuilder

interface TrainFunctionControlHandler {
	def void handleTrainFunctionControl(TrainFunctionControlOrBuilder event);
}
