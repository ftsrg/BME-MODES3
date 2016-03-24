package hu.bme.mit.inf.mqtt.common.network;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface MessageFilter {
	public void filteredMessageArrived(MqttMessage message); 
}
