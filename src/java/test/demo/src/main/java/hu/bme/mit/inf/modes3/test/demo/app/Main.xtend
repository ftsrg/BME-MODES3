package hu.bme.mit.inf.modes3.test.demo.app

import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import org.slf4j.impl.SimpleLoggerFactory

/**
 * The entry class of the Test application.
 * The test application serve as an example how you can control the model railway track from java.
 * How you can get the statuses of the sections (enabled/disabled), how you can get their occupancies,
 * how you can get the directions of the turnouts (straight/divergent).
 * Moreover you can send commands to the track: enable/disable sections, set the direction of the turnouts,
 * control the locomotives (speed and direction). 
 * 
 * @author benedekh
 */
class Main {
	
	/**
	 * The application initializes and starts itself based on the command-line arguments.
	 * @param args command-line arguments
	 */
	def static final main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))
		registry.parseArguments(args)

		val topics = TopicFactory::createEveryTopic
		val stack = MessagingServiceFactory::createStackForTopics(registry, loggerFactory, topics)
		val testDemo = new TestDemo(stack, loggerFactory)
		testDemo.run
	}
}
