package hu.bme.mit.inf.kv.yakindu.control.sm;

import hu.bme.mit.inf.kv.yakindu.control.trace.StatemachineType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.yakindu.scr.kv.KvStatemachine;
import org.yakindu.scr.kv.KvStatemachine.State;

/**
 *
 * @author benedekh
 */
public class TraceableStatemachine implements ITraceableStatemachine {

    private final KvStatemachine statemachine;

    public TraceableStatemachine(KvStatemachine statemachine) {
        this.statemachine = statemachine;
    }

    @Override
    public List<State> getActiveStates(StatemachineType statemachineType) {
        switch (statemachineType) {
            case SECTION_TOP:
                return getTopSectionActiveStates();
            case SECTION_STRAIGHT:
                return getStraightSectionActiveStates();
            case SECTION_DIVERGENT:
                return getDivergentSectionActiveStates();
            case TURNOUT:
                return getTurnoutActiveStates();
            default:
                return Collections.emptyList();
        }
    }

    @Override
    public SCISections getSCISections() {
        return statemachine.getSCISections();
    }

    @Override
    public SCITurnout getSCITurnout() {
        return statemachine.getSCITurnout();
    }

    @Override
    public SCISectionStraight getSCISectionStraight() {
        return statemachine.getSCISectionStraight();
    }

    @Override
    public SCISectionDivergent getSCISectionDivergent() {
        return statemachine.getSCISectionDivergent();
    }

    @Override
    public void init() {
        statemachine.init();
    }

    @Override
    public void enter() {
        statemachine.enter();
    }

    @Override
    public void exit() {
        statemachine.exit();
    }

    @Override
    public void runCycle() {
        statemachine.runCycle();
    }

    private List<State> getTopSectionActiveStates() {
        return getActiveStatesByNameFragment("SectionTop");
    }

    private List<State> getStraightSectionActiveStates() {
        return getActiveStatesByNameFragment("SectionStraight");
    }

    private List<State> getDivergentSectionActiveStates() {
        return getActiveStatesByNameFragment("SectionDivergent");
    }

    private List<State> getTurnoutActiveStates() {
        return getActiveStatesByNameFragment("Turnout");
    }

    private List<State> getActiveStatesByNameFragment(String nameFragment) {
        List<State> activeStates = new ArrayList<>();
        for (State state : State.values()) {
            if (state.name().contains(nameFragment) && statemachine.isStateActive(
                    state)) {
                activeStates.add(state);
            }
        }
        return activeStates;
    }

}
