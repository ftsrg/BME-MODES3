package hu.bme.mit.inf.modes3.messaging.communication.command.train

import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainReferenceSpeedCommandListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Handles the train commands.
 * 
 * @author benedekh
 */
class TrainCommandCallback implements ITrainCommandCallback, ITrainReferenceSpeedCommandListener {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger

	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITrainReferenceSpeedCommandListener trainReferenceSpeedCommandListener

	/**
	 * @param dispatcher a dispatcher that dispatches the messages
	 * @param factory the logger factory
	 */
	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		val trainReferenceSpeedClient = new TrainReferenceSpeedCommandClient(this)
		dispatcher.trainReferenceSpeedCommandHandler = trainReferenceSpeedClient

		this.logger = factory.getLogger(this.class.name)
	}

	override onTrainReferenceSpeedAndDirectionCommand(int id, int speed, TrainDirection direction) {
		if(trainReferenceSpeedCommandListener === null) {
			logger.trace('''TrainReferenceSpeedCommand recieved, but the listener is not set''')
		} else {
			logger.trace('''TrainReferenceSpeedCommand recieved, id=«id», speed=«speed», direction=«direction»''')
			trainReferenceSpeedCommandListener.onTrainReferenceSpeedAndDirectionCommand(id, speed, direction)
		}
	}

}
