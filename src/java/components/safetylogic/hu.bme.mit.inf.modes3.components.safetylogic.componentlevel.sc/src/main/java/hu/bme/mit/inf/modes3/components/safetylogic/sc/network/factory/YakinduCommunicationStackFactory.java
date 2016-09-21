package hu.bme.mit.inf.modes3.components.safetylogic.sc.network.factory;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageDispatcher;
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.transports.common.LocalTransport;
import hu.bme.mit.inf.modes3.transports.config.loaders.ArgumentBasedTransportConfigurationLoader;
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport;

public class YakinduCommunicationStackFactory {

	public static CommunicationStack createLocalStack() {
		return new YakinduCommunicationStack(new MessagingService(), new LocalTransport());
	}

	public static CommunicationStack createLocalStack(YakinduMessageDispatcher dispatcher) {
		return new YakinduCommunicationStack(new MessagingService(), new LocalTransport(), dispatcher);
	}

	public static CommunicationStack createProtobufStack(ArgumentRegistry argumentRegistry) {
		return new YakinduCommunicationStack(new MessagingService(),
				new ZMQTransport(ArgumentBasedTransportConfigurationLoader.loadConfiguration(argumentRegistry)));
	}

	public static CommunicationStack createProtobufStack(ArgumentRegistry argumentRegistry, YakinduMessageDispatcher dispatcher) {
		return new YakinduCommunicationStack(new MessagingService(),
				new ZMQTransport(ArgumentBasedTransportConfigurationLoader.loadConfiguration(argumentRegistry)), dispatcher);
	}
}
