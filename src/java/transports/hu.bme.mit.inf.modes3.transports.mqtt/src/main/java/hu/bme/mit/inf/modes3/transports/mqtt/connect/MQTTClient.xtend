package hu.bme.mit.inf.modes3.transports.mqtt.connect

import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import hu.bme.mit.inf.modes3.transports.mqtt.broker.MQTTBroker
import hu.bme.mit.inf.modes3.transports.mqtt.conf.MQTTConfiguration
import hu.bme.mit.inf.modes3.transports.mqtt.util.BooleanHelper
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import hu.bme.mit.inf.modes3.transports.config.TransportEndpoints.ActiveConfiguration

/**
 * The MQTT client which encapsulates the MqttAsyncClient that connects to the remote broker.
 * If none of the remote brokers is available, then it starts a new broker on localhost and stores its reference.
 */
class MQTTClient {

	protected static val NOT_CONNECTED_ERROR_CODE = MqttException.REASON_CODE_CLIENT_NOT_CONNECTED
	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) Logger logger

	protected val String topic
	protected val int qos

	protected MqttAsyncClient client
	protected MQTTBroker localBroker

	/**
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
	new(ILoggerFactory factory, TransportConfiguration transportConfig, String topic, int qos, MqttCallback callback) {
		this.topic = topic
		this.qos = qos
		logger = factory.getLogger(this.class.name)
		initializeConnection(transportConfig, topic, callback)
	}

	private def initializeConnection(TransportConfiguration transportConfig, String topic, MqttCallback callback) {
		val success = new BooleanHelper
		transportConfig.allEndpoints?.core?.forEach [ config |
			{
				// connect to the first possible remote location which has a broker
				if (!success.value) {
					try {
						val mqttConfig = new MQTTConfiguration(config.pubPort, config.addr,
							transportConfig.localEndpoint.id)
						testAndSubscribeToConnection(mqttConfig, topic, callback)
						success.value = true
						logger.info('''Connection successfull to MQTT Broker on «config.addr»:«config.pubPort»''')
					} catch (MqttException ex) {
						if (ex.reasonCode != NOT_CONNECTED_ERROR_CODE) {
							logger.error(ex.message, ex)
						}
					}
				}
			}
		]

		if (!success.value) {
			
			if (transportConfig.allEndpoints.activeConfig != ActiveConfiguration.PRODUCTION) {
				logger.warn('''Connection failed on configured brokers. Connecting to local (127.0.0.1) broker...''')

				try {
					val port = transportConfig.localEndpoint.pubPort
					val address = "127.0.0.1"
					val mqttConfig = new MQTTConfiguration(port, address, transportConfig.localEndpoint.id)

					try {
						// connect to broker on localhost
						testAndSubscribeToConnection(mqttConfig, topic, callback)
						success.value = true
						logger.warn("Connected to the local MQTT broker!")
					} catch (MqttException ex) {
						if (ex.reasonCode != NOT_CONNECTED_ERROR_CODE) {
							logger.error(ex.message, ex)
						}
					}

					if (!success.value) {
						logger.warn('''Connection failed on broker. Connecting to embedded broker...''')
						// create a broker on localhost
						localBroker = new MQTTBroker
						localBroker.startBroker(port)
						// connect to broker on localhost
						testAndSubscribeToConnection(mqttConfig, topic, callback)
					}
				} catch (MqttException ex) {
					logger.error(ex.message, ex)
				}
			} else {
				throw new MqttException(MqttException.REASON_CODE_BROKER_UNAVAILABLE);
			}
		}
	}

	private def testAndSubscribeToConnection(MQTTConfiguration config, String topic, MqttCallback callback) {
		testMqttConnection(config)
		client = createMqttClient(config)
		client.subscribe(topic, qos)
		client.callback = callback
	}

	private def testMqttConnection(MQTTConfiguration config) {
		val client = createMqttClient(config)
		if (!client.isConnected) {
			throw new MqttException(NOT_CONNECTED_ERROR_CODE)
		}
		client.disconnect.waitForCompletion
	}

	private def createMqttClient(MQTTConfiguration config) {
		try {
			val address = config.fullAddress
			val clientId = config.clientId

			val persistence = new MemoryPersistence
			val connOpts = new MqttConnectOptions
			connOpts.maxInflight = 100

			val client = new MqttAsyncClient(address, clientId, persistence)
			client.connect(connOpts)
			Thread.sleep(300)
			client
		} catch (InterruptedException e) {
			logger.error(e.message, e)
			Thread.currentThread.interrupt
		}
	}

	def synchronized sendMessage(byte[] message) {
		try {
			client?.publish(topic, message, qos, false)
		} catch (MqttException ex) {
			logger.error(ex.message, ex)
		} catch (InterruptedException ex) {
			logger.error(ex.message, ex)
			Thread.currentThread.interrupt
		}
	}

	def close() {
		client?.disconnect
		client?.close
		localBroker?.close
	}

}
