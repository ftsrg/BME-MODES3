package hu.bme.mit.inf.modes3.messaging.communication.state.train.function

import hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces.ITrainFunctionSender
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainFunctionStateMessage

class TrainFunctionSender implements ITrainFunctionSender {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendTrainFunction(int trainId, TrainFunction trainFunction) {
		logger.trace('''TrainFunction message sent with trainId=«trainId», trainFunction=«trainFunction»''')
		mms.sendMessage(new TrainFunctionStateMessage(trainId, trainFunction))
	}

}
