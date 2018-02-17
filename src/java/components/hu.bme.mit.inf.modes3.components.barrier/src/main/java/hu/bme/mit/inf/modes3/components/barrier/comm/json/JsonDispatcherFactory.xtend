package hu.bme.mit.inf.modes3.components.barrier.comm.json

import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessageToTopicMapper
import hu.bme.mit.inf.modes3.messaging.messages.status.BarrierStateMessage
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import org.slf4j.ILoggerFactory

class JsonDispatcherFactory {

	def static createMQTTStackWithJSON(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		val topics = InternalMessageToTopicMapper.INSTANCE.getTopics(BarrierStateMessage.simpleName)
		val dispatcher = new JsonDispatcher(factory)
		return MessagingServiceFactory::createStackForTopics(argumentRegistry, factory, topics, dispatcher)
	}
}
