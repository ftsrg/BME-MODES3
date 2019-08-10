package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyListener
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

/**
 * Forwards the {@link SegmentOccupancyMessage} message to the corresponding callback.
 * 
 * @author benedekh
 */
package class SegmentOccupancyClient implements IMessageHandler<SegmentOccupancyMessage> {
	private var ISegmentOccupancyListener callback

	/**
	 * @param controller the callback for the segment occupancy
	 */
	new(ISegmentOccupancyListener controller) {
		callback = controller
	}

	override handleMessage(SegmentOccupancyMessage message) {
		val id = message.segmentId
		val state = message.state
		callback.onSegmentOccupancy(id, state)
	}
}
