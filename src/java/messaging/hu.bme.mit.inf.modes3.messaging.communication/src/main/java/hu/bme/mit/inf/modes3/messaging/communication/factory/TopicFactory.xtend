package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessageToTopicMapper
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutStateMessage
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import java.util.Set

class TopicFactory {

	/**
	 * @return every possible topic, without having the topic parameters substituted.
	 */
	def static createEveryTopicWithRawParameters() {
		return InternalMessageToTopicMapper.INSTANCE.topics
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
		createEveryTopicWithRawParameters.filter[!it.contains("{")].toSet
	}

	/**
	 * @return topics for the specified message type, without having the topic parameters substituted.
	 */
	def static createTopicsWithRawParameters(Class<?> messageType) {
		return InternalMessageToTopicMapper.INSTANCE.getTopics(messageType)
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
	def static createTopicsWithSubstitutedParameters(Class<?> messageType, Set<String> substitions) {
		val topicsWithRawParameters = createTopicsWithRawParameters(messageType)
		return substituteTopicIdParametersWithValues(topicsWithRawParameters, substitions)
	}

	/**
	 * @return creates every topic for the turnout related messages for every turnout, and substitutes the {id} parameters in the topic names
	 * 
	 * WARNING: many topics!
	 */
	def static createTurnoutTopics() {
		val turnoutIds = LayoutConfiguration.INSTANCE.turnoutIds
		return turnoutIds.map[createTurnoutTopics(it)].flatten.toSet
	}

	/**
	 * @return creates every topic for the turnout related messages for the referred turnout, and substitutes the {id} parameters in the topic names
	 */
	def static createTurnoutTopics(int turnoutId) {
		val messageTypes = #{TurnoutStateMessage, TurnoutCommand}
		return messageTypes.map[createTopicsWithSubstitutedParameters(it, #{String.valueOf(turnoutId)})].flatten.toSet
	}

	/**
	 * @return creates every topic for the Segment related messages for every segment, and substitutes the {id} parameters in the topic names
	 */
	def static createSegmentTopics() {
		val segmentIds = LayoutConfiguration.INSTANCE.segments
		return segmentIds.map[createSegmentTopics(it)].flatten.toSet
	}

	/**
	 * @return creates every topic for the Segment related messages for the referred segment, and substitutes the {id} parameters in the topic names
	 */
	def static createSegmentTopics(int segmentId) {
		val messageTypes = #{SegmentStateMessage, SegmentOccupancyMessage, SegmentCommand}
		return messageTypes.map[createTopicsWithSubstitutedParameters(it, #{String.valueOf(segmentId)})].flatten.toSet
	}

	private def static substituteTopicIdParametersWithValues(Set<String> parametrizedTopics, Set<String> substitutions) {
		return parametrizedTopics.map[parametrizedTopic|substitutions.map[parametrizedTopic.replace("{id}", it)]].flatten.toSet
	}

}
