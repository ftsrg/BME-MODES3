package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import org.slf4j.impl.SimpleLogger
import org.slf4j.impl.SimpleLoggerFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory

class Main {

	public static def void main(String[] args) {
		System.setProperty(SimpleLogger.LOG_FILE_KEY, "System.out")

//		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "ERROR");

		val loggerFactory = new SimpleLoggerFactory
			
		val registry = new ArgumentRegistry(loggerFactory)
	
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("config", "The configuration used", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("id", "The ID of the component", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))
		registry.parseArguments(args)
		
		val sl = new SafetyLogic(MessagingServiceFactory::createMQTTStack(registry, loggerFactory), loggerFactory)

		sl.run // The component will run on this thread
	}

}
