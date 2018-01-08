package hu.bme.mit.inf.modes3.components.occupancyquery

import hu.bme.mit.inf.modes3.components.occupancyquery.bridge.IOccupancyQueryBridge

interface IOccupancyQuery extends Runnable {
	def void setOccupancyQueryBridge(IOccupancyQueryBridge occupancyQueryBridge)
}
