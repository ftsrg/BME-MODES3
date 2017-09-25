package hu.bme.mit.inf.modes3.transports.common

import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration

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

	def void subscribe()

	def void unsubscribe()
}
