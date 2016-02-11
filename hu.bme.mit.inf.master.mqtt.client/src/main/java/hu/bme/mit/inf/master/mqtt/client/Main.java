package hu.bme.mit.inf.master.mqtt.client;

import java.io.IOException;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {

	public static void main(String[] args) throws MqttException, IOException {
		MqttAsyncClient client = new MqttAsyncClient("tcp://127.0.0.1", "test");
		client.setCallback(new MessageHandler());
		client.connect();
	}

}
