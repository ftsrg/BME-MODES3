package hu.bme.masterrace;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.eclipse.paho.client.mqttv3.*;

import java.util.logging.Logger;

import static hu.bme.masterrace.MainControl.MQTTSERVERURI;
import static hu.bme.masterrace.MainControl.segmentCommander;

@SuppressWarnings("Duplicates")
public class SegmentState implements org.eclipse.paho.client.mqttv3.MqttCallback {
    private MqttClient myClient;
    private MqttConnectOptions connOpt;


    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection lost!");
        try {
            Thread.sleep(3000);
            runClient();
        } catch (InterruptedException e) {
            System.out.println("rip in connectionLost");
            e.printStackTrace();
        }
    }

    private void runClient() {
        String clientID = "StationControllerSegmentAPI";
        connOpt = new MqttConnectOptions();
        connOpt.setCleanSession(true);
        connOpt.setKeepAliveInterval(30);
        connOpt.setUserName("StationControllerSegmentAPI");

        try {
            myClient = new MqttClient(MQTTSERVERURI, clientID);
            myClient.setCallback(this);
            myClient.connect(connOpt);
        } catch (MqttException e) {
            runClient();
        }
        System.out.println("Connected to " + MQTTSERVERURI);
        String myTopic = "segment/state";
        MqttTopic topic = myClient.getTopic(myTopic);

        try {
            myClient.subscribe(myTopic, 0);
            sendSegmentStateChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {

        System.out.println("-------------------------------------------------");
        System.out.println("| Topic:" + topic);
        System.out.println("| Message: " + new String(mqttMessage.getPayload()));
        System.out.println("-------------------------------------------------");
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new String(mqttMessage.getPayload()));
        JsonObject obj = element.getAsJsonObject();

        if(obj.get("getstate").toString().equals("one"))
            sendSegmentState(Integer.parseInt(obj.get("segmentID").toString()));

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }


    private void sendSegmentStateChanged() { //todo on change send state
        segmentCommander.registerSegmentStateChangeListener((i, segmentState, segmentState1) ->
                sendSegmentState(i));
    }


    /*
    sends the requested segment state to MQTT topic segment/state
     */
    private void sendSegmentState(int segmentID) { //todo check
        hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState state = segmentCommander.getSegmentState(segmentID);

        if (state.equals(hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState.DISABLED)) {
            try {
                String message = "{\"segmentID\":" + segmentID + ",\"state\":0}\")";
                myClient.publish("segment/state", new MqttMessage(message.getBytes())); //disabled");

            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
        if (state.equals(hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState.ENABLED)) {
            try {
                String message = "{\"segmentID\":" + segmentID + ",\"state\":1}\")";
                myClient.publish("segment/state", new MqttMessage(message.getBytes())); //disabled");

            } catch (MqttException e) {
                e.printStackTrace();
            }
        }


    }

}
