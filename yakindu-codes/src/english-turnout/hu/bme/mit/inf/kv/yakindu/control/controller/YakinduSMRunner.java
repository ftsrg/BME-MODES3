package hu.bme.mit.inf.kv.yakindu.control.controller;

import hu.bme.mit.inf.kv.yakindu.control.helper.LoggingThread;
import hu.bme.mit.inf.kv.yakindu.control.helper.YakinduSMConfiguration;
import hu.bme.mit.inf.kv.yakindu.control.sm.Section;
import hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationServer;
import hu.bme.mit.inf.kv.yakindu.control.transmitter.DistributedMessageTransmitter;
import hu.bme.mit.inf.kv.yakindu.control.transmitter.GeneralTransmitter;
import java.util.Set;

import org.yakindu.scr.turnout.TurnoutWrapper;

/**
 *
 * @author benedekh
 */
public class YakinduSMRunner extends LoggingThread {

    private static final int RUNCYCLE_INITIAL_ITERATION_LOOPS = 3;
    private static final int RUNCYCLE_ITERATION_LOOPS = 20;
    private static final int SLEEP_BETWEEN_RUNCYCLES = 10;

    private final TurnoutWrapper managedStatemachine;
    private final Set<Section> managedSections;

    private final GeneralTransmitter generalTransmitter;
    private final DistributedMessageTransmitter distributedTransmitter;
    private final CommunicationServer communicationServer;

    public YakinduSMRunner(YakinduSMConfiguration conf) {
        TurnoutWrapper statemachine = conf.getTurnoutStatemachine();
        int turnoutSectionId = conf.getTurnoutSectionId();
        Set<Section> localSections = conf.getManagedSections();

        this.managedStatemachine = statemachine;
        this.managedSections = localSections;

        int managedTurnoutId = (int) statemachine.getSCITurnout().getId();
        int managedTurnoutSectionId = turnoutSectionId;

        generalTransmitter = new GeneralTransmitter(managedTurnoutId,
                managedTurnoutSectionId, localSections, statemachine);
        distributedTransmitter = new DistributedMessageTransmitter(statemachine);
        communicationServer = new CommunicationServer(managedTurnoutId,
                distributedTransmitter);

        generalTransmitter.setName(GeneralTransmitter.class.getName());
        distributedTransmitter.setName(
                DistributedMessageTransmitter.class.getName());
        communicationServer.setName(CommunicationServer.class.getName());
    }

    @Override
    public void run() {
        initializeSM();
        startSM();

        while (!isInterrupted()) {
            simulateSM();

            try {
                Thread.sleep(SLEEP_BETWEEN_RUNCYCLES);
            } catch (InterruptedException e) {
                logErrorMessage(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    private void initializeSM() {
        managedStatemachine.enter();
        for (Section sections : managedSections) {
            sections.enter();
        }

        for (int i = 0; i < RUNCYCLE_INITIAL_ITERATION_LOOPS; ++i) {
            managedStatemachine.runCycle();
            for (Section sections : managedSections) {
                sections.runCycle();
            }
        }
    }

    private void startSM() {
        new Thread(managedStatemachine).start();
        for (Section sections : managedSections) {
            sections.start();
        }

        generalTransmitter.start();
        distributedTransmitter.start();
        communicationServer.start();
    }

    private void simulateSM() {
        for (int i = 0; i < RUNCYCLE_ITERATION_LOOPS; ++i) {
            managedStatemachine.runCycle();
            for (Section section : managedSections) {
                section.runCycle();
            }
        }
    }

}
