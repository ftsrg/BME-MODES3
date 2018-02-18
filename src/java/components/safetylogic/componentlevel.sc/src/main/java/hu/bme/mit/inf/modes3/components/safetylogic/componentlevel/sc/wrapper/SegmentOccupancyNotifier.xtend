package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.TrainInterface
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class SegmentOccupancyNotifier implements ISegmentOccupancyChangeListener {

	val Logger logger
	val int segmentId
	val TrainInterface.Provided segmentToBeNotified

	new(ILoggerFactory factory, int segmentId, TrainInterface.Provided segmentToBeNotified, ITrackElementStateRegistry stateRegistry) {
		this.logger = factory.getLogger(class.name)
		this.segmentId = segmentId
		this.segmentToBeNotified = segmentToBeNotified
		stateRegistry.registerSegmentOccupancyChangeListener = this
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		if(id == segmentId) {
			logger.debug('''Segment (ID=«id») is «newValue»''')
			switch (newValue) {
				case OCCUPIED: segmentToBeNotified.raiseOccupy
				case FREE: segmentToBeNotified.raiseUnoccupy
			}
		}
	}

}
