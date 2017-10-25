package hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

interface ITrainCommander {

	def void setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction)

}
