package hu.bme.mit.inf.modes3.components.occupancyquery.app

import hu.bme.mit.inf.modes3.components.occupancyquery.OccupancyQuery
import hu.bme.mit.inf.modes3.components.occupancyquery.wrapper.OccupancyQueryWrapper
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	def static final main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("serial", "The serial port used by the SOC", String))
		registry.parseArguments(args)

		val occupancyTopics = TopicFactory::createSegmentTopics.filter[it.contains("occupancy")].toSet
		val communicationStack = MessagingServiceFactory::createStackForTopics(registry, loggerFactory, occupancyTopics)

		val component = new OccupancyQuery(registry, loggerFactory)
		val queryWrapper = new OccupancyQueryWrapper(component, communicationStack, loggerFactory)
		queryWrapper.run
	}
}
