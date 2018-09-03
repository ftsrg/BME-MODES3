package hu.bme.mit.inf.modes3.transports.mqtt

import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import org.slf4j.helpers.NOPLoggerFactory
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.After
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Test

// FIXME: Redo the local testing of the MQTT
class MQTTTests {

	var MQTTTransport sender
	var MQTTTransport receiver

	@BeforeAll
	def void init() {
		val senderConfig = new TopicBasedTransportConfiguration("MQTT-TEST-SENDER", "root.modes3.intra", 1883, '''''')
		sender = new MQTTTransport(senderConfig, new NOPLoggerFactory)
		sender.connect
		println("Sender connected")

		val receiverConfig = new TopicBasedTransportConfiguration("MQTT-TEST-RECEIVER", "root.modes3.intra", 1883, '''''')
		receiver = new MQTTTransport(receiverConfig, new NOPLoggerFactory)
		receiver.connect
		println("Receiver connected")
	}

	@AfterAll
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
		assertEquals(message, receivedMessage)
	}

}
