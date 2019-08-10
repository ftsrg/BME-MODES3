package hu.bme.mit.inf.modes3.transports.local

import hu.bme.mit.inf.modes3.transports.common.TopicBasedTransport
import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration
import java.util.Collections
import java.util.HashSet
import java.util.Map
import java.util.Set
import java.util.concurrent.LinkedBlockingQueue
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * A synchronized list based in-memory topic-based transport layer that maintains the connections within the same JVM.
 * Recommended to be used in tests to remove the dependency of an acutal physical transport layer. 
 * 
 * @author benedekh
 */
class TopicBasedLocalTransport extends TopicBasedTransport {

	static val Map<String, Set<TopicBasedLocalTransport>> subscribersByTopic = Collections.synchronizedMap(newHashMap)

	val String topic
	val Logger logger
	val msgs = new LinkedBlockingQueue<byte[]>

	new(TopicBasedTransportConfiguration config, ILoggerFactory loggerFactory) {
		super(config, loggerFactory)
		this.topic = config.topic
		this.logger = loggerFactory.getLogger(this.class.name)
	}

	override subscribe() {
		subscribersByTopic.get(topic).add(this)
		logger.trace('''Subscribed for «topic»''')
	}

	override unsubscribe() {
		subscribersByTopic.get(topic).remove(this)
		logger.trace('''Unsubscribed from «topic»''')
	}

	override connect() {
		var subscribers = subscribersByTopic.get(topic)
		if (subscribers === null) {
			synchronized (subscribersByTopic) {
				subscribers = subscribersByTopic.get(topic)
				if (subscribers === null) {
					subscribers = Collections.synchronizedSet(new HashSet<TopicBasedLocalTransport>)
					subscribersByTopic.put(topic, subscribers)
				}
			}
		}
	}

	override receiveMessage() {
		val msg = msgs.take
		logger.trace('''Message «msg» arrived for topic «topic»''')
		return msg
	}

	override sendMessage(byte[] message) {
		subscribersByTopic.get(topic)?.forEach[msgs.add(message)]
	}

	override close() {
		unsubscribe
	}

}
