package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

/**
 * Forwards the {@link SegmentCommand} message to the corresponding callback.  
 * 
 * @author benedekh
 */
package class SegmentCommandClient implements IMessageHandler<SegmentCommand> {
	private var ISegmentCommandListener callback

	/**
	 * @param controller the callback for the segment command
	 */
	new(ISegmentCommandListener controller) {
		callback = controller
	}

	override handleMessage(SegmentCommand message) {
		val id = message.segmentId
		val state = message.state
		callback.onSegmentCommand(id, state)
	}

}
