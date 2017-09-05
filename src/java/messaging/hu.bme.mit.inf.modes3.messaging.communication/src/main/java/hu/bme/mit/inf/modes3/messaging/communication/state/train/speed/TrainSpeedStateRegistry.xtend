package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed

import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current.ITrainCurrentSpeedChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current.ITrainCurrentSpeedListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.ITrainReferenceSpeedChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.ITrainReferenceSpeedListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import java.util.AbstractMap.SimpleEntry
import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArraySet
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainSpeedStateRegistry implements ITrainSpeedStateRegistry {
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger

	@Accessors(#[PACKAGE_GETTER, PACKAGE_SETTER]) val TrainSpeedStateCallback callback

	val referenceSpeeds = new ConcurrentHashMap<Integer, Map.Entry<Integer, TrainDirection>>
	val referenceSpeedListeners = new CopyOnWriteArraySet<ITrainReferenceSpeedListener>
	val referenceSpeedChangeListeners = new CopyOnWriteArraySet<ITrainReferenceSpeedChangeListener>

	val currentSpeeds = new ConcurrentHashMap<Integer, Map.Entry<Integer, TrainDirection>>
	val currentSpeedListeners = new CopyOnWriteArraySet<ITrainCurrentSpeedListener>
	val currentSpeedChangeListeners = new CopyOnWriteArraySet<ITrainCurrentSpeedChangeListener>

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)

		callback = new TrainSpeedStateCallback(dispatcher, new ITrainCurrentSpeedListener() {

			override onTrainCurrentSpeed(int id, int speed, TrainDirection direction) {
				logger.info('''TrainCurrentSpeed message recieved, id=«id», speed=«speed», direction=«direction»''')
				val previousRecord = currentSpeeds.get(id)
				val oldSpeed = previousRecord?.key
				val oldDirection = previousRecord?.value

				if (previousRecord === null || oldSpeed != speed || oldDirection != direction) {
					logger.
						info('''TrainCurrentSpeed cached values are different from the new ones, id=«id», cachedSpeed=«oldSpeed», cachedDirection=«oldDirection»''')
					currentSpeedChangeListeners.forEach [
						it.onTrainCurrentSpeedChange(id, oldSpeed, oldDirection, speed, direction)
					]
					currentSpeeds.put(id, new SimpleEntry(speed, direction))
				}

				currentSpeedListeners.forEach[it.onTrainCurrentSpeed(id, speed, direction)]
			}
		}, new ITrainReferenceSpeedListener() {

			override onTrainReferenceSpeed(int id, int speed, TrainDirection direction) {
				logger.info('''TrainReferenceSpeed message recieved, id=«id», speed=«speed», direction=«direction»''')
				val previousRecord = referenceSpeeds.get(id)
				val oldSpeed = previousRecord?.key
				val oldDirection = previousRecord?.value

				if (previousRecord === null || oldSpeed != speed || oldDirection != direction) {
					logger.
						info('''TrainReferenceSpeed cached values are different from the new ones, id=«id», cachedSpeed=«oldSpeed», cachedDirection=«oldDirection»''')
					referenceSpeedChangeListeners.forEach [
						it.onTrainReferenceSpeedChange(id, oldSpeed, oldDirection, speed, direction)
					]
					referenceSpeeds.put(id, new SimpleEntry(speed, direction))
				}

				referenceSpeedListeners.forEach[it.onTrainReferenceSpeed(id, speed, direction)]
			}
		})
	}

	override getCurrentSpeed(int trainId) {
		currentSpeeds.get(trainId)?.key
	}

	override getCurrentDirection(int trainId) {
		currentSpeeds.get(trainId)?.value
	}

	override getCurrentTrainAddresses() {
		currentSpeeds.keySet.toSet
	}

	override addTrainCurrentSpeedListener(ITrainCurrentSpeedListener listener) {
		currentSpeedListeners.add(listener)
	}

	override addTrainCurrentSpeedChangeListener(ITrainCurrentSpeedChangeListener listener) {
		currentSpeedChangeListeners.add(listener)
	}

	override getReferenceSpeed(int trainId) {
		referenceSpeeds.get(trainId)?.key
	}

	override getReferenceDirection(int trainId) {
		referenceSpeeds.get(trainId)?.value
	}

	override getReferenceTrainAddresses() {
		referenceSpeeds.keySet.toSet
	}

	override addTrainReferenceSpeedListener(ITrainReferenceSpeedListener listener) {
		referenceSpeedListeners.add(listener)
	}

	override addTrainReferenceSpeedChangeListener(ITrainReferenceSpeedChangeListener listener) {
		referenceSpeedChangeListeners.add(listener)
	}

}
