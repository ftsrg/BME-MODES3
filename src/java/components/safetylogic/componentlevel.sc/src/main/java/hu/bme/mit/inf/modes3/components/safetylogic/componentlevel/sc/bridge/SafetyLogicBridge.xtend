package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.bridge

import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.ISafetyLogic
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.IYakinduProtocolDispatcher
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.PortWithDirection
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.yakindu.YakinduMessageSender
import hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces.IYakinduMessageSender
import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory

class SafetyLogicBridge extends AbstractCommunicationComponent implements ISafetyLogicBridge {

	val ISafetyLogic safetyLogic
	@Accessors(PUBLIC_GETTER) val IYakinduProtocolDispatcher yakinduProtocolDispatcher
	val IYakinduMessageSender yakinduMessageSender

	new(ISafetyLogic safetyLogic, MessagingService railwayTrackStack, MessagingService yakinduStack, IYakinduProtocolDispatcher protocolDispatcher, ILoggerFactory factory) {
		super(railwayTrackStack, factory)
		this.yakinduProtocolDispatcher = protocolDispatcher
		this.yakinduMessageSender = new YakinduMessageSender(yakinduStack, factory)
		this.safetyLogic = safetyLogic
		this.safetyLogic.safetyLogicBridge = this
		yakinduStack.start
	}
	
	override run() {
		safetyLogic.run
	}

	override getTrackElementCommander() {
		locator.trackElementCommander
	}

	override getTrackElementStateRegistry() {
		locator.trackElementStateRegistry
	}

	override canGoTo(int targetID, ConnectionDirection direction) {
		yakinduMessageSender.canGoTo(targetID, direction)
	}

	override cannotGoTo(int targetID, ConnectionDirection direction) {
		yakinduMessageSender.cannotGoTo(targetID, direction)
	}

	override releaseTo(int targetID, ConnectionDirection direction) {
		yakinduMessageSender.releaseTo(targetID, direction)
	}

	override reserveTo(int targetID, ConnectionDirection direction) {
		yakinduMessageSender.reserveTo(targetID, direction)
	}

	override registerSegment(int segmentID, PortWithDirection portToBeNotified) {
		yakinduProtocolDispatcher.registerSegment(segmentID, portToBeNotified)
	}

}
