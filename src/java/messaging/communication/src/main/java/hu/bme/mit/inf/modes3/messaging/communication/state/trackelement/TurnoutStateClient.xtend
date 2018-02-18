package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateListener
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class TurnoutStateClient implements IMessageHandler<TurnoutStateMessage> {
	private var ITurnoutStateListener callback

	new(ITurnoutStateListener controller) {
		callback = controller
	}

	override handleMessage(TurnoutStateMessage message) {
		val id = message.turnoutId
		val state = message.state
		callback.onTurnoutState(id, state)
	}

}
