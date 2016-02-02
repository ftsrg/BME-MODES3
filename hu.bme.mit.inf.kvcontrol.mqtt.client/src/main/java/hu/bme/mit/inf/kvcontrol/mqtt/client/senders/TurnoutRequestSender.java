package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import com.google.gson.Gson;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Command;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.data.Command.GET_TURNOUT_STATUS;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Payload;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Turnout;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.ClientIdGenerator.generateId;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.TurnoutStatus;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.data.TurnoutStatus.DIVERGENT;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.LogManager.logException;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.PayloadHelper.sendCommandWithPayload;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author benedekh
 */
public class TurnoutRequestSender implements MqttCallback {

    private final ISender sender;
    private final String subscribedTopic;

    private final Map<Integer, CompletableFuture<TurnoutStatus>> turnoutStatuses = new ConcurrentHashMap<>();

    public TurnoutRequestSender(String topic, int qos, String address) {
        this.sender = new MQTTMessageSender(topic, qos, address,
                generateId(getClass().getSimpleName()), this);
        this.subscribedTopic = topic;
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
    public void connectionLost(Throwable cause) {
        logException(getClass().getName(), new Exception(cause));
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        if (!subscribedTopic.equals(topic)) {
            return;
        }

        Payload payloadObj = getPayloadFromMessage(message);
        Command command = payloadObj.getCommand();

        switch (command) {
            case SEND_TURNOUT_STATUS:
                Turnout turnout = new Gson().fromJson(payloadObj.getContent(),
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
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

}
