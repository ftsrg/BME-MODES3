package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithoutParameter
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import org.slf4j.impl.SimpleLoggerFactory

class Main {

	def static void main(String[] args) {
		val loggerFactory = new SimpleLoggerFactory

		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("cid", "The ID of the component", String))

		val paramName = "notif"
		registry.registerArgumentWithoutOptions(new ArgumentDescriptorWithoutParameter(paramName, "BBB reports only the change notifications."))
		val requiredParams = #{paramName}

		registry.parseArguments(args);

		val communicationStack = CommunicationStackFactory::createProtobufStack(registry, loggerFactory)
		if(registry.hasMandatoryArguments(requiredParams)) {
			val bbb = new BBBComponentWithStateChangeNotifier(registry.getParameterIntegerValue("cid"), communicationStack, loggerFactory)
			bbb.run // run on main thread
		} else {
			val bbb = new BBBComponent(registry.getParameterIntegerValue("cid"), communicationStack, loggerFactory)
			val thread = new Thread(bbb)
			thread.start
		}
	}

}
