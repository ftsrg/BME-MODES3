package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed

import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateRegistry
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

	@Accessors(#[PACKAGE_GETTER, PACKAGE_SETTER]) val ITrainSpeedStateCallback callback

	val speeds = new ConcurrentHashMap<Integer, Map.Entry<Integer, TrainDirection>>
	val speedListeners = new CopyOnWriteArraySet<ITrainSpeedStateListener>
	val speedChangeListeners = new CopyOnWriteArraySet<ITrainSpeedStateChangeListener>

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)

		callback = new TrainSpeedStateCallback(dispatcher)
		callback.trainSpeedStateListener = new ITrainSpeedStateListener() {

			override onTrainSpeedState(int id, int speed, TrainDirection direction) {
				logger.info('''TrainSpeed message recieved, id=«id», speed=«speed», direction=«direction»''')
				val previousRecord = speeds.get(id)
				val oldSpeed = previousRecord?.key
				val oldDirection = previousRecord?.value

				if(previousRecord === null || oldSpeed != speed || oldDirection != direction) {
					logger.info('''TrainSpeed cached values are different from the new ones, id=«id», cachedSpeed=«oldSpeed», cachedDirection=«oldDirection»''')
					speedChangeListeners.forEach [
						it.onTrainSpeedStateChange(id, oldSpeed, oldDirection, speed, direction)
					]
					speeds.put(id, new SimpleEntry(speed, direction))
				}

				speedListeners.forEach[it.onTrainSpeedState(id, speed, direction)]
			}

		}
	}

	override getSpeed(int id) {
		if(speeds.get(id) === null) {
			logger.trace('''The registry was asked for the reference speed of Train #«id» but there is no information in the cache, default 0 speed is used instead''')
			speeds.put(id, new SimpleEntry(0, TrainDirection.FORWARD))
		}
		speeds.get(id)?.key
	}

	override getDirection(int id) {
		if(speeds.get(id) === null) {
			logger.trace('''The registry was asked for the reference direction of Train #«id» but there is no information in the cache, default «TrainDirection.FORWARD» direction is used instead''')
			speeds.put(id, new SimpleEntry(0, TrainDirection.FORWARD))
		}
		speeds.get(id)?.value
	}

	override getTrainIds() {
		speeds.keySet.toSet
	}

	override addTrainSpeedStateListener(ITrainSpeedStateListener listener) {
		speedListeners.add(listener)
	}

	override addTrainSpeedStateChangeListener(ITrainSpeedStateChangeListener listener) {
		speedChangeListeners.add(listener)
	}

}
