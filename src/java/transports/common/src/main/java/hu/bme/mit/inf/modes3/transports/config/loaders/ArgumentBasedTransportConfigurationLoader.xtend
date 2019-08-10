package hu.bme.mit.inf.modes3.transports.config.loaders

import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry

/**
 * Loads the configuration parameters of the transport layer from the argument registry.
 * 
 * @author benedekh
 */
class ArgumentBasedTransportConfigurationLoader {
	
	/**
	 * @param registry to read the configuration parameters from
	 * @return the configuration parameters of the transport layer
	 */
	static def TransportConfiguration loadTransportConfiguration(ArgumentRegistry registry) {
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val port = registry.getParameterIntegerValue('port')

		return new TransportConfiguration(id, address, port)
	}

	/**
	 * @param registry to read the configuration parameters from
	 * @return the configuration parameters of the topic-based transport layer
	 */
	static def TopicBasedTransportConfiguration loadTopicBasedConfiguration(ArgumentRegistry registry) {
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val port = registry.getParameterIntegerValue('port')
		val topic = registry.getParameterStringValue('topic')

		return new TopicBasedTransportConfiguration(id, address, port, topic)
	}

}
