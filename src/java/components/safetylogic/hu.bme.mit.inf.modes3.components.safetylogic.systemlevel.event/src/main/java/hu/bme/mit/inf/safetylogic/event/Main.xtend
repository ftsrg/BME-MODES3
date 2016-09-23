package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	public static def void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory
		
		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("cid", "The ID of the component", String))
		registry.parseArguments(args)

		val sl = new SafetyLogic(CommunicationStackFactory::createProtobufStack(registry, loggerFactory), loggerFactory)
		sl.run // The component will run on the main thread
	}

}
