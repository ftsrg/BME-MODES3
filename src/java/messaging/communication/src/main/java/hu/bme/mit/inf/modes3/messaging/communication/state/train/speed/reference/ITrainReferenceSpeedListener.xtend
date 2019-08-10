package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

/**
 * A listener for the train's reference speed and direction of movement.
 * 
 * @author benedekh
 */
interface ITrainReferenceSpeedListener {
	/**
	 * Processes the train's reference speed and direction of movement.
	 * 
	 * @param id the ID of the train
	 * @param speed the speed of the train
	 * @param direction the direction of movement of the train
	 */
	def void onTrainReferenceSpeed(int id, int speed, TrainDirection direction)
}
