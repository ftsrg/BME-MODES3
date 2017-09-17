package hu.bme.mit.inf.modes3.components.barrier

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import java.util.Map
import org.slf4j.ILoggerFactory

class TrackSupervisor extends AbstractRailRoadCommunicationComponent implements ISegmentOccupancyChangeListener {

	var Map<Integer, SegmentOccupancy> supervisedSections
	val BarrierCommander barrierCommander

	new(CommunicationStack railwayTrackStack, CommunicationStack barrierStack, ILoggerFactory factory) {
		super(railwayTrackStack, factory)
		super.locator.trackElementStateRegistry.segmentOccupancyChangeListener = this

		barrierCommander = new BarrierCommander(barrierStack, factory)
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
