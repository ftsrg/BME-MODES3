package hu.bme.mit.inf.modes3.components.safetylogic.sc.network.factory;

import org.slf4j.ILoggerFactory;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageDispatcher;
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.transports.common.LocalTransport;
import hu.bme.mit.inf.modes3.transports.config.loaders.ArgumentBasedTransportConfigurationLoader;
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport;

public class YakinduCommunicationStackFactory {

	public static CommunicationStack createLocalStack(ILoggerFactory factory) {
		return new YakinduCommunicationStack(new MessagingService(factory), new LocalTransport());
	}

	public static CommunicationStack createLocalStack(YakinduMessageDispatcher dispatcher, ILoggerFactory factory) {
		return new YakinduCommunicationStack(new MessagingService(factory), new LocalTransport(), dispatcher);
	}

	public static CommunicationStack createProtobufStack(ArgumentRegistry argumentRegistry, ILoggerFactory factory) {
		return new YakinduCommunicationStack(new MessagingService(factory),
				new ZMQTransport(ArgumentBasedTransportConfigurationLoader.loadConfiguration(argumentRegistry)));
	}

	public static CommunicationStack createProtobufStack(ArgumentRegistry argumentRegistry, YakinduMessageDispatcher dispatcher, ILoggerFactory factory) {
		return new YakinduCommunicationStack(new MessagingService(factory),
				new ZMQTransport(ArgumentBasedTransportConfigurationLoader.loadConfiguration(argumentRegistry)), dispatcher);
	}
}
