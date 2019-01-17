package hu.bme.masterrace;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState;
import org.eclipse.paho.client.mqttv3.*;

import java.util.concurrent.Semaphore;

import static hu.bme.masterrace.Main.*;


public class Turnout implements org.eclipse.paho.client.mqttv3.MqttCallback {
    private static final String TOPIC_INFO = "turnout/state";
    private static final String TOPIC_COMMAND = "command/turnout";
    private MqttClient myClient;
    private MqttConnectOptions connOpt;
    private String CLIENTID = "SCTurnout";
    private Semaphore semaphore = new Semaphore(8);

    Turnout() {
        try {
            setConnectionOptions();

            connect();

            if (myClient.isConnected()) {
                subscribe();
                registerTurnoutState();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void registerTurnoutState() {
        segmentCommander.registerTurnoutStateChangeListener((i, tState, tState1) ->
                sendTurnoutState(i));
    }

    private void subscribe() throws MqttException {
        myClient.subscribe(TOPIC_INFO, 1);
        myClient.subscribe(TOPIC_COMMAND, 1);
    }

    private void connect() throws MqttException {
        myClient = new MqttClient(MQTTSERVERURI, CLIENTID);
        myClient.setCallback(this);
        myClient.connect(connOpt);

        System.out.println("Connected Turnout Commander!");
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
        if (message.has("state") && message.has("turnoutID")) {

            sendTurnoutCommand(message);
        }
    }


    private void sendTurnoutCommand(JsonObject message) {

        elementCommander.sendTurnoutCommandWithTurnoutId(Integer.valueOf(message.get("turnoutID").toString()),
               getTurnoutState(message));



    }

    private hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState getTurnoutState(JsonObject message) {


        if (message.get("state").toString().equals("\"straight\""))
            return hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState.STRAIGHT;
        if (message.get("state").toString().equals("\"divergent\""))
            return hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState.DIVERGENT;
        return null;
    }

    private void handleTopicInfo(JsonObject message) {
        if (message.has("getstate") && message.has("turnoutID")) {
            if (message.get("getstate").toString().equals("\"one\"")) {
                sendTurnoutState(Integer.parseInt(message.get("turnoutID").toString()));
            }
        }
        if (message.has("getstate")) {
            if (message.get("getstate").toString().equals("\"every\"")) {
                sendTurnoutStateAll(message);
            }
        }

    }

    private void sendTurnoutStateAll(JsonObject message) {
        for (int i = 1; i <= 6; i++) {
            sendTurnoutState(i);
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        semaphore.release();


    }

    private void sendTurnoutState(int turnoutID) {

        try {

            hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState state = segmentCommander.getTurnoutState(turnoutID);
            System.out.println(turnoutID + segmentCommander.getTurnoutState(turnoutID).toString());
            if (state.equals(hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState.DIVERGENT)) {

                semaphore.acquire();
                myClient.publish(TOPIC_INFO, new MqttMessage(makeMessage(turnoutID, "divergent").getBytes()));

            }
            if (state.equals(hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState.STRAIGHT)) {

                semaphore.acquire();
                myClient.publish(TOPIC_INFO, new MqttMessage(makeMessage(turnoutID, "straight").getBytes()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String makeMessage(int turnoutID, String s) {
        return "{\"turnoutID\":" + turnoutID + ",\"state\":\"" + s+ "\"}";
    }
}
