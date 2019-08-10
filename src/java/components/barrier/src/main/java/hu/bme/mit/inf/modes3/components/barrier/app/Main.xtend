package hu.bme.mit.inf.modes3.components.barrier.app

import hu.bme.mit.inf.modes3.components.barrier.TrackSupervisor
import hu.bme.mit.inf.modes3.components.barrier.bridge.TrackSupervisorBridge
import hu.bme.mit.inf.modes3.components.barrier.comm.json.JsonDispatcherFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import org.slf4j.impl.SimpleLoggerFactory

/**
 * The entry class of the Barrier application.
 * The application supervises the occupancies of the segments that are next to the barrier. Based on the occupancies it sends a 
 * command to the barrier to open / close itself.
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

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))

		registry.parseArguments(args)

		val supervisedSections = #{15, 24}
		val occupancyTopics = TopicFactory::createSegmentTopics(supervisedSections, #{SegmentOccupancyMessage}).toSet
		val railwayTrackCommunicationStack = MessagingServiceFactory::createStackForTopics(registry, loggerFactory, occupancyTopics)

		val barrierCommunicationStack = JsonDispatcherFactory::createMQTTStackWithJSON(registry, loggerFactory)

		val component = new TrackSupervisor(supervisedSections)
		val componentWrapper = new TrackSupervisorBridge(component, railwayTrackCommunicationStack, barrierCommunicationStack, loggerFactory)
		componentWrapper.run // run on main thread
	}
}
