package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancyValue

interface ISegmentOccupancyListener {
	def void onSegmentOccupancy(int id, SegmentOccupancyValue state);
}
