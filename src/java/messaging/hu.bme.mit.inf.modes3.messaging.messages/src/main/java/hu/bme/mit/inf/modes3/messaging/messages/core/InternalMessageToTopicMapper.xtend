package hu.bme.mit.inf.modes3.messaging.messages.core

import hu.bme.mit.inf.modes3.utils.common.gson.GsonLoader
import java.util.Collections
import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.annotations.Data

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

	def getTopics(InternalMessage message) {
		getTopics(message.class.simpleName)
	}

	def getTopics(Class<?> messageType) {
		getTopics(messageType.simpleName)
	}

	def getTopics(String messageType) {
		asUnmodifiableSet(mapping.messageToTopicsMap.get(messageType))
	}

	def getTopics() {
		asUnmodifiableSet(mapping.messageToTopicsMap.values.flatten.toSet)
	}

	private def <T> asUnmodifiableSet(Set<T> set) {
		Collections.unmodifiableSet(set)
	}

}
