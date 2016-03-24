package hu.bme.mit.inf.master.mqtt.client.network;

import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.master.bbb.strategy.ExpanderSectionController;
import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_TURNOUT_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import java.util.List;

/**
 *
 * @author benedekh, hegyibalint
 */
public class SectionsMessageHandler implements MqttCallback {

    private static final String CLASS_NAME = SectionsMessageHandler.class.getName();

    private final MQTTPublisherSubscriber mqttConnection;
    private final ExpanderSectionController sectionController;

    public SectionsMessageHandler(MQTTPublisherSubscriber pubsub) {
        this.mqttConnection = pubsub;
        try {
			this.mqttConnection.subscribe("modes3/kvcontrol/section", this);
		} catch (MqttException e) {
			 logException(CLASS_NAME, e);
		}
        this.sectionController = new ExpanderSectionController(mqttConnection);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        try {
            if (!mqttConnection.getSubscribedTopic().equals(topic)) {
                return;
            }

            Payload payload = getPayloadFromMessage(message);
            Command command = payload.getCommand();

            switch (command) {
                case IDENTIFY:
                    handleIdentify();
                case GET_SECTION_STATUS:
                    handleGetSectionStatus(payload);
                    break;
                case LINE_ENABLE:
                    handleLineEnable(payload);
                    break;
                case LINE_DISABLE:
                    handleLineDisable(payload);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(CLASS_NAME, new Exception(ex));
        }
    }

    private void handleIdentify() throws InterruptedException {
        List<Section> sections = sectionController.getSectionsWithStatus();
        for (Section section : sections) {
            sendCommandWithContent(SEND_SECTION_STATUS, section, mqttConnection);
            Thread.sleep(10);
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        logException(CLASS_NAME, new Exception(cause));
        mqttConnection.reconnectClient();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // deliberately left empty
    }

    private void handleGetSectionStatus(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (sectionController.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "section " + section.getId() + " status query received");

            SectionStatus status = sectionController.getSectionStatus(
                    section.getId());
            section.setStatus(status);
            sendCommandWithContent(SEND_SECTION_STATUS,
                    section, mqttConnection);
        }
    }

    private void handleLineEnable(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (sectionController.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "enable section " + section.getId() + " command received");

            sectionController.enableSection(section.getId());
        }
    }

    private void handleLineDisable(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (sectionController.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "disable section " + section.getId() + " command received");

            sectionController.disableSection(section.getId());
        }
    }

}
