package org.yakindu.scr.section;

import hu.bme.mit.inf.kv.yakindu.control.trace.StatemachineTraceBuilder;
import java.util.ArrayList;
import java.util.List;
import org.yakindu.scr.section.SectionStatemachine.State;

/**
 *
 * @author benedekh
 */
public class SectionWrapperWithListeners extends SectionWrapper {

    private final StatemachineTraceBuilder<State> traceBuilder;

    public SectionWrapperWithListeners(String statemachineName) {
        traceBuilder = new StatemachineTraceBuilder<>(statemachineName);
    }

    @Override
    public void run() {

        boolean terminate = false;

        while (!(terminate || Thread.currentThread().isInterrupted())) {

            try {

                Runnable eventProcessor = eventQueue.take();
                eventProcessor.run();

                synchronized (statemachine) {
                    updateLogTrace();
                }

            } catch (InterruptedException e) {
                terminate = true;
            }
        }
    }

    public void addListener(SCISectionListener listener) {
        synchronized (statemachine) {
            getSCISection().getListeners().add(listener);
        }
    }

    public void removeListener(SCISectionListener listener) {
        synchronized (statemachine) {
            getSCISection().getListeners().remove(listener);
        }
    }

    private void updateLogTrace() {
        List<State> activeStates = getActiveStates();
        boolean isOccupied = isOccupiedNow(activeStates);

        boolean hasChanged = traceBuilder.updateActiveStates(activeStates,
                isOccupied);
        if (hasChanged) {
            traceBuilder.saveToXML();
        }
    }

    private List<State> getActiveStates() {
        List<State> activeStates = new ArrayList<>();
        for (State value : State.values()) {
            if (statemachine.isStateActive(value)) {
                activeStates.add(value);
            }
        }
        return activeStates;
    }

    private boolean isOccupiedNow(List<State> activeStates) {
        for (State state : activeStates) {
            if (state.name().toLowerCase().contains("occupied")) {
                return true;
            }
        }
        return false;
    }

}
