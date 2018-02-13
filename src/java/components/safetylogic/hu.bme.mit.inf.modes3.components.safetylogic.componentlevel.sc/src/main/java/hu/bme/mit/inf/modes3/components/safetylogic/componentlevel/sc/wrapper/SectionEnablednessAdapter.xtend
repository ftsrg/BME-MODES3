package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import java.util.Collections
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface.Listener.Required

class SectionEnablednessAdapter implements SectionControlInterface.Required {

	val int sectionId
	val ITrackElementCommander commander

	new(int sectionId, ITrackElementCommander commander) {
		this.sectionId = sectionId
		this.commander = commander
	}

	override getRegisteredListeners() {
		Collections.emptyList
	}

	override isRaisedRestartProtocol() {
		false
	}

	override registerListener(Required listener) {
	}

	override raiseDisableSection() {
		commander.sendSegmentCommand(sectionId, SegmentState.DISABLED)
	}

	override raiseEnableSection() {
		commander.sendSegmentCommand(sectionId, SegmentState.ENABLED)
	}

}
