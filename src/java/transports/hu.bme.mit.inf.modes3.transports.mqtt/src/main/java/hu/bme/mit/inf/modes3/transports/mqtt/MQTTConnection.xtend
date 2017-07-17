package hu.bme.mit.inf.modes3.transports.mqtt

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import java.util.concurrent.LinkedBlockingQueue
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.slf4j.Logger

class MQTTConnection implements MqttCallback {

	val DEFAULT_QOS = 1
	val DEFAULT_TOPIC = "/modes3/all"

	val Logger logger
	val TransportConfiguration configuration
	val LinkedBlockingQueue<byte[]> messages
	var MqttAsyncClient client;
	
	new(TransportConfiguration configuration, Logger logger, LinkedBlockingQueue<byte[]> messages) {
		this.configuration = configuration
		this.logger = logger
		this.messages = messages
	}

	def connect() {
		logger.debug('''Connection attempt to: «configuration.addr»:«configuration.port»''')
		client = new MqttAsyncClient(
			'''tcp://«configuration.addr»''',
			configuration.id
		)
		client.callback = this
		
		val options = new MqttConnectOptions();
		options.maxInflight = 100
		
		while (!client.connected) {
			try {
				client.connect(options).waitForCompletion(1000 * 60 * 5);
				logger.info('''MQTT transport is connected to «this.configuration.addr»''')
			} catch (Exception e) {
				e.printStackTrace()
				Thread.sleep(2500);	
			}
		} 
		
		client.subscribe(DEFAULT_TOPIC, 1).waitForCompletion(5000);
		logger.info('''MQTT transport is subscribed to «DEFAULT_TOPIC»''')
	}
	
	def close() {
		client?.disconnect().waitForCompletion()
		client = null
	}
	
	def send(byte[] message) {
		if (client.connected)
			client.publish(DEFAULT_TOPIC, message, DEFAULT_QOS, false)
	}

	override connectionLost(Throwable cause) {
		logger.info('''MQTT connection lost with cause: «cause»''')
		Thread.sleep(1000)
		client.connect()
	}

	override deliveryComplete(IMqttDeliveryToken token) {
		// Intentionally left blank
	}

	override messageArrived(String topic, MqttMessage message) throws Exception {
		messages.put(message.payload);
	}

}
