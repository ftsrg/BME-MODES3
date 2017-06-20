package hu.bme.mit.inf.modes3.messaging.communication.computervision

import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.ComputerVisionHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.ComputerVisionObjectPositionsOrBuilder
import java.util.ArrayList
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ComputerVisionInformation
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.TwoDimensionalPosition
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ThreeDimensionalPosition

package class ComputerVisionClient implements ComputerVisionHandler {
	
	private var ComputerVisionCallback callback

	new(ComputerVisionCallback controller) {
		callback = controller
	}

//	def handleMessage(SegmentCommandOrBuilder message) {
//		val id = message.segmentID
//		val state = EnumTransformator.toGeneral(message.state)
//		callback.onSegmentCommand(id, state)
//	}
	
	override handleMessage(ComputerVisionObjectPositionsOrBuilder message) {
		val information = new ArrayList<ComputerVisionInformation>
		message.physicalObjectsMap.forEach[name,physicalObject |
			physicalObject.markersMap.forEach[name_, marker |
				information.add(new ComputerVisionInformation(marker.name, new TwoDimensionalPosition => [
					x = marker.screenPositionsList.head.x; y = marker.screenPositionsList.head.y
				] , new ThreeDimensionalPosition => [
					x = marker.realposition.x
					y = marker.realposition.y
					z = marker.realposition.z
				] , marker.trackedList.head))
			]
		]
		callback.onComputerVisionDetection(information)
	}
	
}