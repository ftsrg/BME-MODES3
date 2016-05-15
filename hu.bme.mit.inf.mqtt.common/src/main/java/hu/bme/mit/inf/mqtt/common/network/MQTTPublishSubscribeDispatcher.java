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

public class MQTTPublishSubscribeDispatcher implements MqttCallback {

    protected final MQTTPublisherSubscriber mqtt;
    protected final Map<String, MessageFilter> subscribedHandlers;

    private final int qos;

    public MQTTPublishSubscribeDispatcher(MQTTConfiguration conf) {
        this.mqtt = new MQTTPublisherSubscriber(conf);
        this.mqtt.setCallback(this);
        this.qos = mqtt.getQOS();
        this.subscribedHandlers = new TreeMap<>();
    }

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

    public void publishMessage(Object object, String topic) {
        mqtt.publish(object, topic);
    }

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
