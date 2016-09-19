package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory

abstract class AbstractRailRoadCommunicationComponent extends AbstractCommunicationComponent {
	
	@Accessors(PROTECTED_GETTER) val TrackCommunicationServiceLocator locator
	
	new(CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)
		locator = new TrackCommunicationServiceLocator(stack)
	}
}