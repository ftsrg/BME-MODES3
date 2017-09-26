package hu.bme.mit.inf.modes3.components.trackelementstatus

import hu.bme.mit.inf.modes3.components.trackelementstatus.json.JsonDispatcherFactory
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import org.slf4j.impl.SimpleLoggerFactory

class Main {
	def static void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory

		val segmentTopic = "segmenttopic"
		val turnoutTopic = "turnouttopic"

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
			new ArgumentDescriptorWithParameter(segmentTopic, "Topic to be used for segment statuses", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter(turnoutTopic, "Topic to be used for turnout statuses", String))

		registry.parseArguments(args)

		val railwayTrackCommunicationStack = MessagingServiceFactory::createMQTTStack(registry, loggerFactory)
		val segmentCommunicationStack = JsonDispatcherFactory::createMQTTStackWithJSON(registry, loggerFactory,
			segmentTopic)
		val turnoutCommunicationStack = JsonDispatcherFactory::createMQTTStackWithJSON(registry, loggerFactory,
			turnoutTopic)

		val component = new TrackSupervisor(railwayTrackCommunicationStack, segmentCommunicationStack,
			turnoutCommunicationStack, loggerFactory)
		component.run // run on main thread
	}
}
