package hu.bme.mit.inf.modes3.messaging.communication.update

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class SendAllStatusCallback {

	val Logger logger;
	
	var IAllStatusUpdateListener listener

	new(ProtobufMessageDispatcher dispatcher, ILoggerFactory factory) {
		logger = factory.getLogger(this.class.name)
		dispatcher.sendAllStatusHandler = new AllStatusUpdateClient(this)
	}
	
	def setStatusUpdateListener(IAllStatusUpdateListener listener) {
		this.listener = listener;
	}
	
	
	def onAllStatusUpdate(){
		listener.onAllStatusUpdate
		
	}
}
