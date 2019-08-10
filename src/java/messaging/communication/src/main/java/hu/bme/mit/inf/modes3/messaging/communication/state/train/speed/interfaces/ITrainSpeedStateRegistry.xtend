package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import java.util.Set

/**
 * An in-memory cache that notifies the listeners if either the speed or the direction of movement
 * of a train has changed.
 * 
 * @author benedekh
 */
interface ITrainSpeedStateRegistry {
	/**
	 * @param trainId the ID of the train
	 * @return the recent speed of the train
	 */
	def Integer getSpeed(int trainId)

	/**
	 * @param trainId the ID of the train
	 * @return the recent direction of movement of the train
	 */	
	 def TrainDirection getDirection(int trainId)

	/**
	 * @return the train IDs whose states are tracked
	 */
	def Set<Integer> getTrainIds()

	/**
	 * Registers a train speed state listener.
	 * 
	 * @param listener the listener to be registered
	 */
	def void addTrainSpeedStateListener(ITrainSpeedStateListener listener)

	/**
	 * Registers a train speed state change listener.
	 * 
	 * @param listener the listener to be registered
	 */
	def void addTrainSpeedStateChangeListener(ITrainSpeedStateChangeListener listener)
}
