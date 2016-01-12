package hu.bme.mit.inf.kv.yakindu.control.trace;

import hu.bme.mit.inf.kv.yakindu.control.sm.ITraceableStatemachine;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author benedekh
 */
public class StatemachineTraceMonitor {

    private final Set<StatemachineTraceBuilder> sectionAndTurnoutTraceBuilders;
    private final ITraceableStatemachine statemachine;

    public StatemachineTraceMonitor(ITraceableStatemachine statemachine,
            String traceSavePath) {
        sectionAndTurnoutTraceBuilders = new HashSet<>();
        sectionAndTurnoutTraceBuilders.add(new StatemachineTraceBuilder(
                StatemachineType.SECTION_TOP, traceSavePath));
        sectionAndTurnoutTraceBuilders.add(new StatemachineTraceBuilder(
                StatemachineType.SECTION_DIVERGENT,
                traceSavePath));
        sectionAndTurnoutTraceBuilders.add(new StatemachineTraceBuilder(
                StatemachineType.SECTION_STRAIGHT,
                traceSavePath));
        sectionAndTurnoutTraceBuilders.add(
                new TurnoutTraceBuilder(traceSavePath));

        this.statemachine = statemachine;
    }

    public void updateActiveStates() {
        boolean hasChanged = false;

        for (StatemachineTraceBuilder traceBuilder : sectionAndTurnoutTraceBuilders) {
            if (traceBuilder.updateActiveStates(statemachine)) {
                hasChanged = true;
            }
        }

        if (hasChanged) {
            for (StatemachineTraceBuilder traceBuilder : sectionAndTurnoutTraceBuilders) {
                traceBuilder.saveToXML();
            }
        }
    }

}
