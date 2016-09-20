package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * This class transmits the received section commands to the actual
 * actuators, so the respective sections can be managed (enabled / disabled) or
 * theirs statuses can be queried.
 * 
 * @author benedekh, hegyibalint
 */
package class SectionMessageHandler implements ISegmentCommandListener {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	// the actuator that can access the referred section
	protected val ISegmentControllerStrategy sectionController

	new(ITrackElementCommandCallback commandCallback, ISegmentControllerStrategy _sectionController, ILoggerFactory factory) {
		sectionController = _sectionController
		commandCallback.segmentCommandListener = this

		this.logger = factory.getLogger(this.class.name)
	}

	/**
	 * If the embedded controller manages the referred section, then this section will be enabled.
	 * 
	 * @param sectionId the section's ID that should be enabled
	 */
	private def handleLineEnable(int sectionId) {
		if(sectionController.controllerManagesSection(sectionId)) {
			sectionController.enableSection(sectionId)
		}
	}

	/**
	 * If the embedded controller manages the referred section, then this section will be disabled.
	 * 
	 * @param sectionId the section's ID that should be disabled
	 */
	private def handleLineDisable(int sectionId) {
		if(sectionController.controllerManagesSection(sectionId)) {
			sectionController.disableSection(sectionId)
		}
	}

	override onSegmentCommand(int id, SegmentState state) {
		logger.info('''Segment ''' + id + ''' command ''' + state + ''' received.''')
		
		switch (state) {
			case SegmentState.ENABLED: handleLineEnable(id)
			case SegmentState.DISABLED: handleLineDisable(id)
			default: return
		}
	}

}
