package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.MessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import org.eclipse.xtend.lib.annotations.Accessors

abstract class AbstractComponent {
	
	@Accessors MessagingService mms = new MessagingService
	@Accessors Transport transport = new ZMQTransport
	@Accessors MessageDispatcher dispatcher = new ProtobufMessageDispatcher
	
	def void init();
	
	def void start() {
		mms.start(transport, dispatcher)
	}
	
}