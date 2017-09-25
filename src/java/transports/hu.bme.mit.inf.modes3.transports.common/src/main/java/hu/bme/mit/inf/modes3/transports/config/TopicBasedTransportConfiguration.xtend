package hu.bme.mit.inf.modes3.transports.config

import org.eclipse.xtend.lib.annotations.Data

@Data
class TopicBasedTransportConfiguration extends TransportConfiguration {
	static val DEFAULT_TOPIC = "/modes3/all"

	String topic

	def getTopic() {
		val transportTopic = if(topic.isNullOrEmpty) DEFAULT_TOPIC else topic
		return transportTopic
	}
}
