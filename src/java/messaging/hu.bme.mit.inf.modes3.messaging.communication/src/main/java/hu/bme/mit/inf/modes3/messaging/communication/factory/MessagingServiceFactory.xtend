package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.config.loaders.ArgumentBasedTransportConfigurationLoader
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport
import org.slf4j.ILoggerFactory

class MessagingServiceFactory {

	def static createMQTTStack(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		return new MessagingService(
			new MQTTTransport(ArgumentBasedTransportConfigurationLoader.loadTopicBasedConfiguration(argumentRegistry),
				factory), new ProtobufMessageDispatcher(factory), factory)
	}

}
