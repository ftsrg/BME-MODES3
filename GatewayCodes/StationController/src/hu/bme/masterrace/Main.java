package hu.bme.masterrace;

import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommander;
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander;
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent;
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateSender;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.messaging.mms.TopicBasedMessagingService;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.SimpleLoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main extends AbstractCommunicationComponent {

    static ITrainCommander trainCommander;
    static ITrackElementCommander elementCommander;
    static ITrackElementStateRegistry segmentCommander;
    static ITrackElementStateSender stateSender;
    static IDccCommander dccCommander;
    final static String MQTTSERVERURI ="tcp://192.168.1.150:1883";
    final static Logger Log = Logger.getLogger(Main.class.getName());
    private static FileHandler fh;
    final static ArrayList<Integer> segmentIDs = new ArrayList<>();

    public static void main(String[] args) {

        initLogger();
        Log.info("Station Controller Started");
        init();

        loadSegmentList();

        elementCommander.sendAllStatusCommand();
        SegmentStates segmentStates = new SegmentStates();
        Turnout turnoutStates = new Turnout();
        SegmentOccupancys segmentOccupancys = new SegmentOccupancys();
        Train train = new Train();
    }

    private static void loadSegmentList() {
        for (int i = 1; i <= 31; i++) {
            if (i == 16 || i == 3 || i == 9 || i == 14 || i == 21 || i == 25 || i == 28) {
            } else {
                segmentIDs.add(i);
            }
        }
    }

    private static void initLogger() {
        try {
            fh = new FileHandler("StationControllerLog.log",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
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

        new Main(msgService, new SimpleLoggerFactory());
    }

    Main(MessagingService messagingService, ILoggerFactory factory) {
        super(messagingService, factory);
        trainCommander = locator.getTrainCommander();
        elementCommander = locator.getTrackElementCommander();
        segmentCommander = locator.getTrackElementStateRegistry();
        stateSender = locator.getTrackElementStateSender();
        dccCommander = locator.getDccCommander();
    }

    public void run() {}
}