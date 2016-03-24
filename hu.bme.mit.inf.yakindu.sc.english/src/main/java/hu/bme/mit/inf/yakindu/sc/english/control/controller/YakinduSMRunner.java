package hu.bme.mit.inf.yakindu.sc.english.control.controller;

import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.OccupancyRequestSender;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.TurnoutRequestSender;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import hu.bme.mit.inf.yakindu.sc.english.control.helper.YakinduSMConfiguration;
import hu.bme.mit.inf.yakindu.sc.english.control.sm.Section;
import static hu.bme.mit.inf.yakindu.sc.english.control.transmitter.CommunicationConfiguration.getStateMachineMQTTConfiguration;
import hu.bme.mit.inf.yakindu.sc.english.control.transmitter.DistributedMessageTransmitter;
import hu.bme.mit.inf.yakindu.sc.english.control.transmitter.GeneralTransmitter;
import hu.bme.mit.inf.yakindu.mqtt.client.receiver.DistributedMessageReceiver;
import static hu.bme.mit.inf.yakindu.sc.english.control.transmitter.CommunicationConfiguration.getKvcontrolOccupancyMQTTConfiguration;
import static hu.bme.mit.inf.yakindu.sc.english.control.transmitter.CommunicationConfiguration.getKvcontrolTurnoutMQTTConfiguration;
import java.util.Set;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttReceivedMessage;
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

    public YakinduSMRunner(MQTTPublisherSubscriber mqtt, YakinduSMConfiguration conf) throws MqttException {
        TurnoutWrapper statemachine = conf.getTurnoutStatemachine();
        int turnoutSectionId = conf.getTurnoutSectionId();
        Set<Section> localSections = conf.getManagedSections();

        this.managedStatemachine = statemachine;
        this.managedSections = localSections;

        int managedTurnoutId = (int) statemachine.getSCITurnout().getId();
        int managedTurnoutSectionId = turnoutSectionId;

        MQTTConfiguration kvcontrolOccupancyMQTTConf = getKvcontrolOccupancyMQTTConfiguration();
        OccupancyRequestSender occupancyRequester = new OccupancyRequestSender(mqtt);
        TurnoutRequestSender turnoutRequester = new TurnoutRequestSender(mqtt);

        generalTransmitter = new GeneralTransmitter(managedTurnoutId,
                managedTurnoutSectionId, localSections, statemachine,
                occupancyRequester, turnoutRequester);
        distributedTransmitter = new DistributedMessageTransmitter(statemachine);
        this.messageReceiver = new DistributedMessageReceiver(
                getStateMachineMQTTConfiguration(), distributedTransmitter,
                managedTurnoutId);

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
