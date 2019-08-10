package hu.bme.mit.inf.modes3.messaging.mms

import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessageToTopicMapper
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.yakindu.YakinduProtocolMessage
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.TopicBasedTransport
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/** 
 * A class that connects the transport layer with the dispatcher that dispatches the messages transferred over the transport layer.
 * The messaging service can also send a message through the transport layer.
 * 
 * The class is specialized for topic based transport layers.
 *
 * @author benedekh 
 **/
class TopicBasedMessagingService extends MessagingService {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger
	val Set<TopicBasedTransport> transports
	val Set<String> topics

	/**
	 * @param transport the transport layer
	 * @param dispatcher a dispatcher that dispatches the messages
	 * @param factory the logger factory
	 */
	new(TopicBasedTransport transport, AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		super(transport, dispatcher, factory)
		this.logger = factory.getLogger(this.class.name)
		this.topics = newHashSet
		this.transports = newHashSet
		addTransport(transport)
	}
	
	/**
	 * Adds a new transport layer, so that messages will be also received through this transport.
	 * @param transport the transport layer to be added
	 */
	def addTransport(TopicBasedTransport transport) {
		transports.add(transport)
		topics.add(transport.topic)
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
				val topics = getTopics(message)
				topics.forEach [
					try {
						val topic = getPreparedTopic(message, it)
						sendMessage(topic, message)
					} catch (Exception ex) {
						logger.
							error('''Exception («ex») occurred, before sending the message («message») for topic («it»).''')
					}
				]
			}
			default:
				throw new IllegalArgumentException('''Only messages with type «InternalMessage» are supported''')
		}
	}

	private def getTopics(InternalMessage message) {
		var topics = InternalMessageToTopicMapper.INSTANCE.getTopics(message)
		if (topics === null) {
			topics = InternalMessageToTopicMapper.INSTANCE.getTopics("default")
			logger.
				warn('''There is no corresponding topic for message («message»), using default («topics») topics instead.''')
		}
		return topics
	}

	private def getPreparedTopic(InternalMessage message, String topic) {
		var preparedTopic = topic
		val matchTimes = preparedTopic.split('''\{id\}''', -1).length - 1
		if (matchTimes == 1) {
			val id = getIdField(message)
			preparedTopic = preparedTopic.replace("{id}", String.valueOf(id))
		}
		return preparedTopic
	}

	private def getIdField(InternalMessage message) throws IllegalArgumentException{
		switch (message) {
			TurnoutCommand: message.turnoutId
			TurnoutStateMessage: message.turnoutId
			SegmentCommand: message.segmentId
			SegmentStateMessage: message.segmentId
			SegmentOccupancyMessage: message.segmentId
			YakinduProtocolMessage: message.targetID
			default: throw new IllegalArgumentException('''Message («message») does not contain any ID.''')
		}
	}

	/**
	 * Sends a message for a topic on the transport layer.
	 * The message will be serialized by the dispatcher that is used by the messaging service.
	 * 
	 * @param topic the topic to send the message for
	 * @param message to be sent serialized and sent over the transport layer
	 */
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
