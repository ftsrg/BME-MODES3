package hu.bme.mit.inf.master.mqttclient;

import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {

	public static void main(String[] args) throws MqttException {
		Logger logger = Logger.getLogger(Class.class.getName());
		
		Map<String, String> env = System.getenv();
		if (!env.containsKey("TURNOUT_ID")) {
			logger.info("No TURNOUT_ID environmental variable is set.");
		}
		
		MqttAsyncClient client = new MqttAsyncClient("tcp://127.0.0.1", "test");
		client.setCallback(new MessageHandler());
		client.connect();
	}

}
