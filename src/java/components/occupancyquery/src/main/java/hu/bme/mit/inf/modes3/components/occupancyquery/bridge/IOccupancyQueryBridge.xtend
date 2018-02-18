package hu.bme.mit.inf.modes3.components.occupancyquery.bridge

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy

interface IOccupancyQueryBridge {
	def void sendSegmentOccupation(int id, SegmentOccupancy state)
}
