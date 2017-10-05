package hu.bme.mit.inf.modes3.components.trackelementcontroller.app

import hu.bme.mit.inf.modes3.components.trackelementcontroller.TrackElementController
import hu.bme.mit.inf.modes3.components.trackelementcontroller.wrapper.TrackElementControllerWrapper
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import java.net.InetAddress
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	def static void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory
		val logger = loggerFactory.getLogger(Main.name)

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("id", "ID of the turnout", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))

		registry.parseArguments(args);

		val hostname = InetAddress.getLocalHost().getHostName();
		logger.info("Hostname: " + hostname);
		val turnoutID = Integer.valueOf(hostname.split("\\.").get(0).replace('t', ''));

		val communicationStack = MessagingServiceFactory::createStackForEveryTopic(registry, loggerFactory)

		val component = new TrackElementController(turnoutID, loggerFactory)
		val bbb = new TrackElementControllerWrapper(component, communicationStack, loggerFactory)
		bbb.run // run on main thread
	}

}