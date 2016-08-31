package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentOccupancy

interface ISegmentOccupancyChangeListener {
		def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue);
}