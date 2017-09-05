package hu.bme.mit.inf.modes3.messaging.communication.command.train

import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander
import hu.bme.mit.inf.modes3.messaging.messages.command.TrainFunctionCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainCommander implements ITrainCommander {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var protected MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override setTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction) {
		logger.info('''TrainReferenceSpeedCommand sent with id=«id»(speed=«speed») direction=«direction»''')
		mms.sendMessage(new TrainReferenceSpeedCommand(id, speed, direction))
	}

	override setTrainFunction(int id, TrainFunction trainFunction) {
		logger.info('''TrainFunction sent with id=«id»(function=«trainFunction»)''')
		mms.sendMessage(new TrainFunctionCommand(id, trainFunction))
	}

}
