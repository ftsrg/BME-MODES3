package hu.bme.mit.inf.modes3.messaging.communication.state

import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class TurnoutStateClient implements IMessageHandler<TurnoutStateMessage> {
	private var TrackElementStateCallback callback

	new(TrackElementStateCallback controller) {
		callback = controller
	}

	override handleMessage(TurnoutStateMessage message) {
		val id = message.turnoutId
		val state = message.state
		callback.onTurnoutState(id, state)
	}

}
