package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.bbb.utils.SectionStatus
import hu.bme.mit.inf.modes3.components.controller.command.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.components.controller.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue

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
	var TrackElementStateSender trackElementStateSender

	// to receive commands from the network
	var TrackElementCommandCallback commandCallback

	new(TrackElementStateSender _trackElementStateSender, TrackElementCommandCallback _commandCallback) {
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
			// TODO logging
			val sectionStatus = sectionController.getSectionStatus(sectionId)
			var state = if (sectionStatus == SectionStatus.ENABLED)
					SegmentStateValue.ENABLED
				else
					SegmentStateValue.DISABLED
			trackElementStateSender.sendSegmentState(sectionId, state)
		}
	}

	/**
	 * If the embedded controller manages the referred section, then this section will be enabled.
	 * 
	 * @param sectionId the section's ID that should be enabled
	 */
	private def handleLineEnable(int sectionId) {
		if (sectionController.controllerManagesSection(sectionId)) {
			// TODO logging
			sectionController.enableSection(sectionId);
			trackElementStateSender.sendSegmentState(sectionId, SegmentStateValue.ENABLED)
		}
	}

	/**
	 * If the embedded controller manages the referred section, then this section will be disabled.
	 * 
	 * @param sectionId the section's ID that should be disabled
	 */
	private def handleLineDisable(int sectionId) {
		if (sectionController.controllerManagesSection(sectionId)) {
			// TODO logging
			sectionController.disableSection(sectionId);
			trackElementStateSender.sendSegmentState(sectionId, SegmentStateValue.DISABLED)
		}
	}

	override onSegmentCommand(int id, SegmentStateValue state) {
		switch (state) {
			case SegmentStateValue.ENABLED: handleLineEnable(id)
			case SegmentStateValue.DISABLED: handleLineDisable(id)
			default: return
		}
	}

}
