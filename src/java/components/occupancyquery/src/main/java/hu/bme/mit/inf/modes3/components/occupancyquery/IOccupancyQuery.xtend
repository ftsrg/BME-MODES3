package hu.bme.mit.inf.modes3.components.occupancyquery

import hu.bme.mit.inf.modes3.components.occupancyquery.bridge.IOccupancyQueryBridge

/**
 * The interface of the occupancy query application.
 */
interface IOccupancyQuery extends Runnable {
	/**
	 * Registers the bridge between the application and communication network.
	 * 
	 * @param occupancyQueryBridge the bridge between the application and the communication network 
	 */
	def void setOccupancyQueryBridge(IOccupancyQueryBridge occupancyQueryBridge)
}
