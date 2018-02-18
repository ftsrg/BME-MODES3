package hu.bme.mit.inf.modes3.components.dashboard.comm;

import java.io.IOException;

import org.slf4j.ILoggerFactory;

import hu.bme.mit.inf.modes3.messaging.mms.TopicBasedMessagingService;
import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration;
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry;

public class SensorsMessagingServiceFactory {

	public static TopicBasedMessagingService createMQTTStackWithJSON(ArgumentRegistry argumentRegistry,
			ILoggerFactory factory, String topic) throws IOException {
		return new TopicBasedMessagingService(
				new MQTTTransport(loadMQTTConfiguration(argumentRegistry, topic), factory),
				new SensorsJsonDispatcher(factory), factory);
	}

	private static TopicBasedTransportConfiguration loadMQTTConfiguration(ArgumentRegistry registry, String topic)
			throws IOException {
		String address = registry.getParameterStringValue("address");
		String id = registry.getParameterStringValue("id");
		Integer port = registry.getParameterIntegerValue("port");

		return new TopicBasedTransportConfiguration(id, address, port, topic);
		
	}

}
