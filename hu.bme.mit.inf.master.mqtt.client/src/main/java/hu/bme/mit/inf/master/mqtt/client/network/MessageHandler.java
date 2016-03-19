package hu.bme.mit.inf.master.mqtt.client.network;

import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_TURNOUT_STATUS;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.master.bbb.strategy.ExpanderController;
import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;

public class MessageHandler implements MqttCallback {

    private static final String CLASS_NAME = MessageHandler.class.getName();

    private final MQTTPublisherSubscriber mqttConnection;
    private final ExpanderController controller;

    public MessageHandler(MQTTConfiguration conf) throws Exception {
        this.mqttConnection = new MQTTPublisherSubscriber(conf);
        this.mqttConnection.subscribe(this);
        this.controller = new ExpanderController();
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
                    handleIdentity(payload);
                    break;
                case GET_SECTION_STATUS:
                    handleGetSectionStatus(payload);
                    break;
                case GET_TURNOUT_STATUS:
                    handleGetTurnoutStatus(payload);
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

    @Override
    public void connectionLost(Throwable cause) {
        logException(CLASS_NAME, new Exception(cause));
        mqttConnection.reconnectClient();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // deliberately left empty
    }

    private void handleIdentity(Payload payload) {
        throw new UnsupportedOperationException(
                "handleIdentity Not supported yet.");
    }

    private void handleGetSectionStatus(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (controller.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "section " + section.getId() + " status query received");

            SectionStatus status = controller.getSectionStatus(
                    section.getId());
            section.setStatus(status);
            sendCommandWithContent(SEND_SECTION_STATUS,
                    section, mqttConnection);
        }
    }

    private void handleGetTurnoutStatus(Payload payload) {
        Turnout turnout = payload.getContentAs(Turnout.class);
        if (controller.controllerManagesTurnout(turnout)) {
            logInfoMessage(CLASS_NAME,
                    "turnout status query received");

            TurnoutStatus status = controller.getTurnoutStatus(turnout.getId());
            turnout.setStatus(status);
            sendCommandWithContent(SEND_TURNOUT_STATUS,
                    turnout, mqttConnection);
        }
    }

    private void handleLineEnable(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (controller.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "enable section " + section.getId() + " command received");

            controller.enableSection(section.getId());
        }
    }

    private void handleLineDisable(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (controller.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "disable section " + section.getId() + " command received");

            controller.disableSection(section.getId());
        }
    }

}
