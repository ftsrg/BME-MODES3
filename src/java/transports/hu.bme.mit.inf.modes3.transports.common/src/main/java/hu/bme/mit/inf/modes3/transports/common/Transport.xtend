package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration

/**
 * The base class for each transportation system
 * 
 * @author hegyibalint
 */
abstract class Transport {
	
	/**
	* Configuration storing the required information to
	* establish connection to all endpoints
	*/ 
	protected val TransportConfiguration config;
	
	
	new(TransportConfiguration config) {
		this.config = config
	}
	
	/**
	 * Connect to all endpoints.
	 */
	def void connect();
	
	/**
	 * Receive a message.
	 */
	def byte[] receiveMessage();
	
	/**
	 * Send a message to all endpoints.
	 */
	def void sendMessage(byte[] message);
	
	/**
	 * Close the transport system.
	 */
	def void close();
}