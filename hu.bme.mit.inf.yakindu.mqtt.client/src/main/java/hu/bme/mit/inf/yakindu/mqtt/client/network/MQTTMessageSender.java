package hu.bme.mit.inf.yakindu.mqtt.client.network;

import com.google.gson.Gson;
import hu.bme.mit.inf.yakindu.mqtt.client.data.MQTTConfiguration;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.LogManager.logException;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.LogManager.logInfoMessage;

/**
 *
 * @author benedekh
 */
public class MQTTMessageSender implements ISender {

    private MqttAsyncClient client;
    private String topic;
    private int qos;

    public MQTTMessageSender(MQTTConfiguration config) {
        try {
            String address = config.getAddress();
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
