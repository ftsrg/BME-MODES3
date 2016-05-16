package hu.bme.mit.inf.master.bbb.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import hu.bme.mit.inf.master.bbb.conf.ExpanderControllerConfiguration;
import hu.bme.mit.inf.master.bbb.conf.IControllerConfiguration;
import hu.bme.mit.inf.master.bbb.utils.HexConversionUtil;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_SECTION_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.DISABLED;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.ENABLED;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.createCommandWithContent;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import io.silverspoon.bulldog.core.Signal;
import java.util.ArrayList;
import java.util.List;

/**
 * The section controller part of the embedded controller. Through it the
 * referred sections can be managed.
 *
 * @author hegyibalint, benedekh
 */
public class ExpanderSectionController extends AbstractControllerStrategy implements IControllerConfiguration {

    // the transmitter of messages through MQTT
    protected MQTTPublishSubscribeDispatcher mqttPublisher;

    // the topic for that the section controller sends the status information
    protected String subscribedTopic;

    // the actual embedded controller which manages the sections
    protected ExpanderControllerConfiguration controllerConf;

    // the sections statuses based on the section ID
    protected Map<String, SectionStatus> sectionStatus;

    /**
     * @param mqttPublisher the transmitter of messages through MQTT
     * @param topic the topic for that the section controller sends the status
     * information
     */
    public ExpanderSectionController(
            MQTTPublishSubscribeDispatcher mqttPublisher, String topic) {
        try {
            controllerConf = new ExpanderControllerConfiguration();
        } catch (Exception ex) {
            logException(getClass().getName(), ex);
        }

        this.mqttPublisher = mqttPublisher;
        this.subscribedTopic = topic;

        sectionStatus = new ConcurrentHashMap<>();
        for (String sec : controllerConf.getAllSection()) {
            onEnableSection(HexConversionUtil.fromString(sec));
        }
    }

    /**
     * @return the most recent section status information
     */
    public List<Section> getSectionsWithStatus() {
        List<Section> results = new ArrayList<>();
        for (String sectionId : sectionStatus.keySet()) {
            Section section = new Section(
                    HexConversionUtil.fromString(sectionId));
            section.setStatus(sectionStatus.get(sectionId));
            results.add(section);
        }
        return results;
    }

    @Override
    protected SectionStatus onGetSectionStatus(int sectionId) {
        return sectionStatus.get(HexConversionUtil.fromNumber(sectionId));
    }

    @Override
    protected void onEnableSection(int sectionId) {
        String[] sectionExpander = controllerConf.getSectionExpander(sectionId);
        this.setPinLevel(sectionExpander[0], Signal.High);
        this.setPinLevel(sectionExpander[1], Signal.High);
        this.setPinLevel(sectionExpander[2], Signal.High);
        this.setPinLevel(sectionExpander[3], Signal.High);
        sectionStatus.put(HexConversionUtil.fromNumber(sectionId), ENABLED);
        publishSectionStatus(sectionId, ENABLED);
    }

    @Override
    protected void onDisableSection(int sectionId) {
        String[] sectionExpander = controllerConf.getSectionExpander(sectionId);
        this.setPinLevel(sectionExpander[0], Signal.Low);
        this.setPinLevel(sectionExpander[1], Signal.Low);
        this.setPinLevel(sectionExpander[2], Signal.Low);
        this.setPinLevel(sectionExpander[3], Signal.Low);
        sectionStatus.put(HexConversionUtil.fromNumber(sectionId), DISABLED);
        publishSectionStatus(sectionId, DISABLED);
    }

    @Override
    public boolean controllerManagesSection(Section section) {
        return controllerConf.controllerManagesSection(section);
    }

    @Override
    public boolean controllerManagesTurnout(Turnout turnout) {
        throw new UnsupportedOperationException(
                "ExpanderSectionController does not support turnout operations");
    }

    @Override
    protected TurnoutStatus onGetTurnoutStatus(int turnoutId) {
        throw new UnsupportedOperationException(
                "ExpanderSectionController does not support turnout operations");
    }

    /**
     * Sends the respective section's status to the subscribed topic through
     * MQTT.
     *
     * @param id the ID of section whose status will be transferred
     * @param status the status of the referred section
     */
    private void publishSectionStatus(int id, SectionStatus status) {
        Section section = new Section(id);
        section.setStatus(status);
        Payload payload = createCommandWithContent(SEND_SECTION_STATUS, section);
        mqttPublisher.publishMessage(payload, subscribedTopic);
    }

}
