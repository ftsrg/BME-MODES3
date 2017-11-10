package hu.bme.mit.inf.modes3.messaging.communication.state.train.function

import hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces.ITrainFunctionCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces.ITrainFunctionChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces.ITrainFunctionListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces.ITrainFunctionStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainFunctionStateRegistry implements ITrainFunctionStateRegistry {
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	val trainFunctions = new ConcurrentHashMap<Integer, TrainFunction>

	@Accessors(#[PACKAGE_GETTER, PACKAGE_SETTER]) val ITrainFunctionCallback trainFunctionCallback
	@Accessors(#[PRIVATE_GETTER, PUBLIC_SETTER]) var ITrainFunctionChangeListener trainFunctionChangeListener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		trainFunctionCallback = new TrainFunctionCallback(dispatcher)
		trainFunctionCallback.trainFunctionListener = new ITrainFunctionListener() {

			override onTrainFunction(int trainId, TrainFunction trainFunction) {
				logger.trace('''TrainFunctionMessage message arrived trainId=«trainId»''')
				val previousTrainFunction = trainFunctions.get(trainId)
				if (previousTrainFunction === null || previousTrainFunction != trainFunction) {
					logger.
						trace('''TrainFunctionMessage is different from the cached value train=«trainId», oldTrainFunction = «previousTrainFunction», newTrainFunction = «trainFunction»''')
					trainFunctionChangeListener?.onTrainFunctionChange(trainId, previousTrainFunction, trainFunction)
					trainFunctions.put(trainId, trainFunction)
				}
			}

		}
	}

	override getTrainFunction(int id) {
		if (trainFunctions.get(id) === null) {
			logger.
				trace('''The registry was asked for the function of Train #«id» but there is no information in the cache, default «TrainFunction.OFF» function is used instead''')
			trainFunctions.put(id, TrainFunction.OFF)
		}
		trainFunctions.get(id)
	}

}
