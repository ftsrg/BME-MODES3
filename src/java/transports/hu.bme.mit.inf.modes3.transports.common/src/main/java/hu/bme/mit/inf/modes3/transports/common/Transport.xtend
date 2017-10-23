package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration

abstract class Transport {
	protected var TransportConfiguration config;
	
	new(TransportConfiguration config){
		this.config = config
	}
	
	def void connect();
	def byte[] receiveMessage();
	def void sendMessage(byte[] message);
	def void close();
	
	override toString(){
		'''«config»'''
	}
}