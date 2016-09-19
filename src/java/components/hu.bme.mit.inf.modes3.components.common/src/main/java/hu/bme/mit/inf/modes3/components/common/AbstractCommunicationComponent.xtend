package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

abstract class AbstractCommunicationComponent implements Runnable {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	protected val CommunicationStack communication

	new(CommunicationStack stack, ILoggerFactory factory) {
		communication = stack
		this.logger = factory.getLogger(this.class.name)
	}

}
