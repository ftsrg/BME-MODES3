package hu.bme.mit.inf.master.mqtt.client.network;

import hu.bme.mit.inf.master.bbb.strategy.ExpanderTurnoutController;
import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_TURNOUT_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Identity;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import java.util.List;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class TurnoutMessageHandler implements MqttCallback {

    private static final String CLASS_NAME = SectionsMessageHandler.class.getName();

    private final MQTTPublisherSubscriber mqttConnection;
    private final ExpanderTurnoutController turnoutController;

    public TurnoutMessageHandler(MQTTPublisherSubscriber pubsub) {
        this.mqttConnection = pubsub;
        try {
			this.mqttConnection.subscribe("modes3/kvcontrol/turnout", this);
		} catch (MqttException e) {
			 logException(CLASS_NAME, e);
		}
        this.turnoutController = new ExpanderTurnoutController(mqttConnection);
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
                    break;
                case GET_TURNOUT_STATUS:
                    handleGetTurnoutStatus(payload);
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

    private void handleIdentify() throws InterruptedException {
        List<Turnout> turnouts = turnoutController.getTurnoutsWithStatus();
        for (Turnout turnout : turnouts) {
            sendCommandWithContent(SEND_TURNOUT_STATUS, turnout, mqttConnection);
            Thread.sleep(10);
        }
    }

    private void handleGetTurnoutStatus(Payload payload) {
        Turnout turnout = payload.getContentAs(Turnout.class);
        if (turnoutController.controllerManagesTurnout(turnout)) {
            logInfoMessage(CLASS_NAME,
                    "turnout status query received");

            TurnoutStatus status = turnoutController.getTurnoutStatus(
                    turnout.getId());
            turnout.setStatus(status);
            sendCommandWithContent(SEND_TURNOUT_STATUS,
                    turnout, mqttConnection);
        }
    }

}
