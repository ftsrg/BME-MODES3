package hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces

import hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces.ITrainFunctionChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction

interface ITrainFunctionStateRegistry {
	def TrainFunction getTrainFunction(int trainId)

	def void setTrainFunctionChangeListener(ITrainFunctionChangeListener listener)
}
