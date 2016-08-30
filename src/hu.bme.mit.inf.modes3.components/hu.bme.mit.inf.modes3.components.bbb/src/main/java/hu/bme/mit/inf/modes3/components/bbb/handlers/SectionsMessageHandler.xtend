package hu.bme.mit.inf.modes3.components.bbb.handlers;

import hu.bme.mit.inf.modes3.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.bbb.utils.SectionStatus
import java.util.Map.Entry
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * The message handler of section related commands received on the subscribed
 * topic. This class transmits the received section commands to the actual
 * actuators, so the respective sections can be managed (enabled / disabled) or
 * theirs statuses can be queried.
 * 
 * It is a proxy between the MQTT communication and the embedded controller.
 * 
 * @author benedekh, hegyibalint
 */
public class SectionsMessageHandler {

	// the actuator that can access the referred section
	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) final ExpanderSectionController sectionController

	/**
	 * @param sender the transmitter of messages through MQTT
	 */
	new() {
		sectionController = new ExpanderSectionController
	}

	/**
	 * Handles the identity queries. It means the managed sections statuses
	 * should be transmitted to the subscribed topic.
	 * 
	 * @throws InterruptedException if the thread has been interrupted
	 */
	private def handleIdentify() throws InterruptedException {
		val sections = sectionController.getSectionsWithStatus
		for (Entry<String, SectionStatus> sectionEntry : sections) {
			// TODO publish status messages
			// sender.publishMessage(payload, topic);
		}
	}

	/**
	 * If the embedded controller manages the referred section (that is received
	 * in the Payload), then its status will be queried and sent back on the
	 * subscribed topic.
	 * 
	 * @param receivedPayload the payload that stores the section's ID whose
	 * status should be queried
	 */
	private def handleGetSectionStatus() {
		/*Section section = receivedPayload.getContentAs(Section.class);
		 * if (sectionController.controllerManagesSection(section)) {
		 *     logInfoMessage(CLASS_NAME,
		 *             "section " + section.getId() + " status query received");

		 *     SectionStatus status = sectionController.getSectionStatus(
		 *             section.getId());
		 *     section.setStatus(status);
		 *     Payload payload = createCommandWithContent(SEND_SECTION_STATUS,
		 *             section);
		 *     sender.publishMessage(payload, topic);
		 }*/
	}

	/**
	 * If the embedded controller manages the referred section (that is received
	 * in the Payload), then this section will be enabled.
	 * 
	 * @param receivedPayload the payload that stores the section's ID that
	 * should be enabled
	 */
	private def handleLineEnable() {
		/*Section section = payload.getContentAs(Section.class);
		 * if (sectionController.controllerManagesSection(section)) {
		 *     logInfoMessage(CLASS_NAME,
		 *             "enable section " + section.getId() + " command received");

		 *     sectionController.enableSection(section.getId());
		 }*/
	}

	/**
	 * If the embedded controller manages the referred section (that is received
	 * in the Payload), then this section will be disabled.
	 * 
	 * @param receivedPayload the payload that stores the section's ID that
	 * should be disabled
	 */
	private def handleLineDisable() {
		/*Section section = payload.getContentAs(Section.class);
		 * if (sectionController.controllerManagesSection(section)) {
		 *     logInfoMessage(CLASS_NAME,
		 *             "disable section " + section.getId() + " command received");

		 *     sectionController.disableSection(section.getId());
		 }*/
	}

}
