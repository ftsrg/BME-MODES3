package hu.bme.mit.inf.modes3.transports.config

class TransportEndpointService {
	String id;
	Integer port;
	
	def equals(TransportEndpointService tes) {
		return 
			this.id == tes.id && 
			this.port == tes.port
	}
	
}