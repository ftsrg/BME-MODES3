package hu.bme.mit.inf.modes3.components.barrier

import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import java.util.Set
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import org.slf4j.ILoggerFactory

class TrackSupervisor extends AbstractCommunicationComponent implements ISegmentOccupancyChangeListener {

	var ConcurrentMap<Integer, SegmentOccupancy> supervisedSections
	val BarrierCommander barrierCommander

	new(MessagingService railwayTrackStack, MessagingService barrierStack, ILoggerFactory factory,
		Set<Integer> supervisedSections) {
		super(railwayTrackStack, factory)
		super.locator.trackElementStateRegistry.segmentOccupancyChangeListener = this

		barrierCommander = new BarrierCommander(barrierStack, factory)
		this.supervisedSections = new ConcurrentHashMap<Integer, SegmentOccupancy>
		supervisedSections.forEach[this.supervisedSections.put(it, SegmentOccupancy.FREE)]
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		val previousStatus = supervisedSections.get(id)

		if (previousStatus !== null && previousStatus !== newValue) {
			supervisedSections.put(id, newValue)

			if (newValue == SegmentOccupancy.OCCUPIED) {
				barrierCommander.sendBarrierMessage("closed")
			} else if (supervisedSections.entrySet.forall[it.value == SegmentOccupancy.FREE]) {
				barrierCommander.sendBarrierMessage("opened")
			}
		}
	}

	override run() {
		Thread.currentThread.join
	}

}
