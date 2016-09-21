package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptor
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import org.slf4j.LoggerFactory
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	public static def void main(String[] args) {
		val registry = new ArgumentRegistry(new SimpleLoggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptor<String>("cid", "The ID of the component"))
		registry.parseArguments(args);

		val sl = new SafetyLogic(CommunicationStackFactory::createProtobufStack(registry, new SimpleLoggerFactory), LoggerFactory.ILoggerFactory)
		sl.run(); // The component will run on the main thread
	}

}
