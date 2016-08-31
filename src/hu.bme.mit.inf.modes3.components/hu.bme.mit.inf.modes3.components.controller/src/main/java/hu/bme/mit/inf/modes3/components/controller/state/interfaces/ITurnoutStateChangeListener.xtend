package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState

interface ITurnoutStateChangeListener {
	def void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue);
}
