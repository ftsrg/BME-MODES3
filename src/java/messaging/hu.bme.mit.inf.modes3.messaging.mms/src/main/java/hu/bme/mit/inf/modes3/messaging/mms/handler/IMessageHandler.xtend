package hu.bme.mit.inf.modes3.messaging.mms.handler

interface IMessageHandler<T> {
	def void handleMessage(T message);
}
