package hu.bme.mit.inf.modes3.components.barrier.comm.json

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessageToTopicMapper
import hu.bme.mit.inf.modes3.messaging.messages.status.BarrierStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.TopicBasedMessagingService
import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport
import org.slf4j.ILoggerFactory

class JsonDispatcherFactory {

	def static createMQTTStackWithJSON(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		return new TopicBasedMessagingService(
			new MQTTTransport(loadMQTTConfiguration(argumentRegistry), factory),
			new JsonDispatcher(factory),
			factory
		)
	}

	private def static loadMQTTConfiguration(ArgumentRegistry registry) {
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val port = registry.getParameterIntegerValue('port')
		val barriertopic = InternalMessageToTopicMapper.INSTANCE.getTopic(BarrierStateMessage.simpleName)

		return new TopicBasedTransportConfiguration(id, address, port, barriertopic)
	}
}
