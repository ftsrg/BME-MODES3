package hu.bme.mit.inf.modes3.transports.mqtt

import hu.bme.mit.inf.modes3.transports.common.TopicBasedTransport
import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.mqtt.connection.MQTTConnection
import hu.bme.mit.inf.modes3.transports.mqtt.connection.MQTTConnectionLookup
import java.util.concurrent.LinkedBlockingQueue
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import org.slf4j.impl.SimpleLoggerFactory

class MQTTTransport extends TopicBasedTransport {

	val Logger logger
	val MQTTConnection connection
	var LinkedBlockingQueue<byte[]> messages

	new(TopicBasedTransportConfiguration config) {
		this(config, new SimpleLoggerFactory)
	}

	new(TopicBasedTransportConfiguration config, ILoggerFactory loggerFactory) {
		super(config)
		this.logger = loggerFactory.getLogger(this.class.name)
		this.connection = MQTTConnectionLookup.INSTANCE.getConnection(config)
	}

	override subscribe() {
		if (messages === null) {
			messages = connection.subscribe(config.topic)
		} else {
			throw new Exception('''«config» is already subscribed for «config.topic»''')
		}
	}

	override unsubscribe() {
		if (messages !== null) {
			connection.unsubscribe(config.topic, messages)
			messages = null
		}
	}

	override sendMessage(byte[] message) {
		connection.send(config.topic, message)
	}

	override connect() {
		connection.connect
	}

	override close() {
		connection.close
	}

	override receiveMessage() {
		messages.take
	}

}
