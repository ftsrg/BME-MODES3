package hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current

import hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces.ITrainCurrentSegmentSender
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainCurrentSegmentMessage
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainCurrentSegmentSender implements ITrainCurrentSegmentSender {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendTrainCurrentSegment(int trainId, int segmentId) {
		logger.trace('''TrainCurrentSegment message sent with trainId=«trainId», segmentId=«segmentId»''')
		mms.sendMessage(new TrainCurrentSegmentMessage(trainId, segmentId))
	}
}
