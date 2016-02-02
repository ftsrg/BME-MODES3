package hu.bme.mit.inf.master.mqttclient;

import java.util.logging.Logger;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MessageHandler implements MqttCallback {

	public void connectionLost(Throwable cause) {
		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.info("Connection lost");
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		
	}

}
