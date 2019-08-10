package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

/**
 * Sends the train's speed and direction of movement.
 * 
 * @author benedekh
 */
interface ITrainSpeedStateSender {
	/**
	 * Sends the train's speed and direction of movement.
	 * 
	 * @param trainId the ID of the train
	 * @param speed the speed of the train
	 * @param direction the direction of movement of the train
	 */
	def void sendTrainReferenceSpeedAndDirection(int trainId, int speed, TrainDirection direction)
}
