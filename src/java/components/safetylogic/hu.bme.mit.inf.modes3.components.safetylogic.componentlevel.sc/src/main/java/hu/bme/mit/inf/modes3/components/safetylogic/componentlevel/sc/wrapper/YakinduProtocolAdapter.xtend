package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher.IYakinduMessageSender
import hu.bme.mit.inf.modes3.utils.conf.layout.whole.ConnectionDirection

class YakinduProtocolAdapter implements ProtocolInterface.Listener.Required {

	val int neighbourSegmentID
	val ConnectionDirection neighbourSegmentConnectsFrom
	val IYakinduMessageSender messageSender

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
