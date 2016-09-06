package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * This class transmits the received section commands to the actual
 * actuators, so the respective sections can be managed (enabled / disabled) or
 * theirs statuses can be queried.
 * 
 * @author benedekh, hegyibalint
 */
public class SectionMessageHandler implements ISegmentCommandListener {

	// the actuator that can access the referred section
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ExpanderSectionController sectionController

	// to receive commands from the network
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ITrackElementCommandCallback commandCallback

	new(ITrackElementCommandCallback _commandCallback, ExpanderSectionController _sectionController) {
		sectionController = _sectionController
		commandCallback = _commandCallback

		commandCallback.segmentCommandListener = this
	}

	/**
	 * If the embedded controller manages the referred section, then this section will be enabled.
	 * 
	 * @param sectionId the section's ID that should be enabled
	 */
	private def handleLineEnable(int sectionId) {
		if (sectionController.controllerManagesSection(sectionId)) {
			sectionController.enableSection(sectionId)
		}
	}

	/**
	 * If the embedded controller manages the referred section, then this section will be disabled.
	 * 
	 * @param sectionId the section's ID that should be disabled
	 */
	private def handleLineDisable(int sectionId) {
		if (sectionController.controllerManagesSection(sectionId)) {
			sectionController.disableSection(sectionId)
		}
	}

	override onSegmentCommand(int id, SegmentState state) {
		switch (state) {
			case SegmentState.ENABLED: handleLineEnable(id)
			case SegmentState.DISABLED: handleLineDisable(id)
			default: return
		}
	}

}
