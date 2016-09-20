package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.LocalTransport
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import org.eclipse.xtend.lib.annotations.Accessors
import hu.bme.mit.inf.modes3.transports.config.loaders.ArgumentBasedTransportConfigurationLoader

class CommunicationStackFactory {

	def static createLocalStack() {
		return new CommunicationStack(
			new MessagingService, 
			new LocalTransport, 
			new ProtobufMessageDispatcher
		)
	}

	def static createZeroMQProtobufStack(TransportConfiguration config) {
		return new CommunicationStack(
			new MessagingService, 
			new ZMQTransport(config), 
			new ProtobufMessageDispatcher
		)
	}

	def static createZeroMQProtobufStack(ArgumentRegistry argumentRegistry) {
		return new CommunicationStack(
			new MessagingService, 
			new ZMQTransport(ArgumentBasedTransportConfigurationLoader.loadConfiguration(argumentRegistry)), 
			new ProtobufMessageDispatcher
		)
	}

}
