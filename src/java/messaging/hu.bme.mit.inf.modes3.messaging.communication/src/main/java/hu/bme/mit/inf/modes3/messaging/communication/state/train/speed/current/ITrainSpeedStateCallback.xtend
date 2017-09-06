package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current

import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.ITrainReferenceSpeedListener

interface ITrainSpeedStateCallback {
	def void setTrainCurrentSpeedListener(ITrainCurrentSpeedListener trainCurrentSpeedListener)
	def void setTrainReferenceSpeedListener(ITrainReferenceSpeedListener trainReferenceSpeedListener)
}