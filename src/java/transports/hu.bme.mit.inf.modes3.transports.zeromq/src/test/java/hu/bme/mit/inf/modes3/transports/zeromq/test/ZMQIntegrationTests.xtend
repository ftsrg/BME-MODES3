package hu.bme.mit.inf.modes3.transports.zeromq.test

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import java.util.ArrayList
import java.util.Collections
import java.util.List
import org.junit.Test

import static org.junit.Assert.*

class ZMQSenderRunner implements Runnable {

	TransportConfiguration config
	String message

	new(TransportConfiguration config, String message) {
		this.config = config
		this.message = message
	}

	override run() {
		val zmq = new ZMQTransport(this.config)

		zmq.connect
		zmq.sendMessage(message.bytes)
		println('Message sent')
		zmq.close
	}

}

class ZMQReceiverRunner implements Runnable {

	TransportConfiguration config
	List<String> received
	var receiveCount = 0;

	new(TransportConfiguration config, List<String> received) {
		this(config, received, 1)
	}

	new(TransportConfiguration config, List<String> received, int receiveCount) {
		this.config = config
		this.received = received
		this.receiveCount = receiveCount
	}

	override run() {
		val zmq = new ZMQTransport(this.config)

		zmq.connect
		//Thread.sleep(250)
		while(receiveCount > 0) {
			println('Receiving message')
			received.add(new String(zmq.receiveMessage))
			println('Message received')
			receiveCount--;
		}
		zmq.close
	}

}

class ZMQIntegrationTests {

	@Test(timeout=10000)
	def void oneSenderOneReceiver() {

		// Arrange
		println()
		println('1S1R --------------')

		val message = 'Hello, World!'
		val received = Collections.synchronizedList(new ArrayList<String>)

		val endpoints = TransportEndpoints.loadConfig(TransportEndpoints.ActiveConfiguration.INTEGRATION_LOCAL_2)

		val tc1 = new TransportConfiguration(
			endpoints.core.findFirst[it.id == 'integration_test_component1'],
			endpoints
		)
		val tc2 = new TransportConfiguration(
			endpoints.core.findFirst[it.id == 'integration_test_component2'],
			endpoints
		)

		// Act
		val t1 = new Thread(new ZMQSenderRunner(tc1, message))
		t1.start

		val t2 = new Thread(new ZMQReceiverRunner(tc2, received))
		t2.start

		t1.join
		t2.join
		//t1.notify

		// Assert
		assertEquals(1, received.size);
		assertEquals(message, received.get(0));
	}

	@Test(timeout=10000)
	def void oneSenderTwoReceiver() {

		// Arrange
		println()
		println('1S2R --------------')

		val message = 'Hello, World!'
		val received = Collections.synchronizedList(new ArrayList<String>)

		val endpoints = TransportEndpoints.loadConfig(TransportEndpoints.ActiveConfiguration.INTEGRATION_LOCAL_3)

		val tc1 = new TransportConfiguration(
			endpoints.core.findFirst[it.id == 'integration_test_component1'],
			endpoints
		)
		val tc2 = new TransportConfiguration(
			endpoints.core.findFirst[it.id == 'integration_test_component2'],
			endpoints
		)
		val tc3 = new TransportConfiguration(
			endpoints.core.findFirst[it.id == 'integration_test_component3'],
			endpoints
		)

		// Act
		val t1 = new Thread(new ZMQSenderRunner(tc1, message))
		t1.start
		
		val t2 = new Thread(new ZMQReceiverRunner(tc2, received))
		t2.start
		
		val t3 = new Thread(new ZMQReceiverRunner(tc3, received))
		t3.start

		t1.join
		t2.join
		t3.join

		// Assert
		assertEquals(2, received.size);
		assertEquals(message, received.get(0));
		assertEquals(message, received.get(1));
	}

	@Test(timeout=10000)
	def void twoSenderOneReceiver() {

		// Arrange
		println()
		println('2S1R --------------')

		val message = 'Hello, World!'
		val received = Collections.synchronizedList(new ArrayList<String>)

		val endpoints = TransportEndpoints.loadConfig(TransportEndpoints.ActiveConfiguration.INTEGRATION_LOCAL_3)

		val tc1 = new TransportConfiguration(
			endpoints.core.findFirst[it.id == 'integration_test_component1'],
			endpoints
		)
		val tc2 = new TransportConfiguration(
			endpoints.core.findFirst[it.id == 'integration_test_component2'],
			endpoints
		)
		val tc3 = new TransportConfiguration(
			endpoints.core.findFirst[it.id == 'integration_test_component3'],
			endpoints
		)

		// Act
		val t1 = new Thread(new ZMQSenderRunner(tc1, message + '-1'))
		t1.start

		val t2 = new Thread(new ZMQSenderRunner(tc2, message + '-2'))
		t2.start

		val t3 = new Thread(new ZMQReceiverRunner(tc3, received, 2))
		t3.start

		t1.join
		t2.join
		t3.join

		// Assert
		assertEquals(2, received.size);
		assertTrue(received.contains((message + '-1')));
		assertTrue(received.contains((message + '-2')));

	}

}
