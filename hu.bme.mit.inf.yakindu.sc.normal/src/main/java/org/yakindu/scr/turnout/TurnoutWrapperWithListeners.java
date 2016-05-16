package org.yakindu.scr.turnout;

import hu.bme.mit.inf.yakindu.sc.normal.control.trace.StatemachineTraceBuilder;
import java.util.ArrayList;
import java.util.List;
import org.yakindu.scr.turnout.TurnoutStatemachine.State;

/**
 * Thread-safe wrapper for the turnout's statechart with extra trace logging
 * capabilities.
 *
 * @author benedekh
 */
public class TurnoutWrapperWithListeners extends TurnoutWrapper {

    // if trace logging is enabled
    private static boolean TRACE_LOG_ENABLED = false;

    // the trace logger object
    private final StatemachineTraceBuilder<State> traceBuilder;

    public TurnoutWrapperWithListeners(String statemachineName) {
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
     * Proxy for registering a new SCISectionsListener.
     *
     * @param listener to be registered
     */
    public void addSectionsListener(SCISectionsListener listener) {
        synchronized (statemachine) {
            getSCISections().getListeners().add(listener);
        }
    }

    /**
     * Proxy for registering a new SCITurnoutListener.
     *
     * @param listener to be registered
     */
    public void addTurnoutListener(SCITurnoutListener listener) {
        synchronized (statemachine) {
            getSCITurnout().getListeners().add(listener);
        }
    }

    /**
     * Update the trace log.
     */
    private void updateLogTrace() {
        List<State> activeStates = getActiveStates();
        boolean isOccupied = statemachine.getSCITurnout().getIsOccupied();

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

}
