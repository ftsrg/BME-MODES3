package hu.bme.mit.inf.modes3.transports.mqtt

import hu.bme.mit.inf.modes3.transports.common.Transport
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import java.util.concurrent.LinkedBlockingQueue
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import org.slf4j.impl.SimpleLoggerFactory

/**
 * Creates a transport over MQTT.
 * 
 * Every MQTTTransport instance Fregisters itself for the {@ref MQTTConnectionBridge} class which stores
 * the MQTT connection.
 * 
 * Everyone who use MQTTTransport in the same JVM will use the same MQTT connection. It is guaranteed by the
 * fact that MQTTConnectionBridge is a singleton class.
 */
class MQTTTransport extends Transport {
	
	MQTTConnection connection;
	Logger logger;
	LinkedBlockingQueue<byte[]> messages = new LinkedBlockingQueue<byte[]>;
	

	/**
	 * Everyone who uses MQTTTransport in the same JVM will uses the same MQTT connection. It is guaranteed by the
	 * fact that MQTTConnectionBridge is a singleton class.
	 * 
	 * The parameter config object's allEndpoints field indicates which endpoints may be brokers.
	 * 
	 * The TransportEndpoint objects' that are stored in allEndpoints indicate the connection parameters to the 
	 * respective remote brokers. Those TransportEndpoint objects' addr and pubPort fields are used only for 
	 * identification. They shall store the address of the broker (without the tcp prefix!) and the pubPort 
	 * should store the port number through which we may connect to the broker. The first successful broker 
	 * connection will be used as a broker.
	 * 
	 * If none of the allEndpoints could be connected, then it starts a broker locally on localhost. The port number
	 * is stored in config.localEndpoint's pubPort field.
	 * 
	 * The client id that will be used for identifying the connection is stored in config.localEndpoint's id field.
	 */
	new(TransportConfiguration config) {
		this(config, new SimpleLoggerFactory)
	}

	new(TransportConfiguration config, ILoggerFactory factory) {
		super(config)
		this.logger = factory.getLogger("MQ");
	}

	override connect() {
		connection = new MQTTConnection(
			this.config, 
			this.logger,
			this.messages
		);
		connection.connect()
	}

	override receiveMessage() {
		messages.take
	}

	override sendMessage(byte[] message) {
		connection.send(message);
	}

	override close() {
		connection.close();
	}

}
