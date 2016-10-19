package hu.bme.mit.inf.modes3.messaging.communication.update

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import org.eclipse.xtend.lib.annotations.Accessors

class SendAllStatusCallback {

	val Logger logger;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IAllStatusUpdateListener listener

	new(ProtobufMessageDispatcher dispatcher, ILoggerFactory factory) {
		logger = factory.getLogger(this.class.name)
		dispatcher.sendAllStatusHandler = new AllStatusUpdateClient(this)
	}
	
	
	def onAllStatusUpdate(){
		listener.onAllStatusUpdate
		
	}
}
