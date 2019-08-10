package hu.bme.mit.inf.modes3.messaging.messages.core

import hu.bme.mit.inf.modes3.utils.common.gson.GsonLoader
import java.util.Collections
import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.annotations.Data

/**
 * Maps each message type to a topic to which the message is usually delivered.
 * Refer to the {@link #MAPPING_CONFIG} source file for the staic mapping.
 * 
 * @author benedekh
 */
class InternalMessageToTopicMapper {

	@Data
	private static class MessageToTopicMapper {
		private Map<String, Set<String>> messageToTopicsMap
	}

	public static val INSTANCE = new InternalMessageToTopicMapper
	private static val MAPPING_CONFIG = "topicMapping.json"

	private var MessageToTopicMapper mapping

	private new() {
		mapping = GsonLoader.loadTypeFromInputStream(MessageToTopicMapper,
			InternalMessageToTopicMapper.classLoader.getResourceAsStream(MAPPING_CONFIG))
	}
	
	/**
	 * @param message the message whose topics are queried
	 * @return the topics on which the message is sent
	 */
	def getTopics(InternalMessage message) {
		getTopics(message.class.simpleName)
	}

	/**
	 * @param messageType the message type whose topics are queried
	 * @return the topics on which the message is sent
	 */
	def getTopics(Class<?> messageType) {
		getTopics(messageType.simpleName)
	}

	/**
	 * @param messageType the message type whose topics are queried
	 * @return the topics on which the message is sent
	 */
	def getTopics(String messageType) {
		asUnmodifiableSet(mapping.messageToTopicsMap.get(messageType))
	}

	/**
	 * @return every topic that is registered
	 */
	def getTopics() {
		asUnmodifiableSet(mapping.messageToTopicsMap.values.flatten.toSet)
	}

	private def <T> asUnmodifiableSet(Set<T> set) {
		Collections.unmodifiableSet(set)
	}

}
