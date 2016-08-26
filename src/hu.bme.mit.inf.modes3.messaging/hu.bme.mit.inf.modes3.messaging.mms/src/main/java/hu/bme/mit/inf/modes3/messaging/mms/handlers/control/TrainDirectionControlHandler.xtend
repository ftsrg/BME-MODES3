package hu.bme.mit.inf.modes3.messaging.mms.handlers.control

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionControlOrBuilder

interface TrainDirectionControlHandler {
	def void handleTrainDirectionControl(TrainDirectionControlOrBuilder event);
}
