package hu.bme.mit.inf.modes3.components.controller.turnout

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import java.util.concurrent.ConcurrentHashMap

class CachedStateTurnoutController extends TurnoutCallBackController {
	var TurnoutStateChangeListener turnoutStateChangeListener
	var TurnoutControlInfoListener turnoutControlInfoListener
	val states = new ConcurrentHashMap<Integer, TurnoutStateValue>

	new(TurnoutStateChangeListener turnoutStateChangeListener, TurnoutControlInfoListener turnoutControlInfoListener) {
		this.turnoutStateChangeListener = turnoutStateChangeListener
		this.turnoutControlInfoListener = turnoutControlInfoListener
	}



	override onTurnoutStateInfo(int id, TurnoutStateValue state) {
		if(!states.get(id)?.equals(state)) {
			turnoutStateChangeListener.onTurnoutStateChange(id, state)
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

	override onTurnoutControlInfo(int id, TurnoutStateValue state) {
		turnoutControlInfoListener.onTurnoutControlInfo(id, state)
	}

}
