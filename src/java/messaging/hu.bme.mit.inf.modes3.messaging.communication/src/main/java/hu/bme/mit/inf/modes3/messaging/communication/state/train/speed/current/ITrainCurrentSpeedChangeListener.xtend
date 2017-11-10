package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

interface ITrainCurrentSpeedChangeListener {
	def void onTrainCurrentSpeedChange(int trainId, int oldSpeed, TrainDirection oldDirection, int newSpeed,
		TrainDirection newDirection)
}
