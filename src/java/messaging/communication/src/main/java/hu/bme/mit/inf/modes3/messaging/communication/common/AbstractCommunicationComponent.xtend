package hu.bme.mit.inf.modes3.messaging.communication.common

import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

abstract class AbstractCommunicationComponent implements Runnable {

	protected val Logger logger

	protected val TrackCommunicationServiceLocator locator

	new(MessagingService messagingService, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.locator = new TrackCommunicationServiceLocator(messagingService, factory)
	}

	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.locator = locator
	}

}
