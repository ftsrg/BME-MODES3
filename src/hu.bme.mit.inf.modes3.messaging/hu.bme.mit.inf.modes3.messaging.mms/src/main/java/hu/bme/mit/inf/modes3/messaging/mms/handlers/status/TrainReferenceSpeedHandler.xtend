package hu.bme.mit.inf.modes3.messaging.mms.handlers

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedControlOrBuilder

interface TrainReferenceSpeedHandler {
	def void handleTrainReferenceSpeed(TrainReferenceSpeedControlOrBuilder event);
}
