package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection

/**
 * A listener that is called if the train's reference speed state has changed.
 * 
 * @author benedekh
 */
interface ITrainReferenceSpeedChangeListener {
	/**
	 * The event handler that is invoked if the either the train's reference speed or its reference direction of 
	 * movement has changed.
	 * 
	 * @param trainId the ID of the train
	 * @param oldSpeed the previous speed of the train
	 * @param oldDirection the previous direction of movement of the train
	 * @param newSpeed the recent speed of the train
	 * @param newDirection the recent direction of movement of the train
	 */
	def void onTrainReferenceSpeedChange(int trainId, int oldSpeed, TrainDirection oldDirection, int newSpeed,
		TrainDirection newDirection)
}
