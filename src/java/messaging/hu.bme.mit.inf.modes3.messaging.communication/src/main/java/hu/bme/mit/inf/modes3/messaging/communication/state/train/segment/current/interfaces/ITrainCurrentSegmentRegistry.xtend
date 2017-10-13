package hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces

import hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces.ITrainCurrentSegmentChangeListener

interface ITrainCurrentSegmentRegistry {
	def int getCurrentSegmentId(int trainId)

	def void setTrainCurrentSegmentChangeListener(ITrainCurrentSegmentChangeListener listener)
}
