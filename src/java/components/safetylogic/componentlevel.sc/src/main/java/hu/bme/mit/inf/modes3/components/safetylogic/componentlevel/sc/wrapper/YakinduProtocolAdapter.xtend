package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface
import hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces.IYakinduMessageSender
import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection

/**
 * An adapter to forward Yakindu messages between two statecharts that are logically connected, but physically not.
 * 
 * @author benedekh
 */
class YakinduProtocolAdapter implements ProtocolInterface.Listener.Required {

	val int neighbourSegmentID
	val ConnectionDirection neighbourSegmentConnectsFrom
	val IYakinduMessageSender messageSender
	
	/**
	 * @param neighbourSegmentID the ID of the neighboring segment
	 * @param neighbourConnectsFrom the direction from which the neighboring segment is connected
	 * @param messageSender the Yakindu message sender
	 */
	new(int neighbourSegmentID, ConnectionDirection neighbourConnectsFrom, IYakinduMessageSender messageSender) {
		this.neighbourSegmentID = neighbourSegmentID
		this.neighbourSegmentConnectsFrom = neighbourConnectsFrom
		this.messageSender = messageSender
	}

	override raiseCanGo() {
		messageSender.canGoTo(neighbourSegmentID, neighbourSegmentConnectsFrom)
	}

	override raiseCannotGo() {
		messageSender.cannotGoTo(neighbourSegmentID, neighbourSegmentConnectsFrom)
	}

	override raiseRelease() {
		messageSender.releaseTo(neighbourSegmentID, neighbourSegmentConnectsFrom)
	}

	override raiseReserve() {
		messageSender.reserveTo(neighbourSegmentID, neighbourSegmentConnectsFrom)
	}

}
