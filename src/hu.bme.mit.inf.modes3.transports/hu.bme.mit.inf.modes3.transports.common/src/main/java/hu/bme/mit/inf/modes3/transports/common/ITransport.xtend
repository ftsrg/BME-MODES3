package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration

interface ITransport {
	def void connect();
	def byte[] receiveMessage();
	def void sendMessage(byte[] message);
}