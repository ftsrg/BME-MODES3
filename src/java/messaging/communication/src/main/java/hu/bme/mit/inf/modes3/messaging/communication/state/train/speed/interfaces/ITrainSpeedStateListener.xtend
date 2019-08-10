package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

/**
 * A listener for the train's speed and direction of movement.
 * 
 * @author benedekh
 */
interface ITrainSpeedStateListener {
	/**
	 * Processes the train's speed and direction of movement.
	 * 
	 * @param id the ID of the train
	 * @param speed the speed of the train
	 * @param direction the direction of movement of the train
	 */
	def void onTrainSpeedState(int id, int speed, TrainDirection direction)
}
