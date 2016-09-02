package hu.bme.mit.inf.modes3.transports.zeromq.test

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoint
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints
import org.junit.Test
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport

import static org.junit.Assert.*;

class ZMQIntegrationTests {
	
	@Test
	def testLocalConnection() {
		
		//Arrange
		
		val message = 'Hello, World!'
		val endpoints = TransportEndpoints.loadConfig(TransportEndpoints.ActiveConfiguration.INTEGRATION_LOCAL)
		
		val tc1 = new TransportConfiguration(
			new TransportEndpoint('127.0.0.1', 1001), 
			endpoints
		)
		val tc2 = new TransportConfiguration(
			new TransportEndpoint('127.0.0.1', 1002), 
			endpoints
		)
		
		val zmq1 = new ZMQTransport(tc1)
		val zmq2 = new ZMQTransport(tc1)
		
		
		// Act
		
		zmq1.connect
		zmq2.connect
		
		zmq1.sendMessage(message.bytes)
		val received = new String(zmq2.receiveMessage)
		
		
		// Assert
		
		assertEquals(received, message)
		
	}
	
}