package hu.bme.masterrace;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState;
import org.eclipse.paho.client.mqttv3.*;

import java.util.concurrent.Semaphore;

import static hu.bme.masterrace.Main.*;

@SuppressWarnings("Duplicates")
public class SegmentStates implements MqttCallback {
    private static final String TOPIC_INFO = "segment/state";
    private static final String TOPIC_COMMAND = "command/segment";
    private MqttClient myClient;
    private MqttConnectOptions connOpt;
    private String CLIENTID = "SCSegment";
    private Semaphore semaphore = new Semaphore(8); //max inflight miatt

    SegmentStates() {
        try {
            setConnectionOptions();
            connect();
            if (myClient.isConnected()) {
                subscribe();
                registerSegmentStateChange();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void registerSegmentStateChange() {
        segmentCommander.registerSegmentStateChangeListener((i, segmentState, segmentState1) ->
                sendSegmentState(i));
    }

    private void subscribe() throws MqttException {
        myClient.subscribe(TOPIC_INFO, 1);
        myClient.subscribe(TOPIC_COMMAND, 1);
    }

    private void connect() throws MqttException {
        myClient = new MqttClient(MQTTSERVERURI, CLIENTID);
        myClient.setCallback(this);
        myClient.connect(connOpt);
        System.out.println("Connected Segment State Commander!");
    }

    private void setConnectionOptions() {
        connOpt = new MqttConnectOptions();
        connOpt.setCleanSession(true);
        connOpt.setKeepAliveInterval(30);
        connOpt.setAutomaticReconnect(true);
    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("rip in connection");
        try {
            connect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) {
        printMessageToConsole(s, mqttMessage);
        handleRequest(s, getJsonObject(mqttMessage));
    }

    private void printMessageToConsole(String s, MqttMessage mqttMessage) {
        System.out.println("-------------------------------------------------");
        System.out.println("| Topic:" + s);
        System.out.println("| Message: " + new String(mqttMessage.getPayload()));
        System.out.println("-------------------------------------------------");
    }

    private JsonObject getJsonObject(MqttMessage mqttMessage) {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new String(mqttMessage.getPayload()));
        return element.getAsJsonObject();
    }

    private void handleRequest(String topic, JsonObject message) {
        if (topic.equals(TOPIC_INFO))
            handleTopicInfo(message);
        if (topic.equals(TOPIC_COMMAND))
            handleTopicCommand(message);
    }

    private void handleTopicCommand(JsonObject message) {
        if (message.has("state") && message.has("segmentID")) {
            sendSegmentCommand(message, "state");
        }
        //ez a camera miatt, hogy egyszerre 2-t kapcsoljon le
        if (message.has("state2") && message.has("segmentID")) {
            sendSegmentCommand(message, "state2");
        }
        if (message.has("stateAll")) {
            sendSegmentCommandAll(message);
        }

    }

    private void sendSegmentCommandAll(JsonObject message) {
        for (int segmentID : segmentIDs)
            elementCommander.sendSegmentCommand(segmentID, getSegmentState(message, "stateAll"));

    }

    private void sendSegmentCommand(JsonObject message, String tag) {
        elementCommander.sendSegmentCommand(Integer.valueOf(message.get("segmentID").toString()),
                getSegmentState(message, tag));
    }

    private SegmentState getSegmentState(JsonObject message, String tag) {
        if (message.get(tag).toString().equals("0"))
            return SegmentState.DISABLED;
        if (message.get(tag).toString().equals("1"))
            return SegmentState.ENABLED;
        return null;
    }

    private void handleTopicInfo(JsonObject message) {
        if (message.has("getstate") && message.has("segmentID"))
            if (message.get("getstate").toString().equals("\"one\""))
                sendSegmentState(Integer.parseInt(message.get("segmentID").toString()));

        if (message.has("getstate"))
            if (message.get("getstate").toString().equals("\"every\""))
                sendSegmentStateAll(message);
    }

    private void sendSegmentStateAll(JsonObject message) {

        Thread thread = new Thread(() -> {
            for (int segmentID : segmentIDs) {
                sendSegmentState(segmentID);
            }
        });
        thread.start();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        semaphore.release();
    }

    private void sendSegmentState(int segmentID) {
        try {
            SegmentState state = segmentCommander.getSegmentState(segmentID);
            if (state.equals(SegmentState.DISABLED)) {
                semaphore.acquire();
                myClient.publish(TOPIC_INFO, new MqttMessage(makeMessage(segmentID, "0").getBytes()));
            }
            if (state.equals(SegmentState.ENABLED)) {
                semaphore.acquire();
                myClient.publish(TOPIC_INFO, new MqttMessage(makeMessage(segmentID, "1").getBytes()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String makeMessage(int segmentID, String s) {
        return "{\"segmentID\":" + segmentID + ",\"state\":" + s + "}";
    }
}
