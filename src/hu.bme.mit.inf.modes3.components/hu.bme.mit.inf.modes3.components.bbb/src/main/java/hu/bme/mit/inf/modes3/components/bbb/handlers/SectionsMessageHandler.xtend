package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITrackElementStateSender

/**
 * The message handler of section related commands received on the subscribed
 * topic. This class transmits the received section commands to the actual
 * actuators, so the respective sections can be managed (enabled / disabled) or
 * theirs statuses can be queried.
 * 
 * @author benedekh, hegyibalint
 */
public class SectionsMessageHandler implements ISegmentCommandListener {

	// the actuator that can access the referred section
	val sectionController = new ExpanderSectionController

	// segment state sender to the network
	var ITrackElementStateSender trackElementStateSender

	// to receive commands from the network
	var ITrackElementCommandCallback commandCallback

	new(ITrackElementStateSender _trackElementStateSender, ITrackElementCommandCallback _commandCallback) {
		trackElementStateSender = _trackElementStateSender
		commandCallback = _commandCallback

		commandCallback.segmentCommandListener = this
	}

	/**
	 * If the embedded controller manages the referred section, then its status will be queried and sent back.
	 * 
	 * @param sectionId the section's ID whose status should be queried
	 */
	private def handleGetSectionStatus(int sectionId) {
		if (sectionController.controllerManagesSection(sectionId)) {
			val sectionStatus = sectionController.getSectionStatus(sectionId)
			trackElementStateSender.sendSegmentState(sectionId, sectionStatus)
		}
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
