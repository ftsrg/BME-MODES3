package hu.bme.mit.inf.modes3.components.occupancyquery

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import org.slf4j.impl.SimpleLoggerFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory

class Main {

	def static final main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("config", "The configuration used", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("id", "The ID of the component", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("serial", "The serial port used by the SOC", String))
		registry.parseArguments(args)

		val stack = MessagingServiceFactory::createMQTTStack(registry, loggerFactory)
		val query = new OccupancyQuery(stack, loggerFactory, registry)
		val queryThread = new Thread(query)
		queryThread.run
	}
}
