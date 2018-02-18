package hu.bme.mit.inf.modes3.messaging.mms.dispatcher

interface IMessageDispatcher {
	def void dispatchMessage(byte[] rawMessage);
	def byte[] convertMessageToRaw(Object message) throws IllegalArgumentException;
}