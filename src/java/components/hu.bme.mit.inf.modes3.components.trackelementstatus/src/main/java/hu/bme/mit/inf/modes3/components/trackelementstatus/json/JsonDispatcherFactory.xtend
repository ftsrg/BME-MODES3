package hu.bme.mit.inf.modes3.components.trackelementstatus.json

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport
import org.slf4j.ILoggerFactory

class JsonDispatcherFactory {

	def static createMQTTStackWithJSON(ArgumentRegistry argumentRegistry, ILoggerFactory factory, String topicField) {
		return new CommunicationStack(
			new MessagingService(factory),
			new MQTTTransport(loadMQTTConfiguration(argumentRegistry, topicField), factory),
			new JsonDispatcher(factory)
		)
	}

	private def static loadMQTTConfiguration(ArgumentRegistry registry, String topicField) {
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val port = registry.getParameterIntegerValue('port')
		val topic = registry.getParameterStringValue(topicField)

		return new TransportConfiguration(id, address, port, topic)
	}
}
