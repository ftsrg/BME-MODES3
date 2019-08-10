package hu.bme.mit.inf.modes3.components.occupancyquery.app

import hu.bme.mit.inf.modes3.components.occupancyquery.OccupancyQuery
import hu.bme.mit.inf.modes3.components.occupancyquery.bridge.OccupancyQueryBridge
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import org.slf4j.impl.SimpleLoggerFactory

/**
 * The entry class of the Occupancy Query application.
 * The application receives the occupancies of every segment on the railway track from a sensor and broadcasts these occupancies
 * on the communication network.
 * 
 * @author benedekh
 */
class Main {

	/**
	 * The application initializes and starts itself based on the command-line arguments.
	 * 
	 * @param args the command line arguments
	 */
	def static final main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("serial", "The serial port used by the SOC", String))
		registry.parseArguments(args)

		val occupancyTopics = TopicFactory::createSegmentTopics(#{SegmentOccupancyMessage})
		val communicationStack = MessagingServiceFactory::createStackForTopics(registry, loggerFactory, occupancyTopics)

		val component = new OccupancyQuery(registry, loggerFactory)
		val queryWrapper = new OccupancyQueryBridge(component, communicationStack, loggerFactory)
		queryWrapper.run
	}
}
