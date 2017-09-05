package hu.bme.mit.inf.modes3.messaging.communication.state.computervision

import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.ComputerVisionInformation
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionListener
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import java.util.List
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class ComputerVisionCallback implements IComputerVisionCallback, IComputerVisionListener {

	var IComputerVisionListener listener
	Logger logger

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		dispatcher.computerVisionObjectPositionsHandler = new ComputerVisionClient(this)
	}

	override setComputerVisionListener(IComputerVisionListener listener) {
		this.listener = listener
		logger.trace('''ComputerVisionListener changed''')
	}

	override onComputerVisionDetection(List<ComputerVisionInformation> information, long timestamp, long frameindex) {
		if (listener === null) {
			logger.trace('''ComputerVisionInformation recieved, but the listener is not set''')
		} else {
			logger.trace('''ComputerVisionInformation recieved, «information»''')
			listener.onComputerVisionDetection(information, timestamp, frameindex)
		}
	}

}
