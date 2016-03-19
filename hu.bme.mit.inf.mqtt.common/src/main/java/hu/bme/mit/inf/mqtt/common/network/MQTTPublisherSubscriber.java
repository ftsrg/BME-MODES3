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

    private Thread connectThread;
    private Runnable clientConnectionEstablisher;

    public MQTTPublisherSubscriber(MQTTConfiguration config) {
        try {
            final String address = config.getFullAddress();
            String clientId = config.getClientID();

            qos = config.getQOS();
            topic = config.getTopic();

            MemoryPersistence persistence = new MemoryPersistence();
            final MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            client = new MqttAsyncClient(address, clientId, persistence);

            clientConnectionEstablisher = new Runnable() {
                @Override
                public void run() {
                    establishClientConnection(address, connOpts);
                }
            };
            connectThread = new Thread(clientConnectionEstablisher);
            connectThread.start();
            connectThread.join();
        } catch (MqttException | InterruptedException ex) {
            logException(getClassName(), ex);
        }
    }

    public synchronized void reconnectClient() {
        if (!connectThread.isAlive()) {
            connectThread = new Thread(clientConnectionEstablisher);
            connectThread.start();
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
            reconnectClient();
        }
    }

    public String getSubscribedTopic() {
        return topic;
    }

    private void establishClientConnection(String address,
            MqttConnectOptions connOpts) {
        try {
            while (!client.isConnected()) {
                logInfoMessage(getClassName(),
                        "Connecting to broker: " + address);
                try {
                    client.connect(connOpts);
                } catch (MqttException e) {
                    int sleepTime = 1000 * 10;
                    Thread.sleep(sleepTime);
                }
                logInfoMessage(getClassName(), "Connected");
                Thread.sleep(500);
                client.subscribe(topic, qos);
                logInfoMessage(getClassName(), "Subscribed");
            }
        } catch (MqttException | InterruptedException ex) {
            logException(getClassName(), ex);
        }
    }

    private static String getClassName() {
        return MQTTPublisherSubscriber.class.getName();
    }

}
