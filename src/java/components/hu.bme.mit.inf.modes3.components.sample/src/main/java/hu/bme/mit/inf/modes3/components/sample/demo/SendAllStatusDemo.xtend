package hu.bme.mit.inf.modes3.components.sample.demo

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusListener
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.slf4j.ILoggerFactory

class SendAllStatusDemo extends AbstractCommunicationComponent implements ISendAllStatusListener {

	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		super(locator, factory)
		locator.sendAllStatusCallback.statusUpdateListener = this
	}

	override run() {
		initiateSendAllStatus
	}

	private def initiateSendAllStatus() {
		locator.trackElementCommander.sendAllStatusCommand
	}

	override onSendAllStatus() {
		logger.info('''All status update command is received by «this.class.name»''')
	}

}
