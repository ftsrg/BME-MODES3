package hu.bme.mit.inf.modes3.test.demo.app

import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import java.util.Set
import org.slf4j.ILoggerFactory

/**
 * A wrapper class for each show-case (demo subapplication).
 * 
 * @author benedekh
 */
class TestDemo extends AbstractCommunicationComponent {

	val ILoggerFactory factory
	val Set<AbstractCommunicationComponent> demos

	/**
	 * @param messagingService the messaging service to the railway track
	 * @param factory the logger factory
	 */
	new(MessagingService messagingService, ILoggerFactory factory) {
		super(messagingService, factory)
		this.factory = factory
		this.demos = #{new hu.bme.mit.inf.modes3.test.demo.SegmentsDemo(locator, factory), new hu.bme.mit.inf.modes3.test.demo.SectionsDemo(locator, factory),
			new hu.bme.mit.inf.modes3.test.demo.TurnoutsDemo(locator, factory), new hu.bme.mit.inf.modes3.test.demo.SendAllStatusDemo(locator, factory),
			new hu.bme.mit.inf.modes3.test.demo.TrainsDemo(locator, factory)}
		}

		/**
		 * The 'main' method of the sample component
		 */
		override run() {
			demos.forEach[it.run]
		}

	}
	