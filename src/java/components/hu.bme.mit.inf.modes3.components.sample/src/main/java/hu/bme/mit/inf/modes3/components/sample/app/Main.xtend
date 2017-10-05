package hu.bme.mit.inf.modes3.components.sample.app

import hu.bme.mit.inf.modes3.components.sample.SampleComponent
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import org.slf4j.impl.SimpleLoggerFactory
import hu.bme.mit.inf.modes3.components.sample.wrapper.SampleComponentWrapper

class Main {

	def static final main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(
			new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))
		registry.parseArguments(args)

		val stack = MessagingServiceFactory::createStackForEveryTopic(registry, loggerFactory)

		val sampleComponent = new SampleComponent
		val componentWrapper = new SampleComponentWrapper(sampleComponent, stack, loggerFactory)
		componentWrapper.run
	}
}