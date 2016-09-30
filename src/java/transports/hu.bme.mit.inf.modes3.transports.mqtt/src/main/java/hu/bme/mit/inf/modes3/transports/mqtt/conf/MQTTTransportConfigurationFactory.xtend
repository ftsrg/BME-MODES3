package hu.bme.mit.inf.modes3.transports.mqtt.conf

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoint
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints
import java.util.UUID

class MQTTTransportConfigurationFactory {

	def static createLocalTransportConfig() {
		val localEndpoint = new TransportEndpoint("", UUID.randomUUID.toString, 1883, 0)
		val remoteEndpoints = new TransportEndpoints
		new TransportConfiguration(localEndpoint, remoteEndpoints)
	}
}
