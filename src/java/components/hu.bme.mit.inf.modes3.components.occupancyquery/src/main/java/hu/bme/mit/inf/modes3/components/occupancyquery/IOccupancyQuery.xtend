package hu.bme.mit.inf.modes3.components.occupancyquery

import hu.bme.mit.inf.modes3.components.occupancyquery.wrapper.IOccupancyQueryWrapper

interface IOccupancyQuery extends Runnable {
	def void setOccupancyQueryWrapper(IOccupancyQueryWrapper occupancyQueryWrapper)
}
