package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface.Listener.Provided
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher.YakinduMessageSender
import hu.bme.mit.inf.modes3.utils.conf.layout.whole.ConnectionDirection
import java.util.Collections

class YakinduProtocolAdapter implements ProtocolInterface.Provided {

	val int neighbourSegmentID
	val ConnectionDirection neighbourSegmentConnectsFrom
	val YakinduMessageSender messageSender

	new(int neighbourID, ConnectionDirection neighbourConnectsFrom, YakinduMessageSender messageSender) {
		this.neighbourSegmentID = neighbourID
		this.neighbourSegmentConnectsFrom = neighbourConnectsFrom
		this.messageSender = messageSender
	}

	override getRegisteredListeners() {
		Collections.emptyList
	}

	override registerListener(Provided listener) {
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
