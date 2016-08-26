package hu.bme.mit.inf.modes3.messaging.mms.handlers.control

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedControlOrBuilder

interface TrainReferenceSpeedControlHandler {
	def void handleTrainReferenceSpeedControl(TrainReferenceSpeedControlOrBuilder event);
}
