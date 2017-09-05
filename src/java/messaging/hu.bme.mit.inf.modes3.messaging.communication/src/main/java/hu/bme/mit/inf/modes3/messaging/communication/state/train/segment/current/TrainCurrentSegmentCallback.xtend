package hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current

import hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces.ITrainCurrentSegmentListener
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

package class TrainCurrentSegmentCallback implements ITrainCurrentSegmentListener {
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITrainCurrentSegmentListener stateListener

	new(AbstractMessageDispatcher dispatcher, ITrainCurrentSegmentListener stateListener) {
		this.stateListener = stateListener
		val currentSegmentClient = new TrainCurrentSegmentClient(this)
		dispatcher.trainCurrentSegmentHandler = currentSegmentClient
	}

	override onTrainCurrentSegment(int trainId, int segmentId) {
		stateListener?.onTrainCurrentSegment(trainId, segmentId)
	}

}
