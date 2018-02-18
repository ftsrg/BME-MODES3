package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import java.util.Set

interface ITrainReferenceSpeedRegistry {
	def Integer getReferenceSpeed(int trainId)

	def TrainDirection getReferenceDirection(int trainId)

	def Set<Integer> getReferenceTrainAddresses()

	def void addTrainReferenceSpeedListener(ITrainReferenceSpeedListener listener)

	def void addTrainReferenceSpeedChangeListener(ITrainReferenceSpeedChangeListener listener)
}
