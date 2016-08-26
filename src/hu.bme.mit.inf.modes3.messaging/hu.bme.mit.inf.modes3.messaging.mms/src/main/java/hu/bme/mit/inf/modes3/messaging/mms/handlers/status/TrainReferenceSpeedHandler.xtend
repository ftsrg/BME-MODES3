package hu.bme.mit.inf.modes3.messaging.mms.handlers.status

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedOrBuilder

interface TrainReferenceSpeedHandler {
	def void handleTrainReferenceSpeed(TrainReferenceSpeedOrBuilder event);
}
