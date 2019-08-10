package hu.bme.mit.inf.modes3.components.sample.bridge

/**
 * The bridge between the barrier application and the communication network.
 * 
 * @author benedekh
 */
interface ISampleComponentBridge {
	
	/**
	 * Disable a segment denoted by its ID.
	 * 
	 * @param segmentId the ID of the segment that should be disabled
	 */
	def void disableSegment(int segmentId)
}