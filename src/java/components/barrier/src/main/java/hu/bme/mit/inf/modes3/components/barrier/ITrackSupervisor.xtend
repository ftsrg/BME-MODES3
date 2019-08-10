package hu.bme.mit.inf.modes3.components.barrier

import hu.bme.mit.inf.modes3.components.barrier.bridge.ITrackSupervisorBridge
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy

/**
 * The interface of the barrier application.
 * 
 * @author benedekh
 */
interface ITrackSupervisor {
	/**
	 * Callback for the segment occupancy changed event.
	 * 
	 * @param id the ID of the segment whose occupancy has changed
	 * @param oldValue the previous occupancy status
	 * @param newValue the new occupancy status	
	 */
	def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue)

	/**
	 * To register the bridge that connects the barrier application to the communication network.
	 * 
	 * @param supervisorBridge the bridge to the communication network
	 */
	def void setSupervisorBridge(ITrackSupervisorBridge supervisorBridge)
}
