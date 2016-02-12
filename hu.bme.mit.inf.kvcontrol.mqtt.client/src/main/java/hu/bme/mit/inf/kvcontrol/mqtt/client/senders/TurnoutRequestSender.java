package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import com.google.gson.Gson;
import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.GET_TURNOUT_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_TURNOUT_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import static hu.bme.mit.inf.mqtt.common.data.TurnoutStatus.DIVERGENT;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithPayload;
import static hu.bme.mit.inf.mqtt.common.util.ClientIdGenerator.generateId;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class TurnoutRequestSender implements MqttCallback {

    private final MQTTPublisherSubscriber sender;
    private final String subscribedTopic;

    private final Map<Integer, CompletableFuture<TurnoutStatus>> turnoutStatuses = new ConcurrentHashMap<>();

    public TurnoutRequestSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTPublisherSubscriber(config);
        this.sender.subscribe(this);
        this.subscribedTopic = config.getTopic();
    }

    public boolean isTurnoutDivergent(int turnoutId) {
        if (!turnoutStatuses.containsKey(turnoutId)) {
            turnoutStatuses.put(turnoutId, new CompletableFuture<>());
        }

        String payloadContent = new Turnout(turnoutId).toJson();
        sendCommandWithPayload(GET_TURNOUT_STATUS, payloadContent, sender);

        TurnoutStatus status = null;
        try {
            status = turnoutStatuses.get(turnoutId).get();
            turnoutStatuses.remove(turnoutId);
        } catch (InterruptedException | ExecutionException ex) {
            logException(getClass().getName(), ex);
        }

        return status == DIVERGENT;
    }

    public boolean isTurnoutStraight(int turnoutId) {
        return !isTurnoutDivergent(turnoutId);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        try {
            if (!subscribedTopic.equals(topic)) {
                return;
            }

            Payload payloadObj = getPayloadFromMessage(message);
            Command command = (Command) payloadObj.getCommand();

            switch (command) {
                case SEND_TURNOUT_STATUS:
                    Turnout turnout = new Gson().fromJson(
                            payloadObj.getContent(),
                            Turnout.class);
                    CompletableFuture<TurnoutStatus> future = turnoutStatuses.get(
                            turnout.getId());

                    if (future != null) {
                        future.complete(turnout.getStatus());
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(getClass().getName(), new Exception(ex));
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        logException(getClass().getName(), new Exception(cause));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

}
