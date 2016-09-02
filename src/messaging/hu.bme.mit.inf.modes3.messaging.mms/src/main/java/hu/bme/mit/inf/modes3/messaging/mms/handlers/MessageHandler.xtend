package hu.bme.mit.inf.modes3.messaging.mms.handlers

interface MessageHandler<T> {
	def void handleMessage(T message);
}