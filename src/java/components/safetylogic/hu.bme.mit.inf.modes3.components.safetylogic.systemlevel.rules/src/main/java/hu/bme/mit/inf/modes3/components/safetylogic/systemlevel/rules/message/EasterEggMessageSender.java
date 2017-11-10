package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.message;

import java.util.Date;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class EasterEggMessageSender {
	
	public final static String MESSAGE_TOPIC = "modes3/easteregg"; 
	
	public final static int MESSAGE_QoS = 0;
	
	protected MqttClient client;

	private MemoryPersistence persistence;

	private MqttConnectOptions connOpts;
	
	private EasterEggMessageSender() {
		persistence = new MemoryPersistence();
		connOpts = new MqttConnectOptions();
	}
	
	public final static EasterEggMessageSender INSTANCE = new EasterEggMessageSender();
	
	public void initialize(String server, int pubPort, String clientId) {
		try {
			client = new MqttClient(String.format("tcp://%s:%d", server, pubPort), clientId, persistence);
			client.connect(connOpts);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		message = message + " " + new Date(System.currentTimeMillis()).toLocaleString();
		try {
			if(client != null) {
				client.publish(MESSAGE_TOPIC, message.getBytes(), MESSAGE_QoS, false);
			}
		} catch (MqttException e) {
			e.printStackTrace();
			System.err.println(this.getClass().getName() + " failed to publish message: " + e.getMessage());
		}
	}
}
