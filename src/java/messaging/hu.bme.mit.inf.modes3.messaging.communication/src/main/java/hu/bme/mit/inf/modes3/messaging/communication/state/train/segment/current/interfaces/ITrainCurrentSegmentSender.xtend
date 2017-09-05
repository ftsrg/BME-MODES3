package hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces

interface ITrainCurrentSegmentSender {
	
	def void sendTrainCurrentSegment(int trainId, int segmentId)
}
