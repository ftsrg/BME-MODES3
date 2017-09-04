package hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

interface ITrainReferenceSpeedCallback {
	def void onTrainReferenceSpeed(int id, int speed, TrainDirection direction);
}