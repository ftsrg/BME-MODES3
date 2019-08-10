package hu.bme.mit.inf.modes3.test.demo

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusListener
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.slf4j.ILoggerFactory

/**
 * A show-case (demo), how you can instruct each element of the model railway track to send their status information.
 * 
 * @author benedekh
 */
class SendAllStatusDemo extends AbstractCommunicationComponent implements ISendAllStatusListener {

	/**
	 * @param locator the high-level communication service of the railway track
	 * @param factory the logger factory
	 */
	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		super(locator, factory)
		locator.sendAllStatusCallback.sendAllStatusListener = this
	}

	/**
	 * Runs the demo of how to instruct each element of the model railway track to send their status information.
	 */
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
