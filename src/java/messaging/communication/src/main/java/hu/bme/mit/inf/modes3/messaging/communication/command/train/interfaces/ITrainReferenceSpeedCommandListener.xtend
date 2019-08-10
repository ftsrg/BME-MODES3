package hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

/**
 * A listener for the train reference speed command. 
 * 
 * @author benedekh
 */
interface ITrainReferenceSpeedCommandListener {
	/**
	 * Executes the actions that are triggered by the command. 
	 * 
	 * @param id the ID of the train
	 * @param speed the reference speed of the train
	 * @param direction the direction of movement of the train 
	 */
	def void onTrainReferenceSpeedAndDirectionCommand(int id, int speed, TrainDirection direction)

}
