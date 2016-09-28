package hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionValue

interface ITrainReferenceSpeedCallback {
	def void onTrainReferenceSpeed(int id, int speed, TrainDirectionValue direction);
}