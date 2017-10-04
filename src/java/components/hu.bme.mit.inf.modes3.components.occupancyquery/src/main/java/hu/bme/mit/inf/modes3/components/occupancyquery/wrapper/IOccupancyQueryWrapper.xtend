package hu.bme.mit.inf.modes3.components.occupancyquery.wrapper

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy

interface IOccupancyQueryWrapper {
	def void sendSegmentOccupation(int id, SegmentOccupancy state)
}