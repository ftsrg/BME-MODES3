package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher

import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.messages.YakinduProtocolMessage
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessageToTopicMapper
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import org.slf4j.ILoggerFactory

class JsonDispatcherFactory {

	def static createMQTTStackWithJSON(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		val topics = InternalMessageToTopicMapper.INSTANCE.getTopics(YakinduProtocolMessage.simpleName)
		val dispatcher = new JsonMessageDispatcher(factory)
		val communicationStack = MessagingServiceFactory::createStackForTopics(argumentRegistry, factory, topics, dispatcher)

		val logger = factory.getLogger(JsonDispatcherFactory.name)
		logger.debug('''Subscribed for Yakindu topics: «topics»''')

		return communicationStack
	}
}
