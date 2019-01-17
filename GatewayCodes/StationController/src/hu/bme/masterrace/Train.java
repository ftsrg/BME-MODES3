package hu.bme.masterrace;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection;
import org.eclipse.paho.client.mqttv3.*;

import java.util.concurrent.Semaphore;

import static hu.bme.masterrace.Main.*;

public class Train implements MqttCallback {

    private static final String TOPIC_COMMAND = "command/train";
    private MqttClient myClient;
    private MqttConnectOptions connOpt;
    private String CLIENTID = "SCTrain";
    private Semaphore semaphore = new Semaphore(8);

    Train() {
        try {
            setConnectionOptions();
            connect();
            if (myClient.isConnected()) {
                subscribe();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void subscribe() throws MqttException {
        myClient.subscribe(TOPIC_COMMAND, 1);
    }

    private void connect() throws MqttException {
        myClient = new MqttClient(MQTTSERVERURI, CLIENTID);
        myClient.setCallback(this);
        myClient.connect(connOpt);
        System.out.println("Connected Train Commander!");
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

        if (topic.equals(TOPIC_COMMAND))
            handleTopicCommand(message);
    }

    private void handleTopicCommand(JsonObject message) {

        if (message.has("speed") && message.has("trainID")
                && message.has("direction"))
            sendTrainCommand(message);

    }


    private void sendTrainCommand(JsonObject message) {

        trainCommander.setTrainReferenceSpeedAndDirection(trainNameToInt(message), message.get("speed").getAsInt(),
                getTrainDirection(message));

    }

    /**
     * Don`t touch!
     */
    private int trainNameToInt(JsonObject message) {
        if (message.get("trainID").toString().equals("\"taurus\"")) return 9;
        if (message.get("trainID").toString().equals("\"sncf\"")) return 10;
        if (message.get("trainID").toString().equals("\"piros\"")) return 8;
        return 0;
    }

    private TrainDirection getTrainDirection(JsonObject message) {
        if (message.get("direction").toString().equals("\"forward\""))
            return TrainDirection.FORWARD;
        if (message.get("direction").toString().equals("\"backward\""))
            return TrainDirection.BACKWARD;
        return null;
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        semaphore.release();
    }
}
