package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.LocalTransport
import hu.bme.mit.inf.modes3.transports.config.loaders.ArgumentBasedTransportConfigurationLoader
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport
import hu.bme.mit.inf.modes3.transports.mqtt.conf.MQTTTransportConfigurationFactory
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import org.slf4j.ILoggerFactory
import org.slf4j.helpers.NOPLoggerFactory

class CommunicationStackFactory {

	def static createLocalStack(ILoggerFactory factory) {
		return new CommunicationStack(
			new MessagingService(factory),
			new LocalTransport,
			new ProtobufMessageDispatcher(factory)
		)
	}

	def static createLocalStack() {
		return new CommunicationStack(
			new MessagingService(new NOPLoggerFactory),
			new LocalTransport,
			new ProtobufMessageDispatcher(new NOPLoggerFactory)
		)
	}

	def static createLocalMQTTStack() {
		return new CommunicationStack(
			new MessagingService(new NOPLoggerFactory),
			new MQTTTransport(MQTTTransportConfigurationFactory::createLocalTransportConfig, new NOPLoggerFactory),
			new ProtobufMessageDispatcher(new NOPLoggerFactory)
		)
	}

	def static createMQTTStack(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		return new CommunicationStack(
			new MessagingService(factory),
			new MQTTTransport(ArgumentBasedTransportConfigurationLoader.loadMQTTConfiguration(argumentRegistry), factory),
			new ProtobufMessageDispatcher(factory)
		)
	}

	def static createProtobufStack(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		return new CommunicationStack(
			new MessagingService(factory),
			new ZMQTransport(ArgumentBasedTransportConfigurationLoader.loadZeroMQConfiguration(argumentRegistry)),
			new ProtobufMessageDispatcher(factory)
		)
	}

}
