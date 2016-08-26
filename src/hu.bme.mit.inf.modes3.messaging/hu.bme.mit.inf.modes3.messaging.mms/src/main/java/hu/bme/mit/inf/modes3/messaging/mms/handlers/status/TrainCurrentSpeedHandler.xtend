package hu.bme.mit.inf.modes3.messaging.mms.handlers.status

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeedOrBuilder

interface TrainCurrentSpeedHandler {
	def void handleTrainCurrentSpeed(TrainCurrentSpeedOrBuilder event);
}
