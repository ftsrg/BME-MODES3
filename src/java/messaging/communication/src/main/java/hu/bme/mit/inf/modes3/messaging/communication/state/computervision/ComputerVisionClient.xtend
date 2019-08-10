package hu.bme.mit.inf.modes3.messaging.communication.state.computervision

import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.ComputerVisionInformation
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionListener
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.ThreeDimensionalPosition
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.TwoDimensionalPosition
import hu.bme.mit.inf.modes3.messaging.messages.status.ComputerVisionObjectPositionsMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler
import java.util.ArrayList

/**
 * Forwards the {@link ComputerVisionObjectPositionsMessage} message to the corresponding callback.  
 * 
 * @author benedekh
 */
package class ComputerVisionClient implements IMessageHandler<ComputerVisionObjectPositionsMessage> {

	private var IComputerVisionListener callback

	/**
	 * @param controller the callback for the Computer Vision Informations
	 */
	new(IComputerVisionListener controller) {
		callback = controller
	}

	override handleMessage(ComputerVisionObjectPositionsMessage message) {
		val information = new ArrayList<ComputerVisionInformation>
		message.physicalObjects.forEach [ name, physicalObject |
			physicalObject.markers.forEach [ name_, marker |
				information.add(new ComputerVisionInformation(marker.name, new TwoDimensionalPosition => [
					x = marker.screenPositions.head.x;
					y = marker.screenPositions.head.y
				], new ThreeDimensionalPosition => [
					x = marker.realposition.x
					y = marker.realposition.y
					z = marker.realposition.z
				], marker.tracked.head))
			]
		]
		callback.onComputerVisionDetection(information, message.timestamp, message.frameIndex)
	}

}
