package hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

/**
 * A commander that sends the train commands.
 * 
 * @author benedekh
 */
interface ITrainCommander {
	
	/**
	 * Sends a train reference speed command.
	 * 
	 * @param id the ID of the train
	 * @param speed the reference speed of the train
	 * @param direction the direction of movement of the train
	 */
	def void setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction)

}
