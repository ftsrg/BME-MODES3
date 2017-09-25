package hu.bme.mit.inf.modes3.messaging.mms

import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessageToTopicMapper
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.TopicBasedTransport
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TopicBasedMessagingService extends MessagingService {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger
	val Set<TopicBasedTransport> transports

	new(TopicBasedTransport transport, AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		super(transport, dispatcher, factory)
		this.logger = factory.getLogger(this.class.name)
		this.transports = newHashSet
	}

	def addTransport(TopicBasedTransport transport) {
		transports.add(transport)
	}

	override start() {
		try {
			transports.forEach [
				it.connect;
				it.subscribe;
				dispatcherThreads.execute(new DispatchThread(it, dispatcher, logger))
			]
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	override sendMessage(Object message) throws IllegalArgumentException{
		switch (message) {
			InternalMessage: {
				var topic = InternalMessageToTopicMapper.INSTANCE.getTopic(message)
				if (topic === null) {
					topic = InternalMessageToTopicMapper.INSTANCE.getTopic("default")
					logger.
						warn('''There is no corresponding topic for message («message»), using default («topic») topic instead.''')
				}
				sendMessage(topic, message)
			}
			default:
				throw new IllegalArgumentException('''Only messages with type «InternalMessage» are supported''')
		}
	}

	def sendMessage(String topic, Object message) throws IllegalArgumentException {
		val rawMessage = dispatcher.convertMessageToRaw(message)
		val transportsWithTopic = transports.filter[it.topic == topic]
		transportsWithTopic.forEach [
			try {
				it.sendMessage(rawMessage)
			} catch (Exception ex) {
				logger.error(ex.message, ex)
			}
		]
		if (transportsWithTopic.isEmpty) {
			logger.warn('''There is no transport with topic («topic») for message («message»)''')
		}
	}

	override stop() {
		try {
			dispatcherThreads.shutdown()

			/**
			 * unsusbscribe should happen before the close, because transports might use the same connection 
			 */
			transports.forEach [
				try {
					it.unsubscribe
				} catch (Exception ex) {
					logger.error(ex.message, ex)
				}
			]
			transports.forEach [
				try {
					it.close
				} catch (Exception ex) {
					logger.error(ex.message, ex)
				}
			]
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}
}
