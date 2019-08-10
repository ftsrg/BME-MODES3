package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.mms.TopicBasedMessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.loaders.ArgumentBasedTransportConfigurationLoader
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import java.util.Set
import org.slf4j.ILoggerFactory

/**
 * A factory that creates a communication stack, where the dispatcher interprets the messages.
 * 
 * @author benedekh
 */
class MessagingServiceFactory {

/**
	 * Creates a communication stack, where the transport protocol is MQTT and the message format is protobuf.
	 * 
	 * @param argumentRegistry the initialization parameters of the network stack (e.g. MQTT server IP and port, topic names to register on)
	 * @param factory the logger factory
	 * 
	 * @return the communication stack
	 */
	def static createMQTTStack(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		return new TopicBasedMessagingService(new MQTTTransport(ArgumentBasedTransportConfigurationLoader.loadTopicBasedConfiguration(argumentRegistry), factory), new ProtobufMessageDispatcher(factory), factory)
	}

	/**
	 * Creates a topic based communication stack that registered for the defined topics and which interprets the messages in protobuf.
	 * 
	 * @param argumentRegistry the initialization parameters of the network stack (e.g. MQTT server IP and port, topic names to register on)
	 * @param factory the logger factory
	 * @param topics the topics to register for
	 * 
	 * @return the communication service
	 */
	def static createStackForTopics(ArgumentRegistry argumentRegistry, ILoggerFactory factory, Set<String> topics) {
		createStackForTopics(argumentRegistry, factory, topics, new ProtobufMessageDispatcher(factory))
	}

		/**
	 * Creates a topic based communication stack that registered for the defined topics.
	 * 
	 * @param argumentRegistry the initialization parameters of the network stack (e.g. MQTT server IP and port, topic names to register on)
	 * @param factory the logger factory
	 * @param topics the topics to register for
	 * @param messageDispatcher the dispatcher of the messages. The message format depends on the dispatcher.
	 * 
	 * @return the communication service
	 */
	def static createStackForTopics(ArgumentRegistry argumentRegistry, ILoggerFactory factory, Set<String> topics, AbstractMessageDispatcher messageDispatcher) {
		val transportConfig = ArgumentBasedTransportConfigurationLoader::loadTransportConfiguration(argumentRegistry)
		val initialConfig = new TopicBasedTransportConfiguration(transportConfig.id, transportConfig.addr, transportConfig.port, topics.head)
		// create the messaging service with the first configuration
		val mms = new TopicBasedMessagingService(new MQTTTransport(initialConfig, factory), messageDispatcher, factory)
		// create the other transport layers with the remaining configurations
		topics.filter[it != topics.head].forEach [
			val config = new TopicBasedTransportConfiguration(transportConfig.id, transportConfig.addr, transportConfig.port, it);
			val transport = new MQTTTransport(config, factory);
			mms.addTransport(transport)
		]
		return mms
	}

}
