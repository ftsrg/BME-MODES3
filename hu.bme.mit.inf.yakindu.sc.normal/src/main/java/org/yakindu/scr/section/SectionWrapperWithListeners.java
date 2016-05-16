package org.yakindu.scr.section;

import hu.bme.mit.inf.yakindu.sc.normal.control.trace.StatemachineTraceBuilder;
import java.util.ArrayList;
import java.util.List;
import org.yakindu.scr.section.SectionStatemachine.State;

/**
 * Thread-safe wrapper for the section's statechart with extra trace logging
 * capabilities.
 *
 * @author benedekh
 */
public class SectionWrapperWithListeners extends SectionWrapper {

// if trace logging is enabled
    private static boolean TRACE_LOG_ENABLED = false;

    // the trace logger object
    private final StatemachineTraceBuilder<State> traceBuilder;

    public SectionWrapperWithListeners(String statemachineName) {
        traceBuilder = new StatemachineTraceBuilder<>(statemachineName);
    }

    public static void setTraceLogEnabled(boolean traceLogEnabled) {
        TRACE_LOG_ENABLED = traceLogEnabled;
    }

    /**
     * Process the received events and after that check whether the active
     * states have changed (log trace changes).
     */
    @Override
    public void run() {

        boolean terminate = false;

        while (!(terminate || Thread.currentThread().isInterrupted())) {
            try {
                Runnable eventProcessor = eventQueue.take();
                eventProcessor.run();

                if (TRACE_LOG_ENABLED) {
                    synchronized (statemachine) {
                        updateLogTrace();
                    }
                }

            } catch (InterruptedException e) {
                terminate = true;
            }
        }
    }

    /**
     * Proxy for registering a new SCISectionListener.
     *
     * @param listener to be registered
     */
    public void addListener(SCISectionListener listener) {
        synchronized (statemachine) {
            getSCISection().getListeners().add(listener);
        }
    }

    /**
     * Update the trace log.
     */
    private void updateLogTrace() {
        List<State> activeStates = getActiveStates();
        boolean isOccupied = isOccupiedNow(activeStates);

        boolean hasChanged = traceBuilder.updateActiveStates(activeStates,
                isOccupied);
        if (hasChanged) {
            traceBuilder.saveToXML();
        }
    }

    /**
     * Get latest active states from the statechart.
     *
     * @return the latest active states.
     */
    private List<State> getActiveStates() {
        List<State> activeStates = new ArrayList<>();
        for (State value : State.values()) {
            if (statemachine.isStateActive(value)) {
                activeStates.add(value);
            }
        }
        return activeStates;
    }

    /**
     * Checks whether the section is occupied, based on the state name.
     *
     * @param activeStates the active states collection
     * @return true if the respective section is occupied
     */
    private boolean isOccupiedNow(List<State> activeStates) {
        for (State state : activeStates) {
            if (state.name().toLowerCase().contains("occupied")) {
                return true;
            }
        }
        return false;
    }

}
