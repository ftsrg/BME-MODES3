package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.components.sample.demo.SectionsDemo
import hu.bme.mit.inf.modes3.components.sample.demo.SegmentsDemo
import hu.bme.mit.inf.modes3.components.sample.demo.SendAllStatusDemo
import hu.bme.mit.inf.modes3.components.sample.demo.TrainsDemo
import hu.bme.mit.inf.modes3.components.sample.demo.TurnoutsDemo
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import java.util.Set
import org.slf4j.ILoggerFactory

class SampleComponent extends AbstractCommunicationComponent {

	val ILoggerFactory factory
	val Set<AbstractCommunicationComponent> demos

	new(MessagingService messagingService, ILoggerFactory factory) {
		super(messagingService, factory)
		this.factory = factory
		this.demos = #{new SegmentsDemo(locator, factory), new SectionsDemo(locator, factory),
			new TurnoutsDemo(locator, factory), new SendAllStatusDemo(locator, factory),
			new TrainsDemo(locator, factory)}
		}

		// The 'main' method of the sample component
		override run() {
			demos.forEach[it.run]
		}

	}
	