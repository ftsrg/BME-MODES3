package hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current

import hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces.ITrainCurrentSegmentChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces.ITrainCurrentSegmentListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.segment.current.interfaces.ITrainCurrentSegmentRegistry
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainCurrentSegmentRegistry implements ITrainCurrentSegmentRegistry {
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	val currentSegments = new ConcurrentHashMap<Integer, Integer>

	@Accessors(#[PACKAGE_GETTER, PACKAGE_SETTER]) val TrainCurrentSegmentCallback trainCurrentSegmentCallback
	@Accessors(#[PRIVATE_GETTER,
		PUBLIC_SETTER]) var ITrainCurrentSegmentChangeListener trainCurrentSegmentChangeListener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		trainCurrentSegmentCallback = new TrainCurrentSegmentCallback(dispatcher, new ITrainCurrentSegmentListener() {

			override onTrainCurrentSegment(int trainId, int segmentId) {
				logger.trace('''TrainCurrentSegmentMessage message arrived trainId=«trainId»''')
				val previousSegment = currentSegments.get(trainId)
				if (previousSegment === null || previousSegment != segmentId) {
					logger.
						trace('''TrainCurrentSegmentMessage is different from the cached value train=«trainId», oldSegmentId = «previousSegment», newSegmentId = «segmentId»''')
					trainCurrentSegmentChangeListener?.onTrainCurrentSegmentChange(trainId, previousSegment, segmentId)
					currentSegments.put(trainId, segmentId)
				}
			}

		})
	}

	override getCurrentSegmentId(int trainId) {
		currentSegments.get(trainId)
	}
}
