package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.slf4j.ILoggerFactory

/**
 * A topic-based transport layer.
 * 
 * @author benedekh
 */
abstract class TopicBasedTransport extends Transport {

	protected val TopicBasedTransportConfiguration config

	@Deprecated
	new(TransportConfiguration config) {
		super(config)
		this.config = null
	}

	/**
	 * @param config the configuration parameters of the transport layer
	 */
	new(TopicBasedTransportConfiguration config) {
		super(config)
		this.config = config
	}
	
	/**
	 * @param config the configuration parameters of the transport layer
	 * @param loggerFactory the logger factory
	 */
	new(TopicBasedTransportConfiguration config, ILoggerFactory loggerFactory){
		this(config)
	}

	/**
	 * Subscribe to the topic.
	 */
	def void subscribe()

	/**
	 * Unsubscribe from the topic.
	 */
	def void unsubscribe()

	/**
	 * @return the topic the transport layer
	 */
	def getTopic() {
		config.topic
	}
	
	/**
	 * @return the configuration parameter of the transport layer
	 */
	override toString() {
		'''«config»'''
	}
}
