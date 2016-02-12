package hu.bme.mit.inf.mqtt.common.network;

import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import org.eclipse.paho.client.mqttv3.MqttCallback;

/**
 *
 * @author benedekh
 */
public class MQTTPublisherSubscriber {

    private MqttAsyncClient client;
    private String topic;
    private int qos;

    public MQTTPublisherSubscriber(MQTTConfiguration config) {
        try {
            String address = config.getFullAddress();
            String clientId = config.getClientID();

            this.qos = config.getQOS();
            this.topic = config.getTopic();

            MemoryPersistence persistence = new MemoryPersistence();
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            this.client = new MqttAsyncClient(address, clientId, persistence);
            logInfoMessage(getClassName(), "Connecting to broker: " + address);
            this.client.connect(connOpts);
            logInfoMessage(getClassName(), "Connected");
            Thread.sleep(500);
            this.client.subscribe(topic, qos);
            logInfoMessage(getClassName(), "Subscribed");
        } catch (MqttException | InterruptedException ex) {
            logException(getClassName(), ex);
        }
    }

    public void subscribe(MqttCallback callbackHandler) {
        this.client.setCallback(callbackHandler);
    }

    public void publish(Object object) {
        try {
            byte[] payload = new Gson().toJson(object).getBytes();
            client.publish(topic, payload, qos, false);
        } catch (MqttException ex) {
            logException(getClassName(), ex);
        }
    }

    private static String getClassName() {
        return MQTTPublisherSubscriber.class.getName();
    }

}
