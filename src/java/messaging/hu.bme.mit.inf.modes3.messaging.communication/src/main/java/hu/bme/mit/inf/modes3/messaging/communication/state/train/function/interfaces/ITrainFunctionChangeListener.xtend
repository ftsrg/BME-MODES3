package hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction

interface ITrainFunctionChangeListener {
	def void onTrainFunctionChange(int trainId, TrainFunction oldFunction, TrainFunction newFunction)
}
