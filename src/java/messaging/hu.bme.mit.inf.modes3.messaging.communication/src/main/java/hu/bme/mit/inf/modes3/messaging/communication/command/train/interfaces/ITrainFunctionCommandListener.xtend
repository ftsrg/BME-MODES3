package hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction

interface ITrainFunctionCommandListener {
	def void onTrainFunctionCommand(int id, TrainFunction trainFunction)
}