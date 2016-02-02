package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.LogManager.logInfoMessage;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.LogManager.logException;
import org.eclipse.paho.client.mqttv3.MqttCallback;

/**
 *
 * @author benedekh
 */
public class MQTTMessageSender implements ISender {

    private MqttAsyncClient client;
    private String topic;
    private int qos;

    public MQTTMessageSender(String topic, int qos, String broker,
            String clientId, MqttCallback callbackHandler) {
        try {
            this.qos = qos;
            this.topic = topic;

            MemoryPersistence persistence = new MemoryPersistence();
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            this.client = new MqttAsyncClient(broker, clientId, persistence);
            this.client.setCallback(callbackHandler);
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

    @Override
    public void send(Object object) {
        try {
            byte[] payload = new Gson().toJson(object).getBytes();
            client.publish(topic, payload, qos, false);
        } catch (MqttException ex) {
            logException(getClassName(), ex);
        }
    }

    private String getClassName() {
        return MQTTMessageSender.class.getName();
    }

}
