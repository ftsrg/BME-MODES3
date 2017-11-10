package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

interface ITrainSpeedSender {
	def void sendTrainCurrentSpeedAndDirection(int trainId, int speed, TrainDirection direction)
	def void sendTrainReferenceSpeedAndDirection(int trainId, int speed, TrainDirection direction)
}
