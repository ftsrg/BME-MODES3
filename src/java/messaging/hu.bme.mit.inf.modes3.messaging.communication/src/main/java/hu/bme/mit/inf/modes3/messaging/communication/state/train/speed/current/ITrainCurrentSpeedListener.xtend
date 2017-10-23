package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

interface ITrainCurrentSpeedListener {
	def void onTrainCurrentSpeed(int id, int speed, TrainDirection direction)
}
