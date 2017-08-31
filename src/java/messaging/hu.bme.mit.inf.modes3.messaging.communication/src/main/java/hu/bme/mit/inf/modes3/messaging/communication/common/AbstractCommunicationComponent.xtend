package hu.bme.mit.inf.modes3.messaging.communication.common

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

abstract class AbstractCommunicationComponent implements Runnable {

	protected val Logger logger

	protected val TrackCommunicationServiceLocator locator

	new(CommunicationStack stack, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.locator = new TrackCommunicationServiceLocator(stack, factory)
	}

}
