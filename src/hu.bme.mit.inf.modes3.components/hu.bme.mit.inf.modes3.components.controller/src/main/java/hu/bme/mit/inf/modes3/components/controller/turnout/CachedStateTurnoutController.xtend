package hu.bme.mit.inf.modes3.components.controller.turnout

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import java.util.concurrent.ConcurrentHashMap

abstract class CachedStateTurnoutController extends TurnoutCallBackController {
	val states = new ConcurrentHashMap<Integer, TurnoutStateValue>

	override onTurnoutStateInfo(int id, TurnoutStateValue state) {
		if(!states.get(id)?.equals(state)) {
			onTurnoutStateChange(id, state)
		}
		states.put(id, state);
	}

	def getState(int id) {
		val state = states.get(id)
		if(state == null) {

			states.put(id, TurnoutStateValue.DIVERGENT)
			return TurnoutStateValue.DIVERGENT
		// TODO refresh
		}
		return state
	}
	
	def void onTurnoutStateChange(int id, TurnoutStateValue state);

	

}