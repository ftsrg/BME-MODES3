package hu.bme.mit.inf.modes3.transports.config.loaders

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoint
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints

class ArgumentBasedTransportConfigurationLoader {
	
	static def TransportConfiguration loadConfiguration(ArgumentRegistry registry) {
		val config = registry.getParameterStringValue('config')
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val pubPort = registry.getParameterIntegerValue('pubPort')
		val repPort = registry.getParameterIntegerValue('repPort')
		
		val TransportEndpoint endpoint = new TransportEndpoint(address, id, pubPort, repPort)
		val TransportEndpoints endpoints = TransportEndpoints.loadConfig(config)
		return new TransportConfiguration(endpoint,endpoints)
	}
	
}
