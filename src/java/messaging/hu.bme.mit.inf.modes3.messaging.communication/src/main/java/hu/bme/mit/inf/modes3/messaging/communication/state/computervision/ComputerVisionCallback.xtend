package hu.bme.mit.inf.modes3.messaging.communication.state.computervision

import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.ComputerVisionInformation
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionListener
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class ComputerVisionCallback implements IComputerVisionCallback, IComputerVisionListener {

	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var IComputerVisionListener computerVisionListener
	Logger logger

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		dispatcher.computerVisionObjectPositionsHandler = new ComputerVisionClient(this)
	}

	override onComputerVisionDetection(List<ComputerVisionInformation> information, long timestamp, long frameindex) {
		if (computerVisionListener === null) {
			logger.trace('''ComputerVisionInformation recieved, but the listener is not set''')
		} else {
			logger.trace('''ComputerVisionInformation recieved, «information»''')
			computerVisionListener.onComputerVisionDetection(information, timestamp, frameindex)
		}
	}

}
