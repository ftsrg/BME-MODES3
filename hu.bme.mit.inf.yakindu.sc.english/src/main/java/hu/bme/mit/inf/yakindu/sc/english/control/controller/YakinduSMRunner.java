package hu.bme.mit.inf.yakindu.sc.english.control.controller;

import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.OccupancyRequestSender;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.TurnoutRequestSender;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.yakindu.sc.english.control.helper.YakinduSMConfiguration;
import hu.bme.mit.inf.yakindu.sc.english.control.sm.Section;
import hu.bme.mit.inf.yakindu.sc.english.control.transmitter.DistributedMessageTransmitter;
import hu.bme.mit.inf.yakindu.sc.english.control.transmitter.GeneralTransmitter;
import hu.bme.mit.inf.yakindu.mqtt.client.receiver.DistributedMessageReceiver;
import java.util.Set;

import org.yakindu.scr.turnout.TurnoutWrapper;

/**
 * This class is responsible for initializing (starting) and running the
 * registered turnout's statechart, and the connecting sections statehcarts as
 * well.
 *
 * @author benedekh
 */
public class YakinduSMRunner {

    // a thread-safe wrapper of the turnout's statechart 
    private final TurnoutWrapper managedStatemachine;

    /**
     * Sections that connect to the respective turnout. It stores the sections
     * statehcarts as well!
     */
    private final Set<Section> managedSections;

    /**
     * A transmitter object that transfers the required information (sections
     * and turnouts occupancies, turnouts direction) to the respective turnouts
     * and sections statecharts.
     */
    private final GeneralTransmitter generalTransmitter;

    /**
     * The message handler that transmits the messages TO the statecharts FROM
     * the MQTT.
     */
    private final DistributedMessageTransmitter distributedTransmitter;

    // it is a proxy before distributedTransmitter.
    private final DistributedMessageReceiver messageReceiver;

    /**
     *
     * @param sender that is used for the MQTT communication
     * @param conf the object that stores the turnout's and the connecting
     * sections' statecharts
     * @param occupancyRequester the request sender that queries the sections
     * occupancies
     * @param turnoutRequester the request sender that queries the turnout's
     * status
     * @param messageReceiver the proxy object before the distributedTransmitter
     * (receives the statechart messages over MQTT)
     */
    public YakinduSMRunner(MQTTPublishSubscribeDispatcher sender,
            YakinduSMConfiguration conf,
            OccupancyRequestSender occupancyRequester,
            TurnoutRequestSender turnoutRequester,
            DistributedMessageReceiver messageReceiver) {

        TurnoutWrapper statemachine = conf.getTurnoutStatemachine();
        int turnoutSectionId = conf.getTurnoutSectionId();
        Set<Section> localSections = conf.getManagedSections();

        this.managedStatemachine = statemachine;
        this.managedSections = localSections;

        int managedTurnoutId = (int) statemachine.getSCITurnout().getId();
        int managedTurnoutSectionId = turnoutSectionId;

        this.generalTransmitter = new GeneralTransmitter(managedTurnoutId,
                managedTurnoutSectionId, localSections, statemachine,
                occupancyRequester, turnoutRequester);
        this.distributedTransmitter = new DistributedMessageTransmitter(
                statemachine);
        this.messageReceiver = messageReceiver;
        this.messageReceiver.registerTargetRecipient(managedTurnoutId,
                distributedTransmitter);

        // register the yakindu mqtt client for the turnoutEventListener
        conf.getTurnoutEventListener().setRequestSenders(this.messageReceiver);

        generalTransmitter.setName(GeneralTransmitter.class.getName());
        distributedTransmitter.setName(
                DistributedMessageTransmitter.class.getName());
    }

    /**
     * Initialize & start the statecharts and the message transmitter.
     */
    public void start() {
        initializeSM();
        startSM();
    }

    /**
     * Initializes the statecharts (both turnout's and sections).
     */
    private void initializeSM() {
        managedStatemachine.enter();
        for (Section sections : managedSections) {
            sections.enter();
        }
    }

    /**
     * Starts the statecharts (both turnout's and sections), and the message
     * transmitters as well.
     */
    private void startSM() {
        new Thread(managedStatemachine).start();
        for (Section sections : managedSections) {
            sections.start();
        }

        generalTransmitter.start();
        distributedTransmitter.start();
    }

}
