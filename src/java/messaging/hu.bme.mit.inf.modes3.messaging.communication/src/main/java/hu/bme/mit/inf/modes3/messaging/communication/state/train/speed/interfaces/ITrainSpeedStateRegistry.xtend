package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import java.util.Set

interface ITrainSpeedStateRegistry {
	def Integer getSpeed(int trainId)

	def TrainDirection getDirection(int trainId)

	def Set<Integer> getTrainIds()

	def void addTrainSpeedStateListener(ITrainSpeedStateListener listener)

	def void addTrainSpeedStateChangeListener(ITrainSpeedStateChangeListener listener)
}
