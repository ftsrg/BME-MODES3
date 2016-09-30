package hu.bme.mit.inf.modes3.transports.mqtt.broker

import io.moquette.server.Server
import java.util.Properties

class MQTTBroker {

	private final Server broker

	new() {
		broker = new Server
	}

	def startBroker(int port) {
		val prop = new Properties
		prop.put("port", String.valueOf(port))
		prop.put("websocket_port", "8080")
		prop.put("host", "127.0.0.1")
		prop.put("allow_anonymous", "true")

		broker.startServer(prop)
		Thread.sleep(500) // give time for broker to start
	}
	
	def close(){
		broker.stopServer
		Thread.sleep(500) // give time for broker to stop
	}
}
