package hu.bme.mit.inf.safetylogic.event.app

import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import hu.bme.mit.inf.safetylogic.event.bridge.SafetyLogicBridge
import hu.bme.mit.inf.safetylogic.event.sl.SafetyLogic
import org.slf4j.impl.SimpleLogger
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	public static def void main(String[] args) {
		System.setProperty(SimpleLogger.LOG_FILE_KEY, "System.out")

//		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "ERROR");
		val loggerFactory = new SimpleLoggerFactory

		val registry = new ArgumentRegistry(loggerFactory)

		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))
		registry.parseArguments(args)

		val topics = TopicFactory::createEveryTopic
		val communicationStack = MessagingServiceFactory::createStackForTopics(registry, loggerFactory, topics)
		
											//Logger   , initializeRailRoad, and useCV
		val safetyLogic = new SafetyLogic(loggerFactory, true,                   true)
		val slWrapper = new SafetyLogicBridge(safetyLogic, communicationStack, loggerFactory)
		slWrapper.run // The component will run on this thread
	}

}
