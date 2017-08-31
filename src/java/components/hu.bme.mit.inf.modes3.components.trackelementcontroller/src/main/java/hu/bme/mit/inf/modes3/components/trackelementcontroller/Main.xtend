package hu.bme.mit.inf.modes3.components.trackelementcontroller

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import java.net.InetAddress
import org.slf4j.impl.SimpleLoggerFactory
import hu.bme.mit.inf.modes3.components.trackelementcontroller.controllers.TrackElementController
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory

class Main {

	def static void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory
		val logger = loggerFactory.getLogger(Main.name)

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("config", "The configuration used", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("id", "The ID of the component", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("port", "The oprt used by the transport server", Integer))

		registry.parseArguments(args);

		val hostname = InetAddress.getLocalHost().getHostName();
		logger.info("Hostname: " + hostname);
		val turnoutID = Integer.valueOf(hostname.split("\\.").get(0).replace('t', ''));

		val communicationStack = MessagingServiceFactory::createMQTTStack(registry, loggerFactory)
		
		val bbb = new TrackElementController(turnoutID, communicationStack, loggerFactory)
		bbb.run // run on main thread
	}

}
