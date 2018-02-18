package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

interface ITrainSpeedStateChangeListener {
	def void onTrainSpeedStateChange(int trainId, int oldSpeed, TrainDirection oldDirection, int newSpeed, TrainDirection newDirection)
}
