package hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces

interface ITrainCurrentSegmentListener {
	def void onTrainCurrentSegment(int trainId, int segmentId)
}
