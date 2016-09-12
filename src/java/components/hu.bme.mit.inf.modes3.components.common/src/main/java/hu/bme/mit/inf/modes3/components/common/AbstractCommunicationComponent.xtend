package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class AbstractCommunicationComponent {

	@Accessors(#[PRIVATE_GETTER, PRIVATE_SETTER]) static val Logger logger = LoggerFactory.getLogger(
		AbstractCommunicationComponent)

	protected val CommunicationStack communication

	new(CommunicationStack stack) {
		communication = stack
	}

}
