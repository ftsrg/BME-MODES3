package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.ITransport
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import org.eclipse.xtend.lib.annotations.Data

@Data
class CommunicationStack {
	val MessagingService mms =  new MessagingService
	val ITransport transport = new ITransport(){
		
		override connect() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}
		
		override receiveMessage() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}
		
		override sendMessage(byte[] message) {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}
		
	} // TODO = new ZMQTransport 
	val ProtobufMessageDispatcher dispatcher = new ProtobufMessageDispatcher
}
