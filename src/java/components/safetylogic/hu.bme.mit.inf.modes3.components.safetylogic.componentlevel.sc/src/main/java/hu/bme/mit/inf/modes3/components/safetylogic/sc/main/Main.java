package hu.bme.mit.inf.modes3.components.safetylogic.sc.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.impl.SimpleLoggerFactory;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.LayoutConfigurationException;
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptor;
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory;

public class Main {

	public static final void main(String[] args) throws IOException, LayoutConfigurationException {
		SimpleLoggerFactory loggerFactory = new SimpleLoggerFactory();

		ArgumentRegistry registry = new ArgumentRegistry(loggerFactory);
		registry.registerArgumentWithOptions(new ArgumentDescriptor<String>("cid", "The ID of the component", String.class));

		String paramName = "tid";
		registry.registerArgumentWithOptions(new ArgumentDescriptor<Integer>(paramName, "The ID of the turnout (1-6)", Integer.class));

		Set<String> requiredParams = new HashSet<>();
		requiredParams.add(paramName);

		registry.parseArguments(args);
		if (!registry.hasMandatoryArguments(requiredParams)) {
			throw new IllegalArgumentException("Required arguments are missing: " + Arrays.asList(requiredParams.toArray(new String[requiredParams.size()])));
		} else {
			int turnoutId = registry.getParameterIntegerValue(paramName);
			String componentName = "turnout" + turnoutId;

			YakinduComponent component = new YakinduComponent(CommunicationStackFactory.createProtobufStack(registry, loggerFactory), loggerFactory);
			component.createStatechartsAndInitializeComponent(componentName, registry);

			Thread thread = new Thread(component);
			thread.start();
		}
	}

}
