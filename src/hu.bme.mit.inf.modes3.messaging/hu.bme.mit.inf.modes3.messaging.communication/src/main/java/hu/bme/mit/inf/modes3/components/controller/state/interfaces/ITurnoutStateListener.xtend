package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState

interface ITurnoutStateListener {
	def void onTurnoutState(int id, TurnoutState state);
}
