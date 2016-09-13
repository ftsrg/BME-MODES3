package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import org.eclipse.xtend.lib.annotations.Accessors
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator

abstract class AbstractRailRoadCommunicationComponent extends AbstractCommunicationComponent {
	
	@Accessors(PROTECTED_GETTER) val TrackCommunicationServiceLocator locator
	
	new(CommunicationStack stack) {
		super(stack)
		locator = new TrackCommunicationServiceLocator(stack)
	}
}