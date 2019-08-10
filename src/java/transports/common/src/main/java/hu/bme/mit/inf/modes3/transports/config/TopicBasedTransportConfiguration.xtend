package hu.bme.mit.inf.modes3.transports.config

import org.eclipse.xtend.lib.annotations.Data

/**
 * The configuration parameter of the transport layer.
 * 
 * @author benedekh
 */
@Data
class TopicBasedTransportConfiguration extends TransportConfiguration {
	String topic
}
