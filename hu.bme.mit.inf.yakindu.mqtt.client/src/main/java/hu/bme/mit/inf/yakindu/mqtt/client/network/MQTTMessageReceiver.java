package hu.bme.mit.inf.yakindu.mqtt.client.network;

import hu.bme.mit.inf.yakindu.mqtt.client.data.MQTTConfiguration;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.LogManager.logException;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.LogManager.logInfoMessage;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author benedekh
 */
public class MQTTMessageReceiver {

    private MqttAsyncClient client;
    private String topic;
    private int qos;

    public MQTTMessageReceiver(MQTTConfiguration config,
            MqttCallback callbackHandler) {
        try {
            String address = config.getAddress();
            String clientId = config.getClientID();

            this.qos = config.getQOS();
            this.topic = config.getTopic();

            MemoryPersistence persistence = new MemoryPersistence();
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            this.client = new MqttAsyncClient(address, clientId, persistence);
            this.client.setCallback(callbackHandler);
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

    private String getClassName() {
        return MQTTMessageSender.class.getName();
    }

}
