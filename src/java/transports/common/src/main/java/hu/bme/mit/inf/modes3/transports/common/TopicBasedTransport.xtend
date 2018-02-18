package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.slf4j.ILoggerFactory

abstract class TopicBasedTransport extends Transport {

	protected val TopicBasedTransportConfiguration config

	@Deprecated
	new(TransportConfiguration config) {
		super(config)
		this.config = null
	}

	new(TopicBasedTransportConfiguration config) {
		super(config)
		this.config = config
	}
	
	new(TopicBasedTransportConfiguration config, ILoggerFactory loggerFactory){
		this(config)
	}

	def void subscribe()

	def void unsubscribe()

	def getTopic() {
		config.topic
	}

	override toString() {
		'''«config»'''
	}
}
