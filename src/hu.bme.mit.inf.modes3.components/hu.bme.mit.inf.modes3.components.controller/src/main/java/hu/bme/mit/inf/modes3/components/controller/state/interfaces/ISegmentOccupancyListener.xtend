package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentOccupancy

interface ISegmentOccupancyListener {
	def void onSegmentOccupancy(int id, SegmentOccupancy state);
}
