package hu.bme.mit.inf.modes3.messaging.messages.core

import hu.bme.mit.inf.modes3.components.util.gson.GsonLoader
import java.util.Map
import org.eclipse.xtend.lib.annotations.Data

class InternalMessageToTopicMapper {

	@Data
	private static class MessageToTopicMapper {
		private Map<String, String> messageToTopicMap
	}

	public static val INSTANCE = new InternalMessageToTopicMapper
	private static val MAPPING_CONFIG = "mapping.json"

	private var MessageToTopicMapper mapping

	private new() {
		mapping = GsonLoader.loadTypeFromInputStream(MessageToTopicMapper,
			InternalMessageToTopicMapper.classLoader.getResourceAsStream(MAPPING_CONFIG))
	}

	def getTopic(InternalMessage message) {
		getTopic(message.class.simpleName)
	}

	def getTopic(String messageType) {
		mapping.messageToTopicMap.get(messageType)
	}
	
	def getTopics(){
		mapping.messageToTopicMap.values.toSet
	}

}
