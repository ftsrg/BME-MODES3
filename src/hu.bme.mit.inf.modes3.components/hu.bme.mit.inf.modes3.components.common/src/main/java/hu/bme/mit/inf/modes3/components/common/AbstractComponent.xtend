package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.ITransport
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import org.eclipse.xtend.lib.annotations.Accessors

abstract class AbstractComponent {
	
	@Accessors(PROTECTED_GETTER, PACKAGE_SETTER) MessagingService mms
	
	@Accessors(PROTECTED_GETTER, PACKAGE_SETTER) ITransport transport
	@Accessors(PROTECTED_GETTER, PACKAGE_SETTER) IMessageDispatcher dispatcher
	
	def void init() {	
		onInit();
		start();
		
		mms ?: new MessagingService
		transport ?: new ZMQTransport  
	}
	
	def void onInit();
	
	def void start() {
		mms.start(transport, dispatcher)
	}
	
}