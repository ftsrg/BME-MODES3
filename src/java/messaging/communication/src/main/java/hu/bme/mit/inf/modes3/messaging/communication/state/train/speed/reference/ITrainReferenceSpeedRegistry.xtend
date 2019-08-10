package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import java.util.Set

/**
 * An in-memory cache that notifies the listeners if either the reference speed or the reference 
 * direction of movement of a train has changed.
 * 
 * @author benedekh
 */
interface ITrainReferenceSpeedRegistry {
	/**
	 * @param trainId the ID of the train
	 * @return the reference speed of the train
	 */
	def Integer getReferenceSpeed(int trainId)

	/**
	 * @param trainId the ID of the train
	 * @return the reference direction of movement of the train
	 */
	def TrainDirection getReferenceDirection(int trainId)

	/**
	 * @return the train IDs whose states are tracked
	 */
	def Set<Integer> getReferenceTrainAddresses()

	/**
	 * Registers a train reference speed state listener.
	 * 
	 * @param listener the listener to be registered
	 */
	def void addTrainReferenceSpeedListener(ITrainReferenceSpeedListener listener)

	/**
	 * Registers a train reference speed state change listener.
	 * 
	 * @param listener the listener to be registered
	 */
	def void addTrainReferenceSpeedChangeListener(ITrainReferenceSpeedChangeListener listener)
}
