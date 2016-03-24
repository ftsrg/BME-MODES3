package hu.bme.mit.inf.kvcontrol.mqtt.client;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface MessageFilter {
	public void filteredMessageArrived(MqttMessage message); 
}
