package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	public static def void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory
		
		val registry = new ArgumentRegistry(loggerFactory)
		
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("config", "The selected configuration for deployment", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The IP address of the component", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("id", "The ID of the component", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("pubPort", "The publish port for the component", Integer))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("repPort", "The reply port for the component", Integer))
		registry.parseArguments(args)
//		val sl = new SafetyLogic(CommunicationStackFactory::createProtobufStack(registry, loggerFactory), loggerFactory)
		val sl = new SafetyLogic(CommunicationStackFactory::createMQTTStack(registry, loggerFactory), loggerFactory)

		sl.run // The component will run on this thread
	}

}
