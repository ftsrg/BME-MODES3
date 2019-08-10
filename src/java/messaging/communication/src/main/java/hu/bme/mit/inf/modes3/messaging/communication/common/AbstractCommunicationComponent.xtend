package hu.bme.mit.inf.modes3.messaging.communication.common

import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * A common ancestor for those classes that would like to control the whole model railway track by messages.
 * Contains the {@link #locator}, the high-level communication service of the railway track.
 * 
 * @author baloghlaszlo
 */
abstract class AbstractCommunicationComponent implements Runnable {

	protected val Logger logger

	protected val TrackCommunicationServiceLocator locator
	
	/**
	 * @param mms the messaging service to the track
	 * @param factory the logger factory
	 */
	new(MessagingService messagingService, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.locator = new TrackCommunicationServiceLocator(messagingService, factory)
	}
	
	/**
	 * @param locator the high-level communication service of the railway track
	 * @param factory the logger factory
	 */
	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.locator = locator
	}

}
