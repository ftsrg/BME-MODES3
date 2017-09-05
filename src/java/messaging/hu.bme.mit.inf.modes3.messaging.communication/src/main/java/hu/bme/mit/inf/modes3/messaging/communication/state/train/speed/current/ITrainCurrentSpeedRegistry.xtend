package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import java.util.Set

interface ITrainCurrentSpeedRegistry {
	def Integer getCurrentSpeed(int trainId)

	def TrainDirection getCurrentDirection(int trainId)

	def Set<Integer> getCurrentTrainAddresses()

	def void addTrainCurrentSpeedListener(ITrainCurrentSpeedListener listener)

	def void addTrainCurrentSpeedChangeListener(ITrainCurrentSpeedChangeListener listener)
}
