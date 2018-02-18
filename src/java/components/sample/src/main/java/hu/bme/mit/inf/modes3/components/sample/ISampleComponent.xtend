package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.components.sample.bridge.ISampleComponentBridge

interface ISampleComponent extends Runnable {
	def void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue)
	
	def void setSampleComponentBridge(ISampleComponentBridge componentBridge)
}