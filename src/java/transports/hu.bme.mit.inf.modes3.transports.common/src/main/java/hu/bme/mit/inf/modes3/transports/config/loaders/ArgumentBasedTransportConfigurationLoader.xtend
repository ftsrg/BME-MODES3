package hu.bme.mit.inf.modes3.transports.config.loaders

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoint
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints

class ArgumentBasedTransportConfigurationLoader {
	
	static def TransportConfiguration loadConfiguration(ArgumentRegistry registry) {
		val TransportEndpoint endpoint = new TransportEndpoint(registry.getParameterStringValue('addr'), registry.getParameterStringValue('id'), registry.getParameterIntegerValue('pubPort'), registry.getParameterIntegerValue('repPort'))
		val TransportEndpoints endpoints = TransportEndpoints.loadConfig(registry.getParameterStringValue('config'))
		return new TransportConfiguration(endpoint,endpoints)
	}
	
}
