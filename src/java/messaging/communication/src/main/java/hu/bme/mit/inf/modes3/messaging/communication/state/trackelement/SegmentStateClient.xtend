package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateListener
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

/**
 * Forwards the {@link SegmentStateMessage} message to the corresponding callback.
 * 
 * @author benedekh
 */
package class SegmentStateClient implements IMessageHandler<SegmentStateMessage> {
	private var ISegmentStateListener callback

	/**
	 * @param controller the callback for the segment state
	 */
	new(ISegmentStateListener controller) {
		callback = controller
	}

	override handleMessage(SegmentStateMessage message) {
		val id = message.segmentId
		val state = message.state
		callback.onSegmentState(id, state)
	}

}
