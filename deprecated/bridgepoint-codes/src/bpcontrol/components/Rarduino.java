package bpcontrol.components;

import hu.bme.mit.inf.bpcontrol.transmitters.GeneralTransmitter;
import interfaces.ICommunicationFromProvider;
import java.io.PrintStream;

import hu.bme.mit.inf.bpcontrol.BPServer;
import hu.bme.mit.inf.bpcontrol.NotifyingThread;
import hu.bme.mit.inf.bpcontrol.transmitters.DistributedMessageTransmitter;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.AbstractRequest;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Allowance;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.PassageRequestSender;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.PassageResponseSender;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.ShortPassageRequestSender;
import hu.bme.mit.inf.kvcontrol.senders.SectionStateRequestSender;
import interfaces.ThreadCompletedListener;
import org.xtuml.bp.core.CorePlugin;

import types.Direction;

public class Rarduino implements ThreadCompletedListener {

    public static final Object BP_SYNC_OBJECT = new Object();

    public static final boolean STATUS_LOG_ENABLED = true;

    private static PrintStream STATUS_LOGGER;
    private static PrintStream ERROR_LOGGER;

    private final ICommunicationFromProvider comm;
    private int turnoutId;

    private GeneralTransmitter generalTransmitter;
    private DistributedMessageTransmitter distributedTransmitter;
    private BPServer bps;

    public Rarduino(ICommunicationFromProvider dest) {
        // save the communicating component's reference
        comm = dest;
    }

    public void initialize(int turnoutId,
            String kvcontrolAddress, int kvcontrolPort,
            String kvcontrolBPExtensionAddress, int kvControlBPExtensionPort) {

        STATUS_LOGGER = CorePlugin.out;
        ERROR_LOGGER = CorePlugin.err;

        STATUS_LOGGER.println("Initializing realized component.");

        AbstractRequest.setDefultAddress(kvcontrolAddress);
        AbstractRequest.setDefaultPort(kvcontrolPort);

        hu.bme.mit.inf.kvcontrol.bpextension.requests.AbstractRequest.setDefultAddress(
                kvcontrolBPExtensionAddress);
        hu.bme.mit.inf.kvcontrol.bpextension.requests.AbstractRequest.setDefaultPort(
                kvControlBPExtensionPort);

        this.turnoutId = turnoutId;

        bps = new BPServer(comm, turnoutId);
        generalTransmitter = new GeneralTransmitter(comm, turnoutId);
        distributedTransmitter = new DistributedMessageTransmitter(comm);

        bps.setName(BPServer.class.getName());
        generalTransmitter.setName(GeneralTransmitter.class.getName());
        distributedTransmitter.setName(
                DistributedMessageTransmitter.class.getName());

        bps.addListener(this);
        generalTransmitter.addListener(this);
        distributedTransmitter.addListener(this);

        generalTransmitter.start();
        bps.start();
        distributedTransmitter.start();

        STATUS_LOGGER.println("Initialization completed.");
    }

    public void setSection(int sectionId, Boolean isEnabled) {
        if (isEnabled) {
            new SectionStateRequestSender().enableSection(sectionId);
        } else {
            new SectionStateRequestSender().disableSection(sectionId);
        }
    }

    public void sendPassageRequest(int receiverId, Direction direction) {
        hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction dir = convertDirection(
                direction);
        new PassageRequestSender().sendPassageRequest(dir, receiverId,
                STATUS_LOGGER);
    }

    public void sendShortPassageRequest(int receiverId, Direction direction) {

        hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction dir = convertDirection(
                direction);
        new ShortPassageRequestSender().sendShortPassageRequest(dir, receiverId,
                STATUS_LOGGER);
    }

    public void sendPassageResponse(int receiverId, Boolean isAllowed,
            Direction direction) {
        hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction dir = this.convertDirection(
                direction);
        Allowance allowance = null;

        if (isAllowed) {
            allowance = Allowance.ALLOWED;
        } else {
            allowance = Allowance.DENIED;
        }

        new PassageResponseSender().sendPassageResponse(dir, allowance,
                receiverId, STATUS_LOGGER);
    }

    @Override
    public void notifyThreadCompleted(Thread thread) {
        printErrorMessage(thread.getName(), "TERMINATED!!!");
        restartThread(thread);
    }

    public void terminate() {
        STATUS_LOGGER.println("DISPOSE STARTED");
        // stop the threads
        generalTransmitter.interrupt();
        bps.interrupt();
        distributedTransmitter.interrupt();
        STATUS_LOGGER.println("Threads terminated!");
    }

    public static void printErrorMessage(String sender, String message) {
        ERROR_LOGGER.println("[" + sender + "] " + message);
    }

    public static void printLogMessage(String sender, String message) {
        STATUS_LOGGER.println("[" + sender + "] " + message);
    }

    private hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction convertDirection(
            Direction direction) {
        switch (direction) {
            case Top:
                return hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction.TOP;
            case Straight:
                return hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction.STRAIGHT;
            case Divergent:
                return hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction.DIVERGENT;
            default:
                return null;
        }
    }

    private void restartThread(Thread thread) {
        NotifyingThread t = null;
        if (thread instanceof DistributedMessageTransmitter) {
            distributedTransmitter = new DistributedMessageTransmitter(comm);
            t = distributedTransmitter;
        } else if (thread instanceof GeneralTransmitter) {
            generalTransmitter = new GeneralTransmitter(comm, turnoutId);
            t = generalTransmitter;
        } else if (thread instanceof BPServer) {
            bps = new BPServer(comm, turnoutId);
            t = bps;
        }
        t.setName(thread.getName());
        t.addListener(this);
        t.start();
    }

}
