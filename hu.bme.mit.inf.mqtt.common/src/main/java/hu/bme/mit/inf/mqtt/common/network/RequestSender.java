package hu.bme.mit.inf.mqtt.common.network;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public abstract class RequestSender implements MqttCallback, MessageFilter {

    protected final MQTTPublisherSubscriber mqtt;
    protected final String topic;

    public RequestSender(String topic, MQTTPublisherSubscriber mqtt) throws MqttException {
        this.topic = topic;
        this.mqtt = mqtt;
        this.mqtt.subscribe(this.topic, this);
    }

    public void publishMessage(Object object) {
        mqtt.publish(object, topic);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        if (topic.equals(this.topic)) {
            filteredMessageArrived(message);
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
