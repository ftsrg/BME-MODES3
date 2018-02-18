package hu.bme.mit.inf.modes3.transports.config.loaders

import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry

class ArgumentBasedTransportConfigurationLoader {

	static def TransportConfiguration loadTransportConfiguration(ArgumentRegistry registry) {
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val port = registry.getParameterIntegerValue('port')

		return new TransportConfiguration(id, address, port)
	}

	static def TopicBasedTransportConfiguration loadTopicBasedConfiguration(ArgumentRegistry registry) {
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val port = registry.getParameterIntegerValue('port')
		val topic = registry.getParameterStringValue('topic')

		return new TopicBasedTransportConfiguration(id, address, port, topic)
	}

}
