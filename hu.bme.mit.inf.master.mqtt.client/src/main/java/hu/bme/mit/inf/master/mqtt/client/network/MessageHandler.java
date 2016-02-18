package hu.bme.mit.inf.master.mqtt.client.network;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.master.bbb.conf.ControllerConfiguration;
import hu.bme.mit.inf.master.bbb.strategy.AbstractControllerStrategy;
import hu.bme.mit.inf.mqtt.common.data.Command;

import static hu.bme.mit.inf.mqtt.common.data.Command.GET_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.GET_TURNOUT_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.IDENTIFY;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_DISABLE;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_ENABLE;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_TURNOUT_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Identity;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;

public class MessageHandler implements MqttCallback {

    private static final String CLASS_NAME = MessageHandler.class.getName();

    private final ControllerConfiguration controllerConf;
    private final MQTTPublisherSubscriber mqttConnection;

    private final AbstractControllerStrategy controllerStrategy;

    public MessageHandler(MQTTConfiguration conf) {
        this.controllerConf = new ControllerConfiguration();
        this.mqttConnection = new MQTTPublisherSubscriber(conf);
        this.mqttConnection.subscribe(this);
        this.controllerStrategy = new AbstractControllerStrategy() {

            @Override
            protected TurnoutStatus onGetTurnoutStatus() {
                throw new UnsupportedOperationException(
                        "onGetTurnoutStatus Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected SectionStatus onGetSectionStatus(int sectionId) {
                throw new UnsupportedOperationException(
                        "onGetSectionStatus Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void onEnableSection(int sectionId) {
                throw new UnsupportedOperationException(
                        "onEnableSection Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void onDisableSection(int sectionId) {
                throw new UnsupportedOperationException(
                        "onDisableSection Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
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
                    handleIdentity();
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
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // deliberately left empty
    }

    private void handleIdentity() {
        logInfoMessage(CLASS_NAME, "identity query received");

        Identity identity = controllerConf.createIdentity();
        sendCommandWithContent(IDENTIFY, identity,
                mqttConnection);
    }

    private void handleGetSectionStatus(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (controllerConf.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "section " + section.getId() + " status query received");

            SectionStatus status = controllerStrategy.getSectionStatus(
                    section.getId());
            section.setStatus(status);
            sendCommandWithContent(SEND_SECTION_STATUS,
                    section, mqttConnection);
        }
    }

    private void handleGetTurnoutStatus(Payload payload) {
        Turnout turnout = payload.getContentAs(Turnout.class);
        if (controllerConf.controllerManagesTurnout(turnout)) {
            logInfoMessage(CLASS_NAME,
                    "turnout status query received");

            TurnoutStatus status = controllerStrategy.getTurnoutStatus();
            turnout.setStatus(status);
            sendCommandWithContent(SEND_TURNOUT_STATUS,
                    turnout, mqttConnection);
        }
    }

    private void handleLineEnable(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (controllerConf.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "enable section " + section.getId() + " command received");

            controllerStrategy.enableSection(section.getId());
        }
    }

    private void handleLineDisable(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (controllerConf.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "disable section " + section.getId() + " command received");

            controllerStrategy.disableSection(section.getId());
        }
    }

}
