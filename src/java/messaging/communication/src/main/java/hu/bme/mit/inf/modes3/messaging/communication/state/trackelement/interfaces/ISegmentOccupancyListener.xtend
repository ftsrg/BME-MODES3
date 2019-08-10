package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy

/**
 * A listener for the {@link SegmentOccupancy}. 
 * 
 * @author benedekh
 */
interface ISegmentOccupancyListener {
	/**
	 * Processes the segment occupancy.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the segment
	 */
	def void onSegmentOccupancy(int id, SegmentOccupancy state)
}
