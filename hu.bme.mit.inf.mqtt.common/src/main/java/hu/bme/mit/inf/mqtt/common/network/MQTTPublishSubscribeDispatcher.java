package hu.bme.mit.inf.mqtt.common.network;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * This class encapsulates an MQTTPublisherSubscriber, for which different
 * subscribers can subscribe on different topics. Only one subscribes is allowed
 * per topic.
 *
 * This encapsulation is necessary, so the MQTT implementation will not use as
 * much resource (computation CPU, memory) as it would if every MQTT connection
 * would be done on separate MQTTPublisherSubscribers.
 *
 * @author benjo
 */
public class MQTTPublishSubscribeDispatcher implements MqttCallback {

    // the common subscriber that is used for MQTT
    protected final MQTTPublisherSubscriber mqtt;

    // stores the subscribed topics and their handlers
    protected final Map<String, MessageFilter> subscribedHandlers;

    // the QOS of the MQTT Broker
    private final int qos;

    /**
     * @param conf an MQTT Configuration that stores the connection details
     */
    public MQTTPublishSubscribeDispatcher(MQTTConfiguration conf) {
        this.mqtt = new MQTTPublisherSubscriber(conf);
        this.mqtt.setCallback(this);
        this.qos = mqtt.getQOS();
        this.subscribedHandlers = new TreeMap<>();
    }

    /**
     * Subscribes a handler on a topic.
     *
     * @param topic to be subscribed for
     * @param handler that will handle the messages arrive for the subscribed
     * topic
     */
    public void subscribe(String topic, MessageFilter handler) {
        if (!subscribedHandlers.containsKey(topic)) {
            subscribedHandlers.put(topic, handler);
            int arraySize = subscribedHandlers.size();
            int[] qosArray = new int[arraySize];
            Arrays.fill(qosArray, qos);

            try {
                mqtt.subscribe(subscribedHandlers.keySet().toArray(
                        new String[arraySize]), qosArray);
                logInfoMessage(getClass().getSimpleName(),
                        "Subscribed for " + topic);
            } catch (MqttException ex) {
                logException(getClass().getSimpleName(), ex);
            }
        }
    }

    /**
     * Publish a message on the referred topic.
     *
     * @param object to be published on the topic
     * @param topic were to the object to be published
     */
    public void publishMessage(Object object, String topic) {
        mqtt.publish(object, topic);
    }

    /**
     * Choose the message filter, that shall handle the message arrived on the
     * referred topic.
     *
     * @param topic for which a message arrived
     * @param message that shall be handled
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) {
        MessageFilter mf = subscribedHandlers.get(topic);
        if (mf != null) {
            mf.filteredMessageArrived(message);
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        logException(getClass().getName(), new Exception(cause));
        mqtt.reconnectClient();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
    }

}
