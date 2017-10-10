package hu.bme.mit.inf.modes3.components.trackelementcontroller.app

import hu.bme.mit.inf.modes3.components.trackelementcontroller.TrackElementController
import hu.bme.mit.inf.modes3.components.trackelementcontroller.wrapper.TrackElementControllerWrapper
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import java.net.InetAddress
import java.util.HashSet
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	def static void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory
		val logger = loggerFactory.getLogger(Main.name)

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("id", "ID of the turnout", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))

		registry.parseArguments(args);

		val hostname = InetAddress.getLocalHost().getHostName();
		logger.info("Hostname: " + hostname);
		val turnoutID = Integer.valueOf(hostname.split("\\.").get(0).replace('t', ''));

		val turnoutTopics = TopicFactory::createTurnoutTopics(turnoutID)
		val controlledSections = LayoutConfiguration.INSTANCE.getControlledSections(turnoutID)
		val sectionTopics = controlledSections.map[TopicFactory::createSegmentTopics(it)].flatten.toSet
		val relevantSectionTopics = sectionTopics.filter[!it.contains("occupancy")].toSet
		val defaultTopics = TopicFactory::createDefaultTopics

		val topics = new HashSet<String>
		topics.addAll(turnoutTopics)
		topics.addAll(relevantSectionTopics)
		topics.addAll(defaultTopics)

		val communicationStack = MessagingServiceFactory::createStackForTopics(registry, loggerFactory, topics)
		val component = new TrackElementController(turnoutID, loggerFactory)
		val bbb = new TrackElementControllerWrapper(component, communicationStack, loggerFactory)
		bbb.run // run on main thread
	}

}
