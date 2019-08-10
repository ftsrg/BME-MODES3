package hu.bme.mit.inf.modes3.components.barrier.bridge

import hu.bme.mit.inf.modes3.components.barrier.ITrackSupervisor
import hu.bme.mit.inf.modes3.components.barrier.comm.BarrierCommander
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory

/**
 * The bridge between the barrier application and the communication network.
 * 
 * @author benedekh
 */
class TrackSupervisorBridge extends AbstractCommunicationComponent implements ISegmentOccupancyChangeListener, ITrackSupervisorBridge {

	val BarrierCommander barrierCommander
	val ITrackSupervisor trackSupervisor

	/**
	 * @param trackSupervisor the barrier application
	 * @param railwayTrackStack the messaging service to the railway track
	 * @param barrierStack the messaging service to the barrier
	 * @param factory the logger factory
	 */
	new(ITrackSupervisor trackSupervisor, MessagingService railwayTrackStack, MessagingService barrierStack,
		ILoggerFactory factory) {
		super(railwayTrackStack, factory)
		super.locator.trackElementStateRegistry.registerSegmentOccupancyChangeListener = this
		this.barrierCommander = new BarrierCommander(barrierStack, factory)
		this.trackSupervisor = trackSupervisor
		this.trackSupervisor.supervisorBridge = this
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		trackSupervisor.onSegmentOccupancyChange(id, oldValue, newValue)
	}

	override sendBarrierMessage(String barrierState) {
		barrierCommander.sendBarrierMessage(barrierState)
	}

	override run() {
		Thread.currentThread.join
	}

}
