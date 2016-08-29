package hu.bme.mit.inf.modes3.components.controller.turnout

import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.TurnoutStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateOrBuilder

package class TurnoutStateListener implements TurnoutStateHandler {
	private var TurnoutCallBackController callback
	
	new(TurnoutCallBackController controller){
		callback = controller
	}
	
	override handleMessage(TurnoutStateOrBuilder message) {
		val id = message.turnoutID
		val state = message.state
		callback.onTurnoutStateInfo(id, state)
	}
	
}