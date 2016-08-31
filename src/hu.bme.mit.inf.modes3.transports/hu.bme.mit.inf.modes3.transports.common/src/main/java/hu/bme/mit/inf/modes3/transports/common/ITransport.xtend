package hu.bme.mit.inf.modes3.transports.common

interface ITransport {
	def void connect();
	def byte[] receiveMessage();
	def void sendMessage(byte[] message);
}