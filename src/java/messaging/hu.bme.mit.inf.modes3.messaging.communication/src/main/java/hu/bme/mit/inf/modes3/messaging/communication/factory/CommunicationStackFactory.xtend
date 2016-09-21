package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.LocalTransport
import hu.bme.mit.inf.modes3.transports.config.loaders.ArgumentBasedTransportConfigurationLoader
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import org.slf4j.Logger
import org.slf4j.helpers.NOPLoggerFactory

class CommunicationStackFactory {

	def static createLocalStack(Logger logger) {
		return new CommunicationStack(
			new MessagingService(logger), 
			new LocalTransport, 
			new ProtobufMessageDispatcher
		)
	}
	
	def static createLocalStack(){
		return new CommunicationStack(
			new MessagingService((new NOPLoggerFactory).getLogger('')),
			new LocalTransport,
			new ProtobufMessageDispatcher
		)
	}

	def static createProtobufStack(ArgumentRegistry argumentRegistry, Logger logger) {
		return new CommunicationStack(
			new MessagingService(logger), 
			new ZMQTransport(ArgumentBasedTransportConfigurationLoader.loadConfiguration(argumentRegistry)), 
			new ProtobufMessageDispatcher
		)
	}

}
