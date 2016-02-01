package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.logging.LogManager.logInfoMessage;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.logging.LogManager.logException;

/**
 *
 * @author benedekh
 */
public class MQTTMessageSender {

    private MqttAsyncClient client;
    private String topic;
    private int qos;

    public MQTTMessageSender(String topic, int qos, String broker,
            String clientId) {
        try {
            this.qos = qos;
            this.topic = topic;

            MemoryPersistence persistence = new MemoryPersistence();
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            // TODO client.setCallback to handle replies!!
            this.client = new MqttAsyncClient(broker, clientId, persistence);
            logInfoMessage(getClassName(), "Connecting to broker: " + broker);
            this.client.connect(connOpts);
            logInfoMessage(getClassName(), "Connected");
            Thread.sleep(100);
            this.client.subscribe(topic, qos);
            logInfoMessage(getClassName(), "Subscribed");
        } catch (MqttException | InterruptedException ex) {
            logException(getClassName(), ex);
        }
    }

    public void publish(byte[] payload) {
        try {
            client.publish(topic, payload, qos, false);
        } catch (MqttException ex) {
            logException(getClassName(), ex);
        }
    }

    private String getClassName() {
        return MQTTMessageSender.class.getName();
    }

}
