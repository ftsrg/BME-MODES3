package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessageToTopicMapper
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutStateMessage
import hu.bme.mit.inf.modes3.utils.conf.layout.LayoutConfiguration
import java.util.Collection
import java.util.Set

import static extension hu.bme.mit.inf.modes3.utils.common.extensions.SetExtensions.asStringSet

abstract class TopicFactory {

	private static val SUPPORTED_SEGMENT_MESSAGE_TYPES = #{SegmentStateMessage, SegmentOccupancyMessage, SegmentCommand}
	private static val SUPPORTED_TURNOUT_MESSAGE_TYPES = #{TurnoutStateMessage, TurnoutCommand}

	protected static val SEGMENT_IDS = LayoutConfiguration.INSTANCE.segments

	protected new() {
	}

	/**
	 * @return every possible topic, with the topic parameters being substituted. 
	 * 
	 * E.g. for every section status topic the {id} will be substituted with the respective section's ID.
	 *   
	 * WARNING: many topics!
	 */
	def static createEveryTopic() {
		val topics = createEveryUnparametrizedTopic
		val turnoutTopics = createTurnoutTopics
		val segmentTopics = createSegmentTopics
		topics.addAll(turnoutTopics)
		topics.addAll(segmentTopics)
		return topics
	}

	/**
	 * @return every possible topic, with the topic parameters being substituted, except those whose name is contains a fragment denoted by argument
	 * 
	 * E.g. for every section status topic the {id} will be substituted with the respective section's ID.
	 *   
	 * WARNING: many topics!
	 */
	def static createEveryTopicExcept(String... excludedTopicFragments) {
		createEveryTopic.filter[topic|excludedTopicFragments.forall[!topic.contains(it)]].toSet
	}

	/**
	 * @return the default topics which are not assigned to any InternalMessage
	 */
	def static createDefaultTopics() {
		return InternalMessageToTopicMapper.INSTANCE.getTopics("default")
	}

	/**
	 * @return every topic which does not have any parameter. Note: parameters in topic names should begin with an opening curly bracket ({).
	 */
	def static createEveryUnparametrizedTopic() {
		InternalMessageToTopicMapper.INSTANCE.topics.filter[!contains("{")].toSet
	}

	/**
	 * @return creates every topic for the turnout-related messages for every turnout, and substitutes the {id} parameters in the topic names
	 * 
	 * WARNING: many topics!
	 */
	def static createTurnoutTopics() {
		val turnoutIds = LayoutConfiguration.INSTANCE.turnoutIds
		return turnoutIds.map[createTurnoutTopics(it)].flatten.toSet
	}

	/**
	 * @return creates every topic for the turnout-related messages for the referred turnout, and substitutes the {id} parameters in the topic names
	 */
	def static createTurnoutTopics(int turnoutId) {
		return createTopicsBySupportedMessageTypes(#{turnoutId}, SUPPORTED_TURNOUT_MESSAGE_TYPES, SUPPORTED_TURNOUT_MESSAGE_TYPES)
	}

	/**
	 * @return creates topics only for the selected turnout-related messages for the referred turnout, and substitutes the {id} parameters in the topic names
	 * Supported message types: TurnoutStateMessage, TurnoutCommand
	 */
	def static createTurnoutTopics(int turnoutId, Collection<? extends Class<? extends InternalMessage>> chosenMessageTypes) {
		return createTopicsBySupportedMessageTypes(#{turnoutId}, SUPPORTED_TURNOUT_MESSAGE_TYPES, chosenMessageTypes)
	}

	/**
	 * @return creates every topic for the segment-related messages for every segment, and substitutes the {id} parameters in the topic names
	 */
	def static createSegmentTopics() {
		return createSegmentTopics(SEGMENT_IDS)
	}

	/**
	 * @return creates every topic for the segment-related messages for the referred segments, and substitutes the {id} parameters in the topic names
	 */
	def static createSegmentTopics(Set<Integer> segmentIds) {
		return createSegmentTopics(segmentIds, SUPPORTED_SEGMENT_MESSAGE_TYPES)
	}

	/**
	 * @return creates topics only for the selected segment-related messages for every segment, and substitutes the {id} parameters in the topic names
	 *  Supported message types: SegmentStateMessage, SegmentOccupancyMessage, SegmentCommand
	 */
	def static createSegmentTopics(Collection<? extends Class<? extends InternalMessage>> chosenMessageTypes) {
		return createSegmentTopics(SEGMENT_IDS, chosenMessageTypes)
	}

	/**
	 * @return creates topics only for the selected segment-related messages for the referred segments, and substitutes the {id} parameters in the topic names
	 * Supported message types: SegmentStateMessage, SegmentOccupancyMessage, SegmentCommand
	 */
	def static createSegmentTopics(Set<Integer> segmentIds, Collection<? extends Class<? extends InternalMessage>> chosenMessageTypes) {
		return createTopicsBySupportedMessageTypes(segmentIds, SUPPORTED_SEGMENT_MESSAGE_TYPES, chosenMessageTypes)
	}

	/**
	 * 
	 * @param messageType MessageType whose topic parameters will get substituted
	 * 
	 * @param substitutions values which shall be substituted into the parameters. Note: by default the {id} parameters will be substituted only
	 * 
	 * @return topics for the specified message type, with having the topic parameters substituted.
	 * E.g. for every section status topic the {id} will be substituted with the respective section's ID.  
	 * 
	 * WARNING: many topics!
	 */
	protected def static createTopicsWithSubstitutedParameters(Class<? extends InternalMessage> messageType, Set<String> substitions) {
		val topicsWithRawParameters = InternalMessageToTopicMapper.INSTANCE.getTopics(messageType)
		return substituteTopicIdParametersWithValues(topicsWithRawParameters, substitions)
	}

	private def static createTopicsBySupportedMessageTypes(Set<Integer> substitionIds, Collection<? extends Class<? extends InternalMessage>> supportedMessageTypes, Collection<? extends Class<? extends InternalMessage>> chosenMessageTypes) {
		val everyMessageTypeIsSupported = chosenMessageTypes.forall[supportedMessageTypes.contains(it)]
		if(everyMessageTypeIsSupported) {
			return chosenMessageTypes.map[createTopicsWithSubstitutedParameters(it, substitionIds.asStringSet)].flatten.toSet
		} else {
			throw new IllegalArgumentException('''Some message types are not supported by this operation. Supported message types: «supportedMessageTypes»; Chosen message types: «chosenMessageTypes»''')
		}

	}

	private def static substituteTopicIdParametersWithValues(Set<String> parametrizedTopics, Set<String> substitutions) {
		return parametrizedTopics.map[parametrizedTopic|substitutions.map[parametrizedTopic.replace("{id}", it)]].flatten.toSet
	}

}
