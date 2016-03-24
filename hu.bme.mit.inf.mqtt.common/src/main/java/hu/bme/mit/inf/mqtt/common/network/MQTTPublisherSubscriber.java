package hu.bme.mit.inf.mqtt.common.network;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttCallback;

/**
 *
 * @author benedekh
 */
public class MQTTPublisherSubscriber {

    private MqttAsyncClient client;
    private int qos;

    private Thread connectThread;
    private Runnable clientConnectionEstablisher;

    public MQTTPublisherSubscriber(MQTTConfiguration config) {
        try {
            final String address = config.getFullAddress();
            String clientId = config.getClientID();

            qos = config.getQOS();

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

    public int getQOS() {
        return qos;
    }

    public synchronized void setCallback(MqttCallback callback) {
        client.setCallback(callback);
    }

    public synchronized void reconnectClient() {
        if (!connectThread.isAlive()) {
            connectThread = new Thread(clientConnectionEstablisher);
            connectThread.start();
        }
    }

    public synchronized void subscribe(String[] topics, int[] qosArray) throws MqttException {
        this.client.subscribe(topics, qosArray);
    }

    public synchronized void publish(Object object, String topic) {
        try {
            byte[] payload = new Gson().toJson(object).getBytes();
            client.publish(topic, payload, qos, false);
        } catch (MqttException ex) {
            logException(getClassName(), ex);
            reconnectClient();
        }
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
                    int sleepTime = 1000;
                    Thread.sleep(sleepTime);
                }
            }
            logInfoMessage(getClassName(), "Connected");
        } catch (InterruptedException ex) {
            logException(getClassName(), ex);
        }
    }

    private static String getClassName() {
        return MQTTPublisherSubscriber.class.getName();
    }

}
