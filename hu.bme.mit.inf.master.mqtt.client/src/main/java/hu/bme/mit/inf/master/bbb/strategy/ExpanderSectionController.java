package hu.bme.mit.inf.master.bbb.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import hu.bme.mit.inf.master.bbb.conf.ExpanderControllerConfiguration;
import hu.bme.mit.inf.master.bbb.conf.IControllerConfiguration;
import hu.bme.mit.inf.master.bbb.utils.HexConversionUtil;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_SECTION_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.DISABLED;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.ENABLED;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import io.silverspoon.bulldog.core.Signal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hegyibalint, benedekh
 */
public class ExpanderSectionController extends AbstractControllerStrategy implements IControllerConfiguration {

    protected MQTTPublisherSubscriber mqttPublisher;
    protected ExpanderControllerConfiguration controllerConf;
    protected Map<String, SectionStatus> sectionStatus;

    public ExpanderSectionController(MQTTPublisherSubscriber mqttPublisher) {
        try {
            controllerConf = new ExpanderControllerConfiguration();
        } catch (Exception ex) {
            logException(getClass().getName(), ex);
        }

        this.mqttPublisher = mqttPublisher;

        sectionStatus = new ConcurrentHashMap<>();
        for (String sec : controllerConf.getAllSection()) {
            onEnableSection(HexConversionUtil.fromString(sec));
        }
    }

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
        publishSectionStatus(sectionId, ENABLED, mqttPublisher);
    }

    @Override
    protected void onDisableSection(int sectionId) {
        String[] sectionExpander = controllerConf.getSectionExpander(sectionId);
        this.setPinLevel(sectionExpander[0], Signal.Low);
        this.setPinLevel(sectionExpander[1], Signal.Low);
        this.setPinLevel(sectionExpander[2], Signal.Low);
        this.setPinLevel(sectionExpander[3], Signal.Low);
        sectionStatus.put(HexConversionUtil.fromNumber(sectionId), DISABLED);
        publishSectionStatus(sectionId, DISABLED, mqttPublisher);
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

    private void publishSectionStatus(int id, SectionStatus status,
            MQTTPublisherSubscriber mqttPublisher) {
        Section section = new Section(id);
        section.setStatus(status);
        sendCommandWithContent(SEND_SECTION_STATUS, section, mqttPublisher);
    }

}
