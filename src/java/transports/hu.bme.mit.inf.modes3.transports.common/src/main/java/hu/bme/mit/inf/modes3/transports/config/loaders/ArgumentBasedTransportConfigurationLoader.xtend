package hu.bme.mit.inf.modes3.transports.config.loaders

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoint
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints.ActiveConfiguration

class ArgumentBasedTransportConfigurationLoader {
	
	static def TransportConfiguration loadZeroMQConfiguration(ArgumentRegistry registry) {
		val config = registry.getParameterStringValue('config')
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val pubPort = registry.getParameterIntegerValue('pubPort')
		val repPort = registry.getParameterIntegerValue('repPort')
		
		val TransportEndpoint endpoint = new TransportEndpoint(address, id, pubPort, repPort)
		val TransportEndpoints endpoints = TransportEndpoints.loadConfig(config)
		return new TransportConfiguration(endpoint,endpoints)
	}
	
	static def TransportConfiguration loadMQTTConfiguration(ArgumentRegistry registry){
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val pubPort = registry.getParameterIntegerValue('pubPort')
		val config = registry.getParameterStringValue('config');
		
		val endpoint = new TransportEndpoint('',id,pubPort,0)
		var TransportEndpoints endpoints = null
		if(config != null)
			endpoints = new TransportEndpoints(#[new TransportEndpoint(address,'',pubPort,0)], ActiveConfiguration.valueOf(config.toUpperCase))
		else
			endpoints = new TransportEndpoints(#[new TransportEndpoint(address,'',pubPort,0)])
		return new TransportConfiguration(endpoint,endpoints)
	}
	
}
