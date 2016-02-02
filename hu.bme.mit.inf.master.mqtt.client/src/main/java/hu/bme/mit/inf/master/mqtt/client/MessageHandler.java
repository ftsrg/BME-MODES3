package hu.bme.mit.inf.master.mqtt.client;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Section;

public class MessageHandler implements MqttCallback {
	
	private Logger logger = Logger.getLogger(Class.class.getName());
	private List<Section> sections;
	
	public MessageHandler() {
		Map<String, String> env = System.getenv();
		if (!env.containsKey("TURNOUT_ID")) {
			logger.info("No TURNOUT_ID environmental variable is set.");
		}
		if (!env.containsKey("SECTIONS")) {
			logger.info("No TURNOUT_ID environmental variable is set.");
		}
		
		String sectionsIDs[] = env.get("SECTIONS").split(";");
	}
	
	public void connectionLost(Throwable cause) {
		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.info("Connection lost");
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		
	}

}
