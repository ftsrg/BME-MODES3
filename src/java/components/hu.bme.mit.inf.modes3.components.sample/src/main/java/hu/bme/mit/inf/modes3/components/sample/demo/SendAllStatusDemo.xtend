package hu.bme.mit.inf.modes3.components.sample.demo

import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.slf4j.ILoggerFactory
import hu.bme.mit.inf.modes3.messaging.communication.update.IAllStatusUpdateListener

class SendAllStatusDemo extends AbstractCommunicationComponent implements IAllStatusUpdateListener {

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

	override onAllStatusUpdate() {
		logger.info('''All status update command is received by «this.class.name»''')
	}

}
