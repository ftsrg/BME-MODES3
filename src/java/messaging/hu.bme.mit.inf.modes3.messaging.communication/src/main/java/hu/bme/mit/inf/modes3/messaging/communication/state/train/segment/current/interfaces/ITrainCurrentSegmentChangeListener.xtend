package hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces

interface ITrainCurrentSegmentChangeListener {
	def void onTrainCurrentSegmentChange(int trainId, int oldSegmentId, int newSegmentId)
}
