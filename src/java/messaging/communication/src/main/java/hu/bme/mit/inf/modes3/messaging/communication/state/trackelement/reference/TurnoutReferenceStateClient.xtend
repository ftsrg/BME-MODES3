package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces.ITurnoutReferenceStateListener
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutReferenceStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler

package class TurnoutReferenceStateClient implements IMessageHandler<TurnoutReferenceStateMessage> {
	private var ITurnoutReferenceStateListener callback

	new(ITurnoutReferenceStateListener controller) {
		callback = controller
	}

	override handleMessage(TurnoutReferenceStateMessage message) {
		val id = message.turnoutId
		val state = message.state
		callback.onTurnoutReferenceState(id, state)
	}

}
