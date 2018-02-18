package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState

class SectionEnablednessAdapter implements SectionControlInterface.Listener.Provided {

	val int sectionId
	val ITrackElementCommander commander

	new(int sectionId, ITrackElementCommander commander) {
		this.sectionId = sectionId
		this.commander = commander
	}

	override raiseDisableSection() {
		commander.sendSegmentCommand(sectionId, SegmentState.DISABLED)
	}

	override raiseEnableSection() {
		commander.sendSegmentCommand(sectionId, SegmentState.ENABLED)
	}

}
