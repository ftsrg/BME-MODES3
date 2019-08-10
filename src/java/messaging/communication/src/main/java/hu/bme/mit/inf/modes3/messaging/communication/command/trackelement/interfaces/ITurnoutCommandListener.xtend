package hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

/**
 * A listener for the turnout command. 
 * 
 * @author benedekh
 */
interface ITurnoutCommandListener {
	/**
	 * Sets the state of the turnout denoted by its ID for the required state.
	 * 
	 * @param id the ID of the segment
	 * @param state the state of the turnout
	 */
	def void onTurnoutCommand(int id, TurnoutState state)
}
