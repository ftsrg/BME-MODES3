package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState

/**
 * An adapter to send segment commands from the statechart to the communication network.
 * 
 * @author benedekh
 */
class SectionEnablednessAdapter implements SectionControlInterface.Listener.Provided {

	val int sectionId
	val ITrackElementCommander commander
	
	/**
	 * @param sectionid the ID of the section
	 * @param commander the track element commander
	 */
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
