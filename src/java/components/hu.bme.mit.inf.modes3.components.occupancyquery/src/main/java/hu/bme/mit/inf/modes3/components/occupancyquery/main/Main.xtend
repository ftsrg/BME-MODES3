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
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("cid", "The ID of the component", String))
		registry.parseArguments(args)

		val reader = new UARTReader(loggerFactory)
		val readerThread = new Thread(reader)
		readerThread.start

		val stack = CommunicationStackFactory::createProtobufStack(registry, loggerFactory)
		val query = new SectionOccupancyQueryComponent(stack, reader, loggerFactory)
		val queryThread = new Thread(query)
		queryThread.start
	}
}
