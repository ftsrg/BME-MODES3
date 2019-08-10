package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration

/**
 * A transport layer that can transfer messages over the network.
 * The layer is independent from the message format it transfers.
 * 
 * @author baloghlaszlo, benedekh
 */
abstract class Transport {
	protected var TransportConfiguration config;
	
	/**
	 * @param config the configuration parameter of the transport layer
	 */
	new(TransportConfiguration config){
		this.config = config
	}
	
	/**
	 * Connect to the other endpoint.
	 */
	def void connect();
	
	/**
	 * @return the message received through the transport layer
	 */
	def byte[] receiveMessage();
	
	/**
	 * Send a message on the transport layer.
	 * 
	 * @param message to be sent on the transport layer
	 */
	def void sendMessage(byte[] message);
	
	/**
	 * Closes the connection.
	 */
	def void close();
	
	/**
	 * @return the configuration parameter of the transport layer
	 */
	override toString(){
		'''«config»'''
	}
}