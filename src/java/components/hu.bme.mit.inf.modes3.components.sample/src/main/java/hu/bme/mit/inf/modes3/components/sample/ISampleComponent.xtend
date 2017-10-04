package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.components.sample.wrapper.ISampleComponentWrapper
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy

interface ISampleComponent extends Runnable {
	def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue)
	
	def void setSampleComponentWrapper(ISampleComponentWrapper componentWrapper)
}