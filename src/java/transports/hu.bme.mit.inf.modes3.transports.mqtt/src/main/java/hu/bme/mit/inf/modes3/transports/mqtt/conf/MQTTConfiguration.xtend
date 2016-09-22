package hu.bme.mit.inf.modes3.transports.mqtt.conf

class MQTTConfiguration {

	private final String protocol
	private final String clientId
	private final String address
	private final int port

	new(int port, String address, String id) {
		this.protocol = "tcp"
		this.clientId = id
		this.address = address
		this.port = port
	}

	def getClientId() {
		clientId
	}

	def getFullAddress() {
		'''«protocol»://«address»:«port»'''.toString
	}

}
