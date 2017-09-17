package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport
import org.eclipse.xtend.lib.annotations.Data

@Data
class CommunicationStack {
	val MessagingService mms
	val Transport transport
	val IMessageDispatcher dispatcher

	def start() {
		mms.start(transport, dispatcher)
	}
	
	def stop() {
		mms.stop
		transport.close
	}
}
