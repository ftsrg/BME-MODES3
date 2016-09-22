package hu.bme.mit.inf.modes3.transports.mqtt

import hu.bme.mit.inf.modes3.transports.mqtt.conf.MQTTTransportConfigurationFactory
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.helpers.NOPLoggerFactory

class MQTTTests {

	var MQTTTransport sender
	var MQTTTransport receiver

	@Before
	def void init() {
		val senderTransportConfig = MQTTTransportConfigurationFactory::createLocalTransportConfig
		sender = new MQTTTransport(senderTransportConfig, new NOPLoggerFactory)
		sender.connect

		val receiverTransportConfig = MQTTTransportConfigurationFactory::createLocalTransportConfig
		receiver = new MQTTTransport(receiverTransportConfig, new NOPLoggerFactory)
		receiver.connect
	}

	@Test
	def void messageTests() {
		// Arrange
		val message = "Hello World!"

		// Act
		sender.sendMessage(message.bytes)

		// Assert
		val receivedMessage = new String(receiver.receiveMessage)
		Assert.assertEquals(message, receivedMessage)

	}

}
