package hu.bme.mit.inf.modes3.messaging.communication.state.interfaces

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy

interface ISegmentOccupancyChangeListener {
		def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue);
}
