/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yakindu.scr.turnout;

import hu.bme.mit.inf.kv.yakindu.control.trace.StatemachineTraceBuilder;
import java.util.ArrayList;
import java.util.List;
import org.yakindu.scr.turnout.TurnoutStatemachine.State;

/**
 *
 * @author benedekh
 */
public class TurnoutWrapperWithListeners extends TurnoutWrapper {

    private final StatemachineTraceBuilder<State> traceBuilder;

    public TurnoutWrapperWithListeners(String statemachineName) {
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

    public void addSectionsListener(SCISectionsListener listener) {
        synchronized (statemachine) {
            getSCISections().getListeners().add(listener);
        }
    }

    public void removeSectionsListener(SCISectionsListener listener) {
        synchronized (statemachine) {
            getSCISections().getListeners().remove(listener);
        }
    }

    public void addTurnoutListener(SCITurnoutListener listener) {
        synchronized (statemachine) {
            getSCITurnout().getListeners().add(listener);
        }
    }

    public void removeTurnoutListener(SCITurnoutListener listener) {
        synchronized (statemachine) {
            getSCITurnout().getListeners().remove(listener);
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
