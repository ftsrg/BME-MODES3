package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy

/**
 * A listener for the change of {@link SegmentOccupancy}. 
 * 
 * @author benedekh
 */
interface ISegmentOccupancyChangeListener {
	/**
	 * Processes the change of the segment's occupancy.
	 * 
	 * @param id the ID of the segment
	 * @param oldValue the old occupancy of the segment
	 * @param newValue the new occupancy of the segment
	 */
	def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue)
}
