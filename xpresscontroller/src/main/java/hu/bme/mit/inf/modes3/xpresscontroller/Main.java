package hu.bme.mit.inf.modes3.xpresscontroller;

import org.apache.log4j.PropertyConfigurator;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements MqttCallback {

	static Logger log = LoggerFactory.getLogger(Main.class.getName());
	
	Controller controller;
	
	public static void main(String[] args) throws InterruptedException, MqttException  {
		Main main = new Main();
		while(true) {
			Thread.sleep(5000);
		}
	}

	public Main() throws InterruptedException, MqttException {
		PropertyConfigurator.configure("log4j.properties");

		controller = new Controller();
		//c.init();

		MqttClient mqttClient = new MqttClient("tcp://localhost:1883", "dccControl");
		mqttClient.setCallback(this);

		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		connOpts.setUserName("controller");
		connOpts.setPassword("password".toCharArray());
		mqttClient.connect(connOpts);
		
		log.debug("MQTT connected");

		mqttClient.subscribe("modes3/dcc");
	}

	public void connectionLost(Throwable cause) {
		log.debug("MQTT connection lost");
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		log.debug("MQTT message arrived");
		String jsonRaw = new String(message.getPayload());
		
		JSONObject jsonObject = new JSONObject(jsonRaw);
		if (jsonObject.has("train")) {
			JSONObject trainObject = jsonObject.getJSONObject("train");
			int id = trainObject.getInt("id");
			float speed = (float)trainObject.getDouble("speed");
			
			for (Train t : Train.values()) {
				if (t.getAddress() == id) {
					controller.setSpeed(t, speed);
				}
			}
		}
		if (jsonObject.has("turnout")) {
			JSONObject trainObject = jsonObject.getJSONObject("train");
			String id = "T00" + trainObject.getInt("ID");
			boolean straight = trainObject.getBoolean("Straight");
			
			for (Turnout t : Turnout.values()) {
				if (t.getAddress() == id) {
					controller.setTurnout(id, straight);
				}
			}
		}
	}

	public void deliveryComplete(IMqttDeliveryToken token) {

	}

}
