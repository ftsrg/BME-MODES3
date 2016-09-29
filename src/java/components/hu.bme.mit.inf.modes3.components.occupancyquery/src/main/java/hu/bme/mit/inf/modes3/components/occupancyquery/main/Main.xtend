package hu.bme.mit.inf.modes3.components.occupancyquery.main

import hu.bme.mit.inf.modes3.components.occupancyquery.SectionOccupancyQueryComponent
import hu.bme.mit.inf.modes3.components.occupancyquery.UARTReader
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	def static final main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("config", "The selected configuration for deployment", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The IP address of the component", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("id", "The ID of the component", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("pubPort", "The publish port for the component", Integer))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("repPort", "The reply port for the component", Integer))
		registry.parseArguments(args)

		val reader = new UARTReader(loggerFactory)
		val readerThread = new Thread(reader)
		readerThread.start

		val stack = CommunicationStackFactory::createMQTTStack(registry, loggerFactory)
		val query = new SectionOccupancyQueryComponent(stack, reader, loggerFactory)
		val queryThread = new Thread(query)
		queryThread.start
	}
}
