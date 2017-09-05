package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

interface ITrainReferenceSpeedListener {
	def void onTrainReferenceSpeed(int id, int speed, TrainDirection direction)
}
