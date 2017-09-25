package hu.bme.mit.inf.modes3.transports.mqtt.connection

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import java.util.Map
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.impl.SimpleLoggerFactory

class MQTTConnectionLookup {

	@Accessors(#[PRIVATE_SETTER, PUBLIC_GETTER]) static val MQTTConnectionLookup INSTANCE = new MQTTConnectionLookup

	val ILoggerFactory loggerFactory
	val String id

	val Map<TransportConfiguration, MQTTConnection> connections

	private new() {
		this.connections = new ConcurrentHashMap
		this.loggerFactory = new SimpleLoggerFactory
		this.id = UUID.randomUUID.toString
	}

	def MQTTConnection getConnection(TransportConfiguration configuration) {
		val simplifiedConfiguration = createSimplifiedConfiguration(configuration)

		var connection = connections.get(simplifiedConfiguration)
		synchronized (connections) {
			connection = connections.get(simplifiedConfiguration)
			if (connection === null) {
				connection = new MQTTConnection(configuration, loggerFactory)
				connections.put(simplifiedConfiguration, connection)
			}
		}

		return connection
	}

	private def createSimplifiedConfiguration(TransportConfiguration configuration) {
		new TransportConfiguration(id, configuration.addr, configuration.port)
	}

}
