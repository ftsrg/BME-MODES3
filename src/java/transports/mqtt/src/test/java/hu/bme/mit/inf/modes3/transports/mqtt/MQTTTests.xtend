package hu.bme.mit.inf.modes3.transports.mqtt

import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.helpers.NOPLoggerFactory

/**
 * The test class of {@link MQTTTransport}.
 * 
 * @author benedekh
 */
class MQTTTests {

	var MQTTTransport sender
	var MQTTTransport receiver

	/**
	 * Reinitialize the sender and the receiver before each test. 
	 */
	@Before 
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

	/**
	 * Close the connections after each test.
	 */
	@After
	def void close() {
		sender.close
		receiver.close
	}

	/**
	 * Test the transport by sending a message on it.
	 */
	@Test def void messageTests() {
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
