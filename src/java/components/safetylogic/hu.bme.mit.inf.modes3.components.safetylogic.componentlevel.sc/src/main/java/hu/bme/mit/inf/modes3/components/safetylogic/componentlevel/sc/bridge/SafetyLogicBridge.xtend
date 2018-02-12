package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.bridge

import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.ISafetyLogic
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory

class SafetyLogicBridge extends AbstractCommunicationComponent implements ISafetyLogicBridge {

	val ISafetyLogic safetyLogic

	new(ISafetyLogic safetyLogic, MessagingService messagingService, ILoggerFactory factory) {
		super(messagingService, factory)
		this.safetyLogic = safetyLogic
		this.safetyLogic.safetyLogicBridge = this
	}
	
	override run() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}
