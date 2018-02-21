package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher

import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import java.util.Set
import org.slf4j.ILoggerFactory

class JsonDispatcherFactory {

	def static createMQTTStackWithJSON(ArgumentRegistry argumentRegistry, ILoggerFactory factory, Set<String> topics) {
		return MessagingServiceFactory::createStackForTopics(argumentRegistry, factory, topics, new JsonMessageDispatcher(factory))
	}
}
