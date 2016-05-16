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
 * Encapsulates an MQTT Async Client that connects to the MQTT Broker on
 * different topics.
 *
 * Use {@link hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher}
 * instead of this class. Because the Dispatcher encapsulates this class, and
 * enables different handlers to subscribe for different topics. In this way one
 * Async Client will be used by all the subscribers, which is more resource
 * saver than the other way around (using dedicated clients for each topic).
 *
 * @author benedekh
 */
class MQTTPublisherSubscriber {

    // the client which connects to the MQTT Broker
    private MqttAsyncClient client;
    // the QOS of the MQTT Broker
    private int qos;

    // a thread that is used for (re)connecting to the MQTT Broker
    private Thread connectThread;
    // a runnable that is used for (re)connecting to the MQTT Broker
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

    /**
     * @return the QOS of the MQTT Broker
     */
    public int getQOS() {
        return qos;
    }

    /**
     * Sets a callback for the MQTT client. It will receive all the messages
     * that arrive for the different topics, the MQTT Client subscribed for.
     *
     * @param callback that shall be registered
     */
    public synchronized void setCallback(MqttCallback callback) {
        client.setCallback(callback);
    }

    /**
     * Starts a new reconnection session to the MQTT Broker.
     */
    public synchronized void reconnectClient() {
        if (!connectThread.isAlive()) {
            connectThread = new Thread(clientConnectionEstablisher);
            connectThread.start();
        }
    }

    /**
     * Subscribes the client on the referred topics with the referred QOSs.
     *
     * @param topics to be subscribed for
     * @param qosArray the QOSs for the subscriptions
     *
     * @throws MqttException when something wrong happens with the MQTT
     */
    public synchronized void subscribe(String[] topics, int[] qosArray) throws MqttException {
        this.client.subscribe(topics, qosArray);
    }

    /**
     * Publishes a new object on the referred topic.
     *
     * @param object to be published
     * @param topic on which the object will be published
     */
    public synchronized void publish(Object object, String topic) {
        try {
            byte[] payload = new Gson().toJson(object).getBytes();
            client.publish(topic, payload, qos, false);
        } catch (MqttException ex) {
            logException(getClassName(), ex);
            reconnectClient();
        }
    }

    /**
     * Establishes a connection to a MQTT Broker on the referred address with
     * the referred connection options.
     *
     * @param address of the MQTT Broker
     * @param connOpts connection options that shall be used
     */
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
