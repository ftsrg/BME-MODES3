package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import static hu.bme.mit.inf.mqtt.common.data.Command.GET_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.IDENTIFY;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_DISABLE;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_ENABLE;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.DISABLED;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.ENABLED;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.kvcontrol.mqtt.client.RequestSender;
import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.Identity;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionArray;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;

/**
 *
 * @author benedekh
 */
public class SectionRequestSender extends RequestSender {

	// is active polling enabled
	private volatile boolean pollingEnabled = false;

	private final Map<Integer, SectionStatus> sectionStatuses = new ConcurrentHashMap<>();

	public SectionRequestSender(MQTTPublisherSubscriber mqtt) throws MqttException {
		super("modes3/kvcontrol/section", mqtt);
	}

	public void setPollingEnabled(boolean isPollingEnabled) {
		this.pollingEnabled = isPollingEnabled;
	}

	public boolean isSectionEnabled(int sectionId) {
		if (!sectionStatuses.containsKey(sectionId)) {
			sectionStatuses.put(sectionId, SectionStatus.ENABLED);
		}

		if (pollingEnabled) {
			Section section = new Section(sectionId);
			sendCommandWithContent(GET_SECTION_STATUS, section, mqtt);
		}

		SectionStatus status = sectionStatuses.get(sectionId);
		return status == ENABLED;
	}

	public void enableSection(int sectionId) {
		Section section = new Section(sectionId, ENABLED);
		sendCommandWithContent(LINE_ENABLE, section, mqtt);
	}

	public void disableSection(int sectionId) {
		Section section = new Section(sectionId, DISABLED);
		sendCommandWithContent(LINE_DISABLE, section, mqtt);
	}

	public void sendIdentify() {
		Turnout dummyTurnout = new Turnout(0x01);
		Section dummySection = new Section(0x01);
		SectionArray dummyArray = new SectionArray(new Section[] { dummySection });
		Identity identity = new Identity(dummyTurnout, dummyArray);
		sendCommandWithContent(IDENTIFY, identity, mqtt);
	}
	
	@Override
	public void filteredMessageArrived(MqttMessage message) {
		try {
			Payload payload = getPayloadFromMessage(message);
			Command command = payload.getCommand();

			switch (command) {
			case SEND_SECTION_STATUS:
				Section section = payload.getContentAs(Section.class);
				sectionStatuses.put(section.getId(), section.getStatus());
				break;
			default:
				break;
			}
		} catch (Exception ex) {
			logException(getClass().getName(), new Exception(ex));
		}
	}
}
