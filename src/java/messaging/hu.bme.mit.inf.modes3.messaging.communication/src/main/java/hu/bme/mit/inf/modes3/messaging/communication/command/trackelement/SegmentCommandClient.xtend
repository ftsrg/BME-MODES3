package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class SegmentCommandClient implements IMessageHandler<SegmentCommand> {
	private var ISegmentCommandListener callback

	new(ISegmentCommandListener controller) {
		callback = controller
	}

	override handleMessage(SegmentCommand message) {
		val id = message.segmentId
		val state = message.state
		callback.onSegmentCommand(id, state)
	}

}
