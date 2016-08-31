package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.ITransport
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import org.eclipse.xtend.lib.annotations.Accessors

abstract class AbstractComponent {
	
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) MessagingService mms = new MessagingService
	
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) ITransport transport = new ZMQTransport
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) IMessageDispatcher dispatcher = new ProtobufMessageDispatcher
	
	def void init(){
		onInit();
		start();
	}
	
	def void onInit();
	
	def void start() {
		mms.start(transport, dispatcher)
	}
	
}