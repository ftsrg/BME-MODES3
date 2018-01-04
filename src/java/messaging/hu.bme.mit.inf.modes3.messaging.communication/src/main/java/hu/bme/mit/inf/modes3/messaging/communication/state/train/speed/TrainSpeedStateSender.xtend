package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainReferenceSpeedMessage
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateSender

class TrainSpeedStateSender implements ITrainSpeedStateSender {
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendTrainReferenceSpeedAndDirection(int id, int speed, TrainDirection direction) {
		logger.info('''TrainReferenceSpeedMessage sent with id=«id»(speed=«speed») direction=«direction»''')
		mms.sendMessage(new TrainReferenceSpeedMessage(id, speed, direction))
	}
}
