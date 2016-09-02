package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoint
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints
import org.junit.Test

class TransportTest {
	
	@Test
	def void testTransportConfiguration() {
		val tc = new TransportConfiguration(
			new TransportEndpoint('127.0.0.1', 2312), 
			TransportEndpoints.loadConfig(TransportEndpoints.ActiveConfiguration.INTEGRATION)
		)
		print(tc)
	}
}