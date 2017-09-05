package hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.status.PhysicalObject
import java.util.Map

interface IComputerVisionStateSender {
	def void sendComputerVisionState(Map<String, PhysicalObject> physicalObjects, long timestamp, long frameIndex)
}
