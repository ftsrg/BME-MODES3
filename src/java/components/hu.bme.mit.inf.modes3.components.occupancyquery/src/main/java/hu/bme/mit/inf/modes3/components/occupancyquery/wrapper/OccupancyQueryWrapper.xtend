package hu.bme.mit.inf.modes3.components.occupancyquery.wrapper

import hu.bme.mit.inf.modes3.components.occupancyquery.IOccupancyQuery
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory

class OccupancyQueryWrapper extends AbstractCommunicationComponent implements IOccupancyQueryWrapper {

	val IOccupancyQuery occupancyQuery

	new(IOccupancyQuery occupancyQuery, MessagingService messagingService, ILoggerFactory factory) {
		super(messagingService, factory)
		this.occupancyQuery = occupancyQuery
		this.occupancyQuery.occupancyQueryWrapper = this
	}

	override sendSegmentOccupation(int id, SegmentOccupancy state) {
		locator.trackElementStateSender.sendSegmentOccupation(id, state)
	}

	override run() {
		occupancyQuery.run
	}

}
