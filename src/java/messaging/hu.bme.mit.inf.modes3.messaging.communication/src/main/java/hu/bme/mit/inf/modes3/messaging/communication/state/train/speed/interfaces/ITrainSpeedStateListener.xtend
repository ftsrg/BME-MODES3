package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

interface ITrainSpeedStateListener {
	def void onTrainSpeedState(int id, int speed, TrainDirection direction)
}
