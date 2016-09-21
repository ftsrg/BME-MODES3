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

	protected new(MessagingService mms, Transport transport, IMessageDispatcher dispatcher) {
		this.mms = mms
		this.transport = transport
		this.dispatcher = dispatcher
	}

	def start() {
		mms.start(transport, dispatcher)
	}
}
