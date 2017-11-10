package hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current

import hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces.ITrainCurrentSegmentListener
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainCurrentSegmentMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class TrainCurrentSegmentClient implements IMessageHandler<TrainCurrentSegmentMessage> {
	private var ITrainCurrentSegmentListener callback

	new(ITrainCurrentSegmentListener controller) {
		callback = controller
	}

	override handleMessage(TrainCurrentSegmentMessage message) {
		val trainId = message.trainId
		val segmentId = message.segmentId
		callback.onTrainCurrentSegment(trainId, segmentId)
	}
}
