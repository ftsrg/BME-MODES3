package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TransportConfigurations

abstract class Transport {
	 
	def Transport(TransportConfigurations configuration) {
		
	}
	
	def void connect();
	def byte[] receiveMessage();
	def void sendMessage(byte[] message);
}