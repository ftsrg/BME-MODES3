package hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations

/**
 * A listener for the {@link DccOperations} command. 
 * 
 * @author benedekh
 */
interface IDccCommandListener {
	/**
	 * Executes the actions that are triggered by the command. 
	 * 
	 * @param dccOperations the command to be executed 
	 */
	def void onDccCommand(DccOperations dccOperations)
}
