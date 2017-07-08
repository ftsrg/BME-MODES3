package hu.bme.mit.inf.modes3.transports.mqtt

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.slf4j.Logger
import java.util.concurrent.LinkedBlockingQueue

class MQTTConnection implements MqttCallback {

	val DEFAULT_QOS = 1
	val DEFAULT_TOPIC = "/modes3/all"

	val Logger logger
	val TransportConfiguration configuration
	val LinkedBlockingQueue<byte[]> messages
	var MqttAsyncClient client;
	
	new(hu.bme.mit.inf.modes3.transports.config.TransportConfiguration configuration, org.slf4j.Logger logger, LinkedBlockingQueue<byte[]> messages) {
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
		
		client.connect().waitForCompletion(1000 * 60 * 5);
		logger.info('''MQTT transport is connected to «this.configuration.addr»''')
		
		client.subscribe(DEFAULT_TOPIC, 1).waitForCompletion(5000);
		logger.info('''MQTT transport is subscribed to «DEFAULT_TOPIC»''')
	}
	
	def close() {
		client?.disconnect().waitForCompletion()
		client = null
	}
	
	def send(byte[] message) {
		if (client.connected)
			client.publish(DEFAULT_TOPIC, message, DEFAULT_QOS, false);
	}

	override connectionLost(Throwable cause) {
		logger.info('''MQTT connection lost with cause: «cause»''');
		Thread.sleep(1000);
		client.connect
	}

	override deliveryComplete(IMqttDeliveryToken token) {
		// Nothing to implement here
	}

	override messageArrived(String topic, MqttMessage message) throws Exception {
		messages.put(message.payload);
	}

}
