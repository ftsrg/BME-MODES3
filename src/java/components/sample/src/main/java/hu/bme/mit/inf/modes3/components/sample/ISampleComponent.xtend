package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.components.sample.bridge.ISampleComponentBridge

/**
 * The interface of the sample application.
 * 
 * @author benedekh
 */
interface ISampleComponent extends Runnable {
	
	/**
	 * Callback for the segment occupancy changed event.
	 * 
	 * @param id the ID of the segment whose occupancy has changed
	 * @param oldValue the previous occupancy status
	 * @param newValue the new occupancy status	
	 */
	def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue)
	
	/**
	 * To register the bridge that connects the sample application to the communication network.
	 * 
	 * @param componentBridge the bridge to the communication network
	 */
	def void setSampleComponentBridge(ISampleComponentBridge componentBridge)
}