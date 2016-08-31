package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.junit.Test

class TransportTest {
	
	@Test
	def void testTransportConfiguration() {
		val tc = TransportConfiguration.loadConfig()
		print(tc)
	}
}