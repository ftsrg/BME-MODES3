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
import hu.bme.mit.inf.modes3.utils.conf.layout.LayoutConfiguration
import hu.bme.mit.inf.modes3.utils.conf.layout.SegmentDirection
import org.slf4j.impl.SimpleLoggerFactory

/**
 * The entry class of the track element controller application.
 * The application is able to enable/disable the sections that are connected to it (physically).
 * It can also switch the direction of the turnouts, that are connected to it.
 * 
 * @author benedekh
 */
class Main {

	/**
	 * The application initializes and starts itself based on the command-line arguments.
	 * @param args command-line arguments
	 */
	def static void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory
		val layout = LayoutConfiguration.INSTANCE

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("id", "ID of the turnout", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))

		registry.parseArguments(args)

		val hostname = registry.getParameterStringValue("id")
		val turnoutID = Integer.valueOf(hostname.split("\\.").head.replace('t', ''))

		val controlledSections = layout.getControlledSections(turnoutID)
		val facingSegment = layout.getTurnoutVicinitySegmentsByDirection(turnoutID, SegmentDirection.FACING)
		val turnoutSegmentItself = layout.getSegmentIdsOfTurnout(turnoutID)

		val sectionTopics = TopicFactory::createSegmentTopics(controlledSections, #{SegmentCommand, SegmentStateMessage})
		val facingSegmentOccupancyTopic = TopicFactory::createSegmentTopics(facingSegment, #{SegmentOccupancyMessage})
		val turnoutOccupancyTopic = TopicFactory::createSegmentTopics(turnoutSegmentItself, #{SegmentOccupancyMessage})

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
