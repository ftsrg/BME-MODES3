package hu.bme.mit.inf.modes3.components.controller.command.interfaces

import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState

interface ITurnoutCommandListener {
	def void onTurnoutCommand(int id, TurnoutState state)
}
