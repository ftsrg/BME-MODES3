package hu.bme.mit.inf.modes3.transports.mqtt.connection

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import java.util.Map
import java.util.Set
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.LinkedBlockingQueue
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class MQTTConnection implements MqttCallback {

	static val QOS = 1
	static val MAX_INFLIGHT = 100
	static val CONNECTION_WAIT_FOR_COMPLETION_TIMEOUT = 1000 * 60 * 5
	static val SUBSCRIBE_WAIT_FOR_COMPLETION_TIMEOUT = 1000 * 60 * 5
	static val CONNECTION_LOST_RETRY_TIMEOUT = 1000

	val Logger logger
	val TransportConfiguration configuration
	val Map<String, Set<LinkedBlockingQueue<byte[]>>> postboxesByTopic
	var MqttAsyncClient client

	new(TransportConfiguration configuration, ILoggerFactory loggerFactory) {
		this.logger = loggerFactory.getLogger(this.class.name)
		this.configuration = configuration
		this.postboxesByTopic = new ConcurrentHashMap
	}

	def synchronized connect() {
		if (client === null || !client.connected) {
			logger.debug('''«logMessagePrefix» connection attempt''')
			client = new MqttAsyncClient('''tcp://«configuration.addr»''', configuration.id)
			client.callback = this

			val options = new MqttConnectOptions
			options.maxInflight = MAX_INFLIGHT

			while (!client.connected) {
				try {
					client.connect(options).waitForCompletion(CONNECTION_WAIT_FOR_COMPLETION_TIMEOUT)
					logger.info('''«logMessagePrefix» is connected''')
				} catch (Exception e) {
					logger.error(e.message, e)
					Thread.sleep(2500)
				}
			}
		}
	}

	def subscribe(String topic) {
		var postboxes = postboxesByTopic.get(topic)
		var postbox = new LinkedBlockingQueue<byte[]>

		if (postboxes === null) {
			client.subscribe(topic, QOS).waitForCompletion(SUBSCRIBE_WAIT_FOR_COMPLETION_TIMEOUT)
			postboxes = ConcurrentHashMap.newKeySet
			postboxes.add(postbox)
			postboxesByTopic.put(topic, postboxes)
			logger.info('''«logMessagePrefix» is subscribed to «topic»''')
		} else {
			postboxes.add(postbox)
		}

		return postbox
	}

	def unsubscribe(String topic, LinkedBlockingQueue<byte[]> postbox) {
		val postboxes = postboxesByTopic.get(topic)

		if (postboxes !== null) {
			postboxes.remove(postbox)
			if (postboxes.isEmpty) {
				client.unsubscribe(topic)
				postboxes.remove(topic)
				logger.info('''«logMessagePrefix» is unsubscribed from «topic»''')
			}
		}
	}

	def synchronized close() {
		if (!postboxesByTopic.isEmpty) {
			val subscribedTopics = String.join(", ", postboxesByTopic.keySet)
			logger.warn('''«logMessagePrefix» is not unsubscribed from the following topics: «subscribedTopics»''')
			postboxesByTopic.keySet.forEach[client.unsubscribe(it)]
			logger.warn('''«logMessagePrefix» is unsubscribed from the following topics: «subscribedTopics»''')
		}
		if (client.isConnected) {
			client.disconnect.waitForCompletion
		}
	}

	def send(String topic, byte[] message) {
		if (client.connected) {
			client.publish(topic, message, QOS, false)
		}
	}

	override connectionLost(Throwable cause) {
		logger.info('''«logMessagePrefix» lost connection with cause: «cause»''')
		Thread.sleep(CONNECTION_LOST_RETRY_TIMEOUT)
		connect
	}

	override deliveryComplete(IMqttDeliveryToken token) {
		// Intentionally left blank
	}

	override messageArrived(String topic, MqttMessage message) throws Exception {
		postboxesByTopic.get(topic)?.forEach[it.add(message.payload)]
	}

	private def getLogMessagePrefix() {
		return '''MQTT transport («configuration»)'''
	}

}
