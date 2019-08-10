package hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.status.PhysicalObject
import java.util.Map

/**
 * Sends positions of physical objects on the railway track.
 * 
 * @author benedekh
 */
interface IComputerVisionStateSender {
	/**
	 * Sends positions of physical objects on the railway track.
	 * 
	 * @param physicalObjects map of physical object names and their descriptions (e.g. position on the track)
	 * @param timestamp the time when the detection happened
	 * @param frameIndex the frame index when the detection happened
	 */
	def void sendComputerVisionState(Map<String, PhysicalObject> physicalObjects, long timestamp, long frameIndex)
}
