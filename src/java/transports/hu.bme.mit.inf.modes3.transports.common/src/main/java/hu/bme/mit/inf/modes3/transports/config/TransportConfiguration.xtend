package hu.bme.mit.inf.modes3.transports.config

import org.eclipse.xtend.lib.annotations.Data

@Data
class TransportConfiguration {
	TransportEndpoint localEndpoint;
	TransportEndpoints allEndpoints;
	
	static def TransportConfiguration createDefaultTransportConfiguration(){
		throw new UnsupportedOperationException //TODO implement this somehow
	}
}

