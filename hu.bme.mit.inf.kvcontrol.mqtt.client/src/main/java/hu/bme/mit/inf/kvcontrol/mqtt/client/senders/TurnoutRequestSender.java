package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import hu.bme.mit.inf.kvcontrol.mqtt.client.RequestSender;
import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.GET_TURNOUT_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.IDENTIFY;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_TURNOUT_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Identity;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionArray;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import static hu.bme.mit.inf.mqtt.common.data.TurnoutStatus.STRAIGHT;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.util.ClientIdGenerator.generateId;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class TurnoutRequestSender extends RequestSender {

    // is active polling enabled
    private volatile boolean pollingEnabled = false;
    private final Map<Integer, TurnoutStatus> turnoutStatuses = new ConcurrentHashMap<>();

    public TurnoutRequestSender(MQTTPublisherSubscriber mqtt) throws MqttException {
    	super("modes3/kvcontrol/turnout", mqtt);
    }

    public void setPollingEnabled(boolean isPollingEnabled) {
        this.pollingEnabled = isPollingEnabled;
    }

    public boolean isTurnoutDivergent(int turnoutId) {
        return !isTurnoutStraight(turnoutId);
    }

    public boolean isTurnoutStraight(int turnoutId) {
        if (!turnoutStatuses.containsKey(turnoutId)) {
            turnoutStatuses.put(turnoutId, STRAIGHT);
        }

        if (pollingEnabled) {
            Turnout turnout = new Turnout(turnoutId);
            sendCommandWithContent(GET_TURNOUT_STATUS, turnout, mqtt);
        }

        TurnoutStatus status = turnoutStatuses.get(turnoutId);
        return status == STRAIGHT;
    }

    public void sendIdentify() {
        Turnout dummyTurnout = new Turnout(0x01);
        Section dummySection = new Section(0x01);
        SectionArray dummyArray = new SectionArray(new Section[]{dummySection});
        Identity identity = new Identity(dummyTurnout, dummyArray);
        sendCommandWithContent(IDENTIFY, identity, mqtt);
    }

    @Override
    public void filteredMessageArrived(MqttMessage message) {
        try {
            Payload payload = getPayloadFromMessage(message);
            Command command = payload.getCommand();

            switch (command) {
                case SEND_TURNOUT_STATUS:
                    Turnout turnout = payload.getContentAs(Turnout.class);
                    turnoutStatuses.put(turnout.getId(), turnout.getStatus());
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(getClass().getName(), new Exception(ex));
        }
    }

}
