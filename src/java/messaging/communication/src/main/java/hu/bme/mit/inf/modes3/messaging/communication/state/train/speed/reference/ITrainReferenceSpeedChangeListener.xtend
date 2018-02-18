package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

interface ITrainReferenceSpeedChangeListener {
	def void onTrainReferenceSpeedChange(int trainId, int oldSpeed, TrainDirection oldDirection, int newSpeed,
		TrainDirection newDirection)
}
