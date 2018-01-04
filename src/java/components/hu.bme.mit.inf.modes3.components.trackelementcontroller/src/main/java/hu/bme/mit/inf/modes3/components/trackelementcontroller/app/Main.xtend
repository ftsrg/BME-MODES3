package hu.bme.mit.inf.modes3.components.trackelementcontroller.app

import hu.bme.mit.inf.modes3.components.trackelementcontroller.TrackElementController
import hu.bme.mit.inf.modes3.components.trackelementcontroller.bridge.TrackElementControllerBridge
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory
import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import hu.bme.mit.inf.modes3.utils.conf.SegmentDirection
import java.net.InetAddress
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	def static void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory
		val logger = loggerFactory.getLogger(Main.name)

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("id", "ID of the turnout", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))

		registry.parseArguments(args);

		val hostname = InetAddress.getLocalHost().getHostName();
		logger.info("Hostname: " + hostname);
		val turnoutID = Integer.valueOf(hostname.split("\\.").head.replace('t', ''));
		val controlledSections = LayoutConfiguration.INSTANCE.getControlledSections(turnoutID)
		val facingSegment = LayoutConfiguration.INSTANCE.getTurnoutVicinitySegmentsByDirection(turnoutID, SegmentDirection.FACING)
		val turnoutSegmentItself = LayoutConfiguration.INSTANCE.getSegmentIdsOfTurnout(turnoutID)

		val sectionTopics = controlledSections.map[TopicFactory::createSegmentTopics(it, #{SegmentCommand, SegmentStateMessage})].flatten.toSet
		val facingSegmentOccupancyTopic = facingSegment.map[TopicFactory::createSegmentTopics(it, #{SegmentOccupancyMessage})].flatten.toSet
		val turnoutOccupancyTopic = turnoutSegmentItself.map[TopicFactory::createSegmentTopics(it, #{SegmentOccupancyMessage})].flatten.toSet

		val turnoutTopics = TopicFactory::createTurnoutTopics(turnoutID)
		val defaultTopics = TopicFactory::createDefaultTopics

		val topics = newHashSet
		topics.addAll(turnoutTopics)
		topics.addAll(sectionTopics)
		topics.addAll(defaultTopics)
		topics.addAll(facingSegmentOccupancyTopic)
		topics.addAll(turnoutOccupancyTopic)

		val communicationStack = MessagingServiceFactory::createStackForTopics(registry, loggerFactory, topics)
		val component = new TrackElementController(turnoutID, loggerFactory)
		val bbb = new TrackElementControllerBridge(component, communicationStack, loggerFactory)
		bbb.run // run on main thread
	}

}
