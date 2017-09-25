package hu.bme.mit.inf.modes3.components.barrier.json

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport
import org.slf4j.ILoggerFactory

class JsonDispatcherFactory {

	def static createMQTTStackWithJSON(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		return new MessagingService(
			new MQTTTransport(loadMQTTConfiguration(argumentRegistry), factory),
			new JsonDispatcher(factory),
			factory
		)
	}

	private def static loadMQTTConfiguration(ArgumentRegistry registry) {
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val port = registry.getParameterIntegerValue('port')
		val barriertopic = registry.getParameterStringValue('barriertopic')

		return new TopicBasedTransportConfiguration(id, address, port, barriertopic)
	}
}
