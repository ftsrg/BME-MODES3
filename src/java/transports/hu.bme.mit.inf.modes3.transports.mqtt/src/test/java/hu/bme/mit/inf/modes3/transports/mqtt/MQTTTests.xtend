package hu.bme.mit.inf.modes3.transports.mqtt

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.helpers.NOPLoggerFactory

// FIXME: Redo the local testing of the MQTT

class MQTTTests {

	var MQTTTransport sender
	var MQTTTransport receiver

	@Before
	def void init() {
		val senderConfig = new TransportConfiguration("MQTT-TEST-SENDER", "root.modes3.intra", 1883)
		sender = new MQTTTransport(senderConfig, new NOPLoggerFactory)
		sender.connect
		println("Sender connected")

		val receiverConfig = new TransportConfiguration("MQTT-TEST-RECEIVER", "root.modes3.intra", 1883)
		receiver = new MQTTTransport(receiverConfig, new NOPLoggerFactory)
		receiver.connect
		println("Receiver connected")
	}

	@After
	def void close() {
		sender.close
		receiver.close
	}

	@Test
	def void messageTests() {
		// Arrange
		val message = "Hello World!"

		// Act
		sender.sendMessage(message.bytes)
		println("Sender sent message")

		// Assert
		println("Receiving...")
		val receivedMessage = new String(receiver.receiveMessage)
		println("Received")
		Assert.assertEquals(message, receivedMessage)
	}

}
