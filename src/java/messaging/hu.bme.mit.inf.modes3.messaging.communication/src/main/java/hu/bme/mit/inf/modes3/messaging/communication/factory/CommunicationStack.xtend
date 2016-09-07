package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport
import org.eclipse.xtend.lib.annotations.Data

@Data
class CommunicationStack {
	val MessagingService mms =  new MessagingService
	val Transport transport = null  // TODO = new ZMQTransport 
	val IMessageDispatcher dispatcher = new ProtobufMessageDispatcher
	
	def start(){
		mms.start(transport, dispatcher)
	}
}
