package hu.bme.mit.inf.modes3.components.occupancyquery.bridge

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy

/**
 * The bridge between the application and the communication network.
 * 
 * @author benedekh
 */
interface IOccupancyQueryBridge {
	
	/**
	 * Sends the occupancy state of the given segment over the network
	 * 
	 * @param id the ID of the track segment
	 * @param state the occupancy state of the segment
	 */
	def void sendSegmentOccupation(int id, SegmentOccupancy state)
}
