package hu.bme.mit.inf.modes3.components.barrier

import hu.bme.mit.inf.modes3.components.barrier.json.JsonDispatcherFactory
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import org.slf4j.impl.SimpleLoggerFactory

class Main {
	def static void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("barriertopic", "Topic to be used by the barrier controller", String))

		registry.parseArguments(args);

		val railwayTrackCommunicationStack = MessagingServiceFactory::createStackForEveryTopic(registry, loggerFactory)
		val barrierCommunicationStack = JsonDispatcherFactory::createMQTTStackWithJSON(registry, loggerFactory)
		val supervisedSections = #{15, 24}

		val component = new TrackSupervisor(railwayTrackCommunicationStack, barrierCommunicationStack, loggerFactory,
			supervisedSections)
		component.run // run on main thread
	}
}
