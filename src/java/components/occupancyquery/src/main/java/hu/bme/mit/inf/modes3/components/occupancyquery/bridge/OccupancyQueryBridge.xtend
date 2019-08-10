package hu.bme.mit.inf.modes3.components.occupancyquery.bridge

import hu.bme.mit.inf.modes3.components.occupancyquery.IOccupancyQuery
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory

/**
 * The bridge between the application and the communication network.
 * 
 * @author benedekh
 */
class OccupancyQueryBridge extends AbstractCommunicationComponent implements IOccupancyQueryBridge {

	val IOccupancyQuery occupancyQuery

    /**
     * @param occupancyQuery the occupancy query application
     * @param messagingService the messaging service to the railway track
     * @param factory the logger factory
     */
	new(IOccupancyQuery occupancyQuery, MessagingService messagingService, ILoggerFactory factory) {
		super(messagingService, factory)
		this.occupancyQuery = occupancyQuery
		this.occupancyQuery.occupancyQueryBridge = this
	}

	override sendSegmentOccupation(int id, SegmentOccupancy state) {
		locator.trackElementStateSender.sendSegmentOccupation(id, state)
	}

	override run() {
		occupancyQuery.run
	}

}
