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
 * This class can query the sections status (disabled / enabled) on the railway
 * track.
 *
 * It is based on the section status information provided by the embedded
 * controllers that control the referred switch (turnout) and the connecting
 * sections.
 *
 * Disabled means no train can move on that section. Enabled means anyone can go
 * on that section.
 *
 * @author benedekh
 */
public class SectionRequestSender implements MessageFilter {

    // the MQTT topic where the section status data is transferred
    private static final String topic = "modes3/kvcontrol/section";

    // the dispatcher for that it subscribes on the referred topic
    private final MQTTPublishSubscribeDispatcher requestSender;

    // is active polling enabled
    private volatile boolean pollingEnabled = false;

    // the status of each section, denoted by its ID
    private final Map<Integer, SectionStatus> sectionStatuses = new ConcurrentHashMap<>();

    /**
     * Receives a dispatcher for that it subscribes on the referred topic
     * (@topic field).
     *
     * @param requestSender the dispatcher for that it subscribes
     */
    public SectionRequestSender(MQTTPublishSubscribeDispatcher requestSender) {
        this.requestSender = requestSender;
        this.requestSender.subscribe(topic, this);
        // send an initial identify message to update the statuses
        this.sendIdentify();
    }

    /**
     * Enables or disables the status polling. If disabled it does not send any
     * request to the embedded controller, instead it waits for the section
     * status change notification from the controllers.
     *
     * If the polling is enabled then the embedded controllers will be queried
     * through the topic. It may generate a lot of network packets if the query
     * is done frequently. So do not use it directly (disable it), and in that
     * way the embedded controller will always send the latest status
     * information to the topic (change notification like approach).
     *
     * @param isPollingEnabled set the polling enabled or not
     */
    public void setPollingEnabled(boolean isPollingEnabled) {
        this.pollingEnabled = isPollingEnabled;
    }

    /**
     * Tells if the referred section is enabled (anyone can go on that section)
     * or not.
     *
     * @param sectionId the referred section
     * @return true, if the referred section is enabled, false otherwise.
     */
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

    /**
     * Enables the referred section, so anyone can go on that.
     *
     * @param sectionId the referred section which shall be enabled
     */
    public void enableSection(int sectionId) {
        SectionStatus lastStatus = sectionStatuses.get(sectionId);
        if (lastStatus != ENABLED) {
            Section section = new Section(sectionId, ENABLED);
            Payload payload = createCommandWithContent(LINE_ENABLE, section);
            requestSender.publishMessage(payload, topic);
        }
    }

    /**
     * Disables the referred section, so anyone can go on that.
     *
     * @param sectionId the referred section which shall be disabled
     */
    public void disableSection(int sectionId) {
        SectionStatus lastStatus = sectionStatuses.get(sectionId);
        if (lastStatus != DISABLED) {
            Section section = new Section(sectionId, DISABLED);
            Payload payload = createCommandWithContent(LINE_DISABLE, section);
            requestSender.publishMessage(payload, topic);
        }
    }

    /**
     * Sends an identify message to the topic, so every embedded controller
     * responds the controlled sections statuses.
     */
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
