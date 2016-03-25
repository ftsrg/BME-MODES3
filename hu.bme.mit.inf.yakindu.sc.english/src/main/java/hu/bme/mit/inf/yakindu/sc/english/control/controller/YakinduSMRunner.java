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
 *
 * @author benedekh
 */
public class YakinduSMRunner {

    private final TurnoutWrapper managedStatemachine;
    private final Set<Section> managedSections;

    private final GeneralTransmitter generalTransmitter;
    private final DistributedMessageTransmitter distributedTransmitter;

    private final DistributedMessageReceiver messageReceiver;

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

    public void start() {
        initializeSM();
        startSM();
    }

    private void initializeSM() {
        managedStatemachine.enter();
        for (Section sections : managedSections) {
            sections.enter();
        }
    }

    private void startSM() {
        new Thread(managedStatemachine).start();
        for (Section sections : managedSections) {
            sections.start();
        }

        generalTransmitter.start();
        distributedTransmitter.start();
    }

}
