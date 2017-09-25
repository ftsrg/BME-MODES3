package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessageToTopicMapper
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.loaders.ArgumentBasedTransportConfigurationLoader
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport
import java.util.Set
import org.slf4j.ILoggerFactory

class MessagingServiceFactory {

	def static createMQTTStack(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		return new MessagingService(
			new MQTTTransport(ArgumentBasedTransportConfigurationLoader.loadTopicBasedConfiguration(argumentRegistry),
				factory), new ProtobufMessageDispatcher(factory), factory)
	}

	def static createStackForTopics(ArgumentRegistry argumentRegistry, ILoggerFactory factory, Set<String> topics) {
		val transportConfig = ArgumentBasedTransportConfigurationLoader::loadTransportConfiguration(argumentRegistry)
		val initialConfig = new TopicBasedTransportConfiguration(transportConfig.id, transportConfig.addr,
			transportConfig.port, topics.head)
		val mms = new MessagingService(new MQTTTransport(initialConfig, factory),
			new ProtobufMessageDispatcher(factory), factory)
		topics.filter[it != topics.head].forEach [
			val config = new TopicBasedTransportConfiguration(transportConfig.id, transportConfig.addr,
				transportConfig.port, it);
			val transport = new MQTTTransport(config, factory);
			mms.addTransport(transport)
		]
	}

	def static createStackForEveryTopic(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		val topics = InternalMessageToTopicMapper.INSTANCE.topics
		createStackForTopics(argumentRegistry, factory, topics)
	}

}
