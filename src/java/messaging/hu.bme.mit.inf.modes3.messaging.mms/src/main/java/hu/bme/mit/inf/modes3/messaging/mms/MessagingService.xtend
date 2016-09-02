package hu.bme.mit.inf.modes3.messaging.mms

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport

class MessagingService {

	Transport transport
	IMessageDispatcher dispatcher

	def start(Transport _transport, IMessageDispatcher _dispatcher) {
		this.transport = _transport
		this.dispatcher = _dispatcher
		
		this.transport.connect()
		while(!Thread.currentThread.isInterrupted) {
			try {
				val rawMessage = transport.receiveMessage
				this.dispatcher.dispatchMessage(rawMessage)
			} catch (Exception e) {
				// This catch is left blank intentionally
			}
			
		}
	}
	
	def sendMessage(Object message) throws IllegalArgumentException {
		transport.sendMessage(dispatcher.convertMessageToRaw(message))
	}
	
}
