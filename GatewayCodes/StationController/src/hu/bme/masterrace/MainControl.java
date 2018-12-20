package hu.bme.masterrace;

import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommandCallback;
import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommander;
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander;
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent;
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateSender;
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.messaging.mms.TopicBasedMessagingService;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.SimpleLoggerFactory;


public class MainControl
        extends AbstractCommunicationComponent {
    public static ITrainCommander trainCommander;
    public static ITrackElementCommander elementCommander;
    public static ITrackElementStateRegistry segmentCommander;
    public static ITrackElementStateSender stateSender;
    public static IDccCommander dccCommander;

    public static void main(String[] args) {
        init();
        MqttController smc = new MqttController(trainCommander, elementCommander, segmentCommander, dccCommander);

        smc.runClient();
    }


    private static void init() {

        ArgumentRegistry registry = new ArgumentRegistry(new SimpleLoggerFactory());
        registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address",
                "The address of the transport server", String.class));
        registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("port",
                "The port used by the transport server", Integer.class));

        registry.parseArguments(new String[]{"-address", "root.modes3.intra", "-port", "1883"});

        TopicBasedMessagingService msgService = MessagingServiceFactory.createStackForTopics(registry,
                new SimpleLoggerFactory(), TopicFactory.createEveryTopic());

        new MainControl(msgService, new SimpleLoggerFactory());
    }

    public MainControl(MessagingService messagingService, ILoggerFactory factory) {
        super(messagingService, factory);
        trainCommander = locator.getTrainCommander();
        elementCommander = locator.getTrackElementCommander();
        segmentCommander = locator.getTrackElementStateRegistry();
        stateSender = locator.getTrackElementStateSender();
        dccCommander = locator.getDccCommander();


    }

    public void run() {

    }
}