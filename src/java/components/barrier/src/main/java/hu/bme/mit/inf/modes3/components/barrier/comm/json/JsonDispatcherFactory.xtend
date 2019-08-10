package hu.bme.mit.inf.modes3.components.barrier.comm.json

import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessageToTopicMapper
import hu.bme.mit.inf.modes3.messaging.messages.status.BarrierStateMessage
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import org.slf4j.ILoggerFactory

/**
 * A factory that creates a communication stack, where the dispatcher interprets the messages in JSON.
 * 
 * @author benedekh
 */
class JsonDispatcherFactory {

	/**
	 * Creates a communication stack, where the transport protocol is MQTT and the message format is JSON.
	 * 
	 * @param argumentRegistry the initialization parameters of the network stack (e.g. MQTT server IP and port, topic names to register on)
	 * @param factory the logger factory
	 * 
	 * @return the communication stack
	 */
	def static createMQTTStackWithJSON(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		val topics = InternalMessageToTopicMapper.INSTANCE.getTopics(BarrierStateMessage.simpleName)
		val dispatcher = new JsonDispatcher(factory)
		return MessagingServiceFactory::createStackForTopics(argumentRegistry, factory, topics, dispatcher)
	}
}
