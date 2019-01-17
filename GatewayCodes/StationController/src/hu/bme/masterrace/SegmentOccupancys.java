package hu.bme.masterrace;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy;
import org.eclipse.paho.client.mqttv3.*;

import java.util.concurrent.Semaphore;

import static hu.bme.masterrace.Main.*;

public class SegmentOccupancys implements MqttCallback {
    private static final String TOPIC_INFO = "segment/occupancy";
    private static final String TOPIC_COMMAND = "command/occupancy";
    private MqttClient myClient;
    private MqttConnectOptions connOpt;
    private String CLIENTID = "SCSegmentO";
    private Semaphore semaphore = new Semaphore(8); //max inflight miatt

    SegmentOccupancys() {
        try {
            setConnectionOptions();
            connect();
            if (myClient.isConnected()) {
                subscribe();
                registerSegmentOccupancyChanger();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void registerSegmentOccupancyChanger() {
        segmentCommander.registerSegmentOccupancyChangeListener((i, v, v1) ->
                sendOccupancy(i));
    }

    private void subscribe() throws MqttException {
        myClient.subscribe(TOPIC_INFO, 1);
        myClient.subscribe(TOPIC_COMMAND, 1);
    }

    private void connect() throws MqttException {
        myClient = new MqttClient(MQTTSERVERURI, CLIENTID);
        myClient.setCallback(this);
        myClient.connect(connOpt);
        System.out.println("Connected Segment Occpancy Commander!");
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
        if (message.has("occupancy") && message.has("segmentID"))
            sendSegmentOccCommand(message);

    }


    private void sendSegmentOccCommand(JsonObject message) {
        stateSender.sendSegmentOccupation(Integer.valueOf(message.get("segmentID").toString()),
                getSegmentOcc(message));
    }

    private SegmentOccupancy getSegmentOcc(JsonObject message) {
        if (message.get("occupancy").toString().equals("\"occupied\""))
            return SegmentOccupancy.OCCUPIED;
        if (message.get("occupancy").toString().equals("\"free\""))
            return SegmentOccupancy.FREE;
        return null;
    }

    private void handleTopicInfo(JsonObject message) {
        if (message.has("getoccupancy") && message.has("segmentID"))
            if (message.get("getoccupancy").toString().equals("\"one\""))
                sendOccupancy(Integer.parseInt(message.get("segmentID").toString()));

        if (message.has("getoccupancy"))
            if (message.get("getoccupancy").toString().equals("\"every\""))
                sendSegmentOccAll(message);

    }

    private void sendSegmentOccAll(JsonObject message) {
        Thread thread = new Thread(() -> {
            for (int segmentID : segmentIDs) {
                sendOccupancy(segmentID);
            }
        });
        thread.start();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        semaphore.release();
    }

    private void sendOccupancy(int segmentID) {
        try {
            SegmentOccupancy state = segmentCommander.getSegmentOccupancy(segmentID);
            if (state.equals(SegmentOccupancy.OCCUPIED)) {
                semaphore.acquire();
                myClient.publish(TOPIC_INFO, new MqttMessage(makeMessage(segmentID, "occupied").getBytes()));
            }
            if (state.equals(SegmentOccupancy.FREE)) {
                semaphore.acquire();
                myClient.publish(TOPIC_INFO, new MqttMessage(makeMessage(segmentID, "free").getBytes()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String makeMessage(int segmentID, String s) {
        return "{\"segmentID\":" + segmentID + ",\"occupancy\":" + s + "}";
    }
}
