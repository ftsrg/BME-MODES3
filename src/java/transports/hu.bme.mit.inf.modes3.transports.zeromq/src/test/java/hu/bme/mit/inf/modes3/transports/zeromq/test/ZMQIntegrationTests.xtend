package hu.bme.mit.inf.modes3.transports.zeromq.test

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoint
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import org.junit.Ignore
import org.junit.Test

import static org.junit.Assert.*

class ZMQIntegrationTests {
	
	@Test
	@Ignore
	def testLocalConnection() {
		
		//Arrange
		
		val message = 'Hello, World!'
		val endpoints = TransportEndpoints.loadConfig(TransportEndpoints.ActiveConfiguration.INTEGRATION_LOCAL)
		
		val tc1 = new TransportConfiguration(
			new TransportEndpoint('127.0.0.1', 9001), 
			endpoints
		)
		val tc2 = new TransportConfiguration(
			new TransportEndpoint('127.0.0.1', 9002), 
			endpoints
		)
		
		val zmq1 = new ZMQTransport(tc1)
		val zmq2 = new ZMQTransport(tc2)
		
		
		// Act
		
		val t1 = new Thread(new Runnable {
			override run() {
				zmq1.connect
			}
		})
		t1.start
		
		val t2 = new Thread(new Runnable {
			override run() {
				zmq2.connect
			}
		})
		t2.start
		
		t1.join
		t2.join
		
		zmq1.sendMessage(message.bytes)
		val received = new String(zmq2.receiveMessage)
		
		
		// Assert
		
		assertEquals(received, message)
		
	}
	
}