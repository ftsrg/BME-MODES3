package hu.bme.mit.inf.modes3.messaging.communication.computervision

import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.IComputerVisionListener
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import java.util.ArrayList
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ComputerVisionInformation

class ComputerVisionCallback implements IComputerVisionCallback{
	
	var IComputerVisionListener listener
	ProtobufMessageDispatcher dispatcher
	Logger logger
	
	new(ProtobufMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.dispatcher = dispatcher
		this.logger = factory.getLogger(this.class.name)
		
		dispatcher.computerVisionObjectPositionsHandler = new ComputerVisionClient(this)
	}
	
	override setComputerVisionListener(IComputerVisionListener listener) {
		this.listener = listener
		logger.trace('''ComputerVisionListener changed''')
	}
	
	def onComputerVisionDetection(ArrayList<ComputerVisionInformation> information, long timestamp, long frameindex) {
		if(listener == null) {
			logger.trace('''ComputerVisionInformation recieved, but the listener is not set''')
		} else {
			logger.trace('''ComputerVisionInformation recieved, «information»''')
		}
		listener?.onComputerVisionDetection(information, timestamp, frameindex)
	}
	

}
