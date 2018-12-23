package hu.bme.masterrace;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommander;
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusCommandCallback;
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander;
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionCallback;
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionStateSender;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateSender;
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState;

import java.io.PrintStream;

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState;
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainDirectionValue;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

import static hu.bme.masterrace.MainControl.elementCommander;
import static hu.bme.masterrace.MainControl.segmentCommander;

public class MqttController implements org.eclipse.paho.client.mqttv3.MqttCallback {

    MqttClient myClient;
    MqttConnectOptions connOpt;
    static final String BROKER_URL = "tcp://192.168.1.150:1883";
    static final String M2MIO_DOMAIN = "hovasminek";
    static final String M2MIO_STUFF = "things";
    static final String M2MIO_THING = "StationController";
    static final String M2MIO_USERNAME = "StationController";
    static final String M2MIO_PASSWORD_MD5 = "";

    static final Boolean subscriber = Boolean.valueOf(true);
    static final Boolean publisher = Boolean.valueOf(false);

    public void connectionLost(Throwable t) {
        System.out.println("Connection lost!");
        try {
            Thread.sleep(3000);
            runClient();
        } catch (InterruptedException e) {
            System.out.println("rip in connectionLost");
            e.printStackTrace();
        }

    }

    public void runClient() {
        String clientID = "StationController";
        connOpt = new MqttConnectOptions();
        connOpt.setCleanSession(true);
        connOpt.setKeepAliveInterval(30);
        connOpt.setUserName("StationController");
        connOpt.setPassword("".toCharArray());

        try {
            myClient = new MqttClient("tcp://192.168.1.150:1883", clientID);
            myClient.setCallback(this);
            myClient.connect(connOpt);
        } catch (MqttException e) {
            runClient();
        }

        System.out.println("Connected to tcp://192.168.1.150:1883");

        String myTopic = "command/mysegment";
        MqttTopic topic = myClient.getTopic(myTopic);


        if (subscriber) {
            try {
                int subQoS = 0;
                myClient.subscribe(myTopic, subQoS);
                myClient.subscribe("segment/state",0);
                myClient.subscribe("turnout/state",0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (publisher) {
            for (int i = 1; i <= 10; i++) {
                String pubMsg = "{\"pubmsg\":" + i + "}";
                int pubQoS = 0;
                MqttMessage message = new MqttMessage(pubMsg.getBytes());
                message.setQos(pubQoS);
                message.setRetained(false);


                System.out.println("Publishing to topic \"" + topic + "\" qos " + pubQoS);
                MqttDeliveryToken token = null;
                try {
                    token = topic.publish(message);


                    token.waitForCompletion();
                    Thread.sleep(100L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deliveryComplete(IMqttDeliveryToken arg0) {
        System.out.println("Delivery Complete");
    }

    public void messageArrived(String arg0, MqttMessage arg1) {


        //todo if topic to command
        System.out.println("-------------------------------------------------");
        System.out.println("| Topic:" + arg0.toString());
        System.out.println("| Message: " + new String(arg1.getPayload()));
        System.out.println("-------------------------------------------------");
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new String(arg1.getPayload()));
        JsonObject obj = element.getAsJsonObject();

        String topic = arg0.toString().substring(8); //todo rewrite magic numbers
        sendCommandToMoDeS3(obj, topic);
        //todo if topic turnout/state and request
        //call segmentStateRequest

        //todo if topic turnout/state and req
    }

    private void sendSegmentStateChanged() { //todo on change send state
        segmentCommander.registerSegmentStateChangeListener((i, segmentState, segmentState1) ->
               sendSegmentState(i));
    }

    private void segmentStateRequest(MqttMessage message){ //todo listen on segment/state for getstate messages


        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new String(message.getPayload()));
        JsonObject obj = element.getAsJsonObject();
        int segment = Integer.parseInt(obj.get("segmentID").toString());
        sendSegmentState(segment);
    }

    /*
    sends the requested segment state to MQTT topic segment/state
     */
    private void sendSegmentState(int segmentID) { //todo check
        SegmentState state = segmentCommander.getSegmentState(segmentID);

        if (state.equals(SegmentState.DISABLED)) {
            try {
                String message = "{\"segmentID\":" + segmentID + ",\"state\":0}\")";
                myClient.publish("segment/state", new MqttMessage(message.getBytes())); //disabled");

            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
        if (state.equals(SegmentState.ENABLED)) {
            try {
                String message = "{\"segmentID\":" + segmentID + ",\"state\":1}\")";
                myClient.publish("segment/state", new MqttMessage(message.getBytes())); //disabled");

            } catch (MqttException e) {
                e.printStackTrace();
            }
        }


    }

    private void sendTurnoutStateChanged() { //todo on change send state
        segmentCommander.registerTurnoutStateChangeListener((i, turnoutState, turnoutState1) ->
                sendTurnoutState(i));
    }


    private void turnoutstateRequest(MqttMessage message){ //todo listen on turnout/state for getstate messages


        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new String(message.getPayload()));
        JsonObject obj = element.getAsJsonObject();
        int turnoutID = Integer.parseInt(obj.get("turnoutID").toString());
        sendTurnoutState(turnoutID);
    }
    /*
   sends the requested turnout state to MQTT topic turnout/state
    */
    private void sendTurnoutState(int turnoutID) { //todo check
        TurnoutState state = segmentCommander.getTurnoutState(turnoutID);


        if (state.equals(TurnoutState.STRAIGHT)) {
            try {
                String message = "{\"turnoutID\":" + turnoutID + ",\"state\":\"straight\"}\")";
                myClient.publish("turnout/state", new MqttMessage(message.getBytes()));

            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
        if (state.equals(TurnoutState.DIVERGENT)) {
            try {
                String message = "{\"turnoutID\":" + turnoutID + ",\"state\":\"divergent\"}\")";
                myClient.publish("turnout/state", new MqttMessage(message.getBytes()));

            } catch (MqttException e) {
                e.printStackTrace();
            }
        }


    }

    private void sendCommandToMoDeS3(JsonObject message, String topic) {

        if (topic.equals("segment")) {
            elementCommander.sendSegmentCommand(Integer.valueOf(message.get("segment").toString()),
                    getSegmentState(message, "state"));
            elementCommander.sendSegmentCommand(Integer.valueOf(message.get("segment2").toString()),
                    getSegmentState(message, "state2"));
        }

//        if (topic.equals("segmentAll")) {
//            for (int i = 1; i <= 31; i++) {
//
//                if (i == 16 || i == 3 || i == 9 || i == 14 || i == 21 || i == 25 || i == 28) {
//                } else {
//                    elementCommander.sendSegmentCommand(i, getSegmentStateAll(message));
//                }
//            }
//        }
    }


    /*
    return which command to send based on tag
    example, message comes state 1, then the command to modes is segment enabled
     */
    private SegmentState getSegmentState(JsonObject message, String tag) {
        if (message.get(tag).toString().equals("0"))
            return SegmentState.DISABLED;
        if (message.get(tag).toString().equals("1"))
            return SegmentState.ENABLED;
        return null;
    }


}