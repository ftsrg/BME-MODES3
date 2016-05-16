package hu.bme.mit.inf.mqtt.common.network;

import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * A filter so that implementation will only handle the messages which arrive on
 * the topic it subscribed for.
 *
 * @author benedekh, hegyibalint
 */
public interface MessageFilter {

    /**
     * A message has arrived for the topic the class is subscribed.
     *
     * @param message the MQTT Message arrived on the topic
     */
    public void filteredMessageArrived(MqttMessage message);
}
