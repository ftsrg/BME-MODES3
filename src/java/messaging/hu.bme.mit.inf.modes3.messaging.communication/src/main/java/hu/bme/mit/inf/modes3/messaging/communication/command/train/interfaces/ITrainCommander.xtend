package hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction

interface ITrainCommander {

	def void setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction)

	def void setTrainFunction(int id, TrainFunction trainFunction)

}
