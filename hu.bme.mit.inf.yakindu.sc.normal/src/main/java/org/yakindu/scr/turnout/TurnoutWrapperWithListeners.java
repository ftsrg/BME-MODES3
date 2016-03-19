package org.yakindu.scr.turnout;

import hu.bme.mit.inf.yakindu.sc.normal.control.trace.StatemachineTraceBuilder;
import java.util.ArrayList;
import java.util.List;
import org.yakindu.scr.turnout.TurnoutStatemachine.State;

/**
 *
 * @author benedekh
 */
public class TurnoutWrapperWithListeners extends TurnoutWrapper {

    private static boolean TRACE_LOG_ENABLED = false;
    private final StatemachineTraceBuilder<State> traceBuilder;

    public TurnoutWrapperWithListeners(String statemachineName) {
        traceBuilder = new StatemachineTraceBuilder<>(statemachineName);
    }

    public static void setTraceLogEnabled(boolean traceLogEnabled) {
        TRACE_LOG_ENABLED = traceLogEnabled;
    }

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

    public void addSectionsListener(SCISectionsListener listener) {
        synchronized (statemachine) {
            getSCISections().getListeners().add(listener);
        }
    }

    public void addTurnoutListener(SCITurnoutListener listener) {
        synchronized (statemachine) {
            getSCITurnout().getListeners().add(listener);
        }
    }

    private void updateLogTrace() {
        List<State> activeStates = getActiveStates();
        boolean isOccupied = statemachine.getSCITurnout().getIsOccupied();

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

}
