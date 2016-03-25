package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import static hu.bme.mit.inf.mqtt.common.data.Command.GET_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.IDENTIFY;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_DISABLE;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_ENABLE;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.DISABLED;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.ENABLED;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.Identity;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionArray;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.network.MessageFilter;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.createCommandWithContent;

/**
 *
 * @author benedekh
 */
public class SectionRequestSender implements MessageFilter {

    private static final String topic = "modes3/kvcontrol/section";

    private final MQTTPublishSubscribeDispatcher requestSender;

    // is active polling enabled
    private volatile boolean pollingEnabled = false;

    private final Map<Integer, SectionStatus> sectionStatuses = new ConcurrentHashMap<>();

    public SectionRequestSender(MQTTPublishSubscribeDispatcher requestSender) {
        this.requestSender = requestSender;
        this.requestSender.subscribe(topic, this);
        this.sendIdentify();
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
            Payload payload = createCommandWithContent(GET_SECTION_STATUS,
                    section);
            requestSender.publishMessage(payload, topic);
        }

        SectionStatus status = sectionStatuses.get(sectionId);
        return status == ENABLED;
    }

    public void enableSection(int sectionId) {
        Section section = new Section(sectionId, ENABLED);
        Payload payload = createCommandWithContent(LINE_ENABLE, section);
        requestSender.publishMessage(payload, topic);
    }

    public void disableSection(int sectionId) {
        Section section = new Section(sectionId, DISABLED);
        Payload payload = createCommandWithContent(LINE_DISABLE, section);
        requestSender.publishMessage(payload, topic);
    }

    public void sendIdentify() {
        Turnout dummyTurnout = new Turnout(0x01);
        Section dummySection = new Section(0x01);
        SectionArray dummyArray = new SectionArray(new Section[]{dummySection});
        Identity identity = new Identity(dummyTurnout, dummyArray);
        Payload payload = createCommandWithContent(IDENTIFY, identity);
        requestSender.publishMessage(payload, topic);
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
            logException(getClass().getName(), ex);
        }
    }
}
