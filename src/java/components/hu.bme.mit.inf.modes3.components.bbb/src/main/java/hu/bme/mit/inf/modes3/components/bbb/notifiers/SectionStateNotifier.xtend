package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Implements a runnable which frequently polls the sections status 
 * (ENABLED or DISABLED) and transfers this to the network so that 
 * everyone who is subscribed can receive it.
 * 
 * @author benedekh
 */
class SectionStateNotifier implements Runnable {

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val SLEEP_MS_BETWEEN_POLLINGS = 50

	// the actuator that can access the referred section
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ExpanderSectionController sectionController

	// send section state on the network
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ITrackElementStateSender trackElementStateSender

	new(ITrackElementStateSender _trackElementStateSender, ExpanderSectionController _sectionController) {
		trackElementStateSender = _trackElementStateSender
		sectionController = _sectionController
	}

	override run() {
		while (!Thread.interrupted) {
			for (sectionStr : sectionController.managedSections) {
				val sectionId = HexConversionUtil.fromString(sectionStr)
				val sectionStatus = sectionController.getSectionStatus(sectionId)
				trackElementStateSender.sendSegmentState(sectionId, sectionStatus)
			}
			Thread.sleep(SLEEP_MS_BETWEEN_POLLINGS)
		}
	}

}
