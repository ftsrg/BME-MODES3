package hu.bme.mit.inf.modes3.messaging.communication.command.train

import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainFunctionCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainReferenceSpeedCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainCommandCallback implements ITrainCommandCallback, ITrainReferenceSpeedCommandListener, ITrainFunctionCommandListener {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger

	@Accessors(#[PRIVATE_GETTER,
		PUBLIC_SETTER]) var ITrainReferenceSpeedCommandListener trainReferenceSpeedCommandListener
	@Accessors(#[PRIVATE_GETTER, PUBLIC_SETTER]) var ITrainFunctionCommandListener trainFunctionCommandListener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		val trainFunctionClient = new TrainFunctionCommandClient(this)
		val trainReferenceSpeedClient = new TrainReferenceSpeedCommandClient(this)
		dispatcher.trainFunctionCommandHandler = trainFunctionClient
		dispatcher.trainReferenceSpeedCommandHandler = trainReferenceSpeedClient

		this.logger = factory.getLogger(this.class.name)
	}

	override onTrainReferenceSpeedAndDirectionCommand(int id, int speed, TrainDirection direction) {
		if (trainReferenceSpeedCommandListener === null) {
			logger.trace('''TrainReferenceSpeedCommand recieved, but the listener is not set''')
		} else {
			logger.trace('''TrainReferenceSpeedCommand recieved, id=«id», speed=«speed», direction=«direction»''')
			trainReferenceSpeedCommandListener.onTrainReferenceSpeedAndDirectionCommand(id, speed, direction)
		}
	}

	override onTrainFunctionCommand(int id, TrainFunction trainFunction) {
		if (trainReferenceSpeedCommandListener === null) {
			logger.trace('''TrainFunctionCommand recieved, but the listener is not set''')
		} else {
			logger.trace('''TrainFunctionCommand recieved, id=«id», trainFunction=«trainFunction»''')
			trainFunctionCommandListener.onTrainFunctionCommand(id, trainFunction)
		}
	}

}
