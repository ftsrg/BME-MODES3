package hu.bme.mit.inf.xpresscontroller;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
		controller = new Controller();
		//c.init();

		MqttClient mqttClient = new MqttClient("tcp://localhost:1883", "dccControl");
		mqttClient.setCallback(this);

		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);
		connOpts.setUserName("controller");
		connOpts.setPassword("password".toCharArray());
		mqttClient.connect(connOpts);
		
		log.info("MQTT connected");

		mqttClient.subscribe("modes3/dcc");
	}

	public void connectionLost(Throwable cause) {
		log.info("MQTT connection lost");
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		log.info("MQTT message arrived");
		String jsonRaw = new String(message.getPayload());
		
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(jsonRaw, JsonObject.class);
		if (jsonObject.has("train")) {
			JsonObject trainObject = jsonObject.get("train").getAsJsonObject();
			int id = trainObject.get("id").getAsInt();
			float speed = (float)trainObject.get("speed").getAsDouble();
			
			for (Train t : Train.values()) {
				if (t.getAddress() == id) {
					controller.setSpeed(t, speed);
				}
			}
		}
		if (jsonObject.has("turnout")) {
			JsonObject trainObject = jsonObject.get("train").getAsJsonObject();
			String id = "T00" + trainObject.get("ID").getAsInt();
			boolean straight = trainObject.get("Straight").getAsBoolean();
			
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
