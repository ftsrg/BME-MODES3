package hu.bme.mit.inf.modes3.transports.mqtt

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import java.util.concurrent.LinkedBlockingQueue
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.slf4j.Logger
import java.util.UUID

class MQTTConnection implements MqttCallback {

	val DEFAULT_QOS = 1
	val DEFAULT_TOPIC = "/modes3/all"

	val Logger logger
	var TransportConfiguration configuration
	val String topic
	val LinkedBlockingQueue<byte[]> messages
	var MqttAsyncClient client;

	new(TransportConfiguration configuration, Logger logger, LinkedBlockingQueue<byte[]> messages) {
		this.configuration = configuration
		this.logger = logger
		this.messages = messages

		val configurationTopic = configuration.topic
		this.topic = if(configurationTopic.isNullOrEmpty) DEFAULT_TOPIC else configurationTopic
	}

	def connect() {
		logger.debug('''Connection attempt to: «configuration.addr»:«configuration.port»''')
		val generatedId = '''«configuration.id»«UUID.randomUUID.toString»'''
		client = new MqttAsyncClient(
			'''tcp://«configuration.addr»''',
			generatedId
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
				Thread.sleep(2500)
			}
		}

		client.subscribe(topic, 1).waitForCompletion(5000);
		logger.info('''MQTT transport is subscribed to «topic»''')
	}

	def close() {
		client?.disconnect().waitForCompletion()
		client = null
	}

	def send(byte[] message) {
		if (client.connected) {
			val topic = if(!configuration.topic.isNullOrEmpty) configuration.topic else DEFAULT_TOPIC
			client.publish(topic, message, DEFAULT_QOS, false)
		}
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
		if (this.topic == topic) {
			messages.put(message.payload)
		}
	}

}
