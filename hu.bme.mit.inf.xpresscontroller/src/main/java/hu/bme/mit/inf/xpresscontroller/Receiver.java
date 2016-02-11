package hu.bme.mit.inf.xpresscontroller;

import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import hu.bme.mit.inf.xpresscontroller.jsontypes.Root;

public class Receiver implements MqttCallback {
	static Logger logger = Logger.getLogger(Receiver.class.getName());
	
	Controller controller;
	
	public static void main(String[] args) throws InterruptedException, MqttException  {
		Receiver main = new Receiver();
		while(true) {
			Thread.sleep(5000);
		}
	}

	public Receiver() throws InterruptedException, MqttException {
		
		controller = new Controller();
		controller.init();

		MqttClient mqttClient = new MqttClient("tcp://localhost:1883", "dccControl");
		mqttClient.setCallback(this);

		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		connOpts.setUserName("controller");
		connOpts.setPassword("password".toCharArray());
		mqttClient.connect(connOpts);
		
		logger.info("MQTT connected");

		mqttClient.subscribe("modes3/dcc");
	}

	public void connectionLost(Throwable cause) {
		logger.info("MQTT connection lost");
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		logger.info("MQTT message arrived");
		String jsonRaw = new String(message.getPayload());
		
		Gson gson = new Gson();
		Root root = gson.fromJson(new String(message.getPayload()), Root.class);
		
		if (root.getTrain() != null) {
			int id = root.getTrain().getId();
			double speed = root.getTrain().getSpeed();
			
			for (Train t : Train.values()) {
				if (t.getAddress() == id) {
					controller.setSpeed(t, speed);
				}
			}
		}
	}

	public void deliveryComplete(IMqttDeliveryToken token) {

	}

}
