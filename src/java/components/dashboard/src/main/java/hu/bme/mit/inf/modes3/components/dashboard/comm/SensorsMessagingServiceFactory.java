package hu.bme.mit.inf.modes3.components.dashboard.comm;

import java.io.IOException;

import org.slf4j.ILoggerFactory;

import hu.bme.mit.inf.modes3.messaging.mms.TopicBasedMessagingService;
import hu.bme.mit.inf.modes3.transports.config.TopicBasedTransportConfiguration;
import hu.bme.mit.inf.modes3.transports.mqtt.MQTTTransport;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry;

/**
 * A factory that creates a communication stack, where the dispatcher interprets the messages in JSON.
 * 
 * @author zsoltmazlo
 */
public class SensorsMessagingServiceFactory {

	/**
	 * Creates a communication stack, where the transport protocol is MQTT and the message format is JSON.
	 * 
	 * @param argumentRegistry the initialization parameters of the network stack (e.g. MQTT server IP and port)
	 * @param factory the logger factory
	 * @param topic the name of the topic to register on
	 * @return the communication stack
	 * @throws IOException if the communication stack was not initialized due to an error
	 */
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
