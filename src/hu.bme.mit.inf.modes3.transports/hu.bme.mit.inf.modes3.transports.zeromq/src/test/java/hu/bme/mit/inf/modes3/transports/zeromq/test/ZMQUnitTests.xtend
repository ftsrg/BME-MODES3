package hu.bme.mit.inf.modes3.transports.zeromq.test

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoint
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import org.junit.Test

class ZMQUnitTests {
	
	@Test
	def testZMQTransport() {
		val transportConfig = new TransportConfiguration (
			new TransportEndpoint('127.0.0.1', 1993),
			TransportEndpoints.loadConfig(TransportEndpoints.ActiveConfiguration.PRODUCTION)
		)
		
		val transport = new ZMQTransport(transportConfig)
		transport.connect
	}
}
