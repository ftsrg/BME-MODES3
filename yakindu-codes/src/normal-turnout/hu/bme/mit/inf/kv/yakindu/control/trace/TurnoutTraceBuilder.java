package hu.bme.mit.inf.kv.yakindu.control.trace;

import hu.bme.mit.inf.kv.yakindu.control.sm.ITraceableStatemachine;

import java.util.List;

import org.yakindu.scr.kv.KvStatemachine;
import org.yakindu.scr.kv.KvStatemachine.State;

/**
 *
 * @author benedekh
 */
public class TurnoutTraceBuilder extends StatemachineTraceBuilder {

    public TurnoutTraceBuilder() {
        super(StatemachineType.TURNOUT);
    }

    public TurnoutTraceBuilder(StatemachineType type) {
        this();
    }

    @Override
    public boolean updateActiveStates(ITraceableStatemachine statemachine) {
        boolean hasChanged = false;

        List<KvStatemachine.State> lastActiveStates = getLastNode().getActiveStates();
        List<KvStatemachine.State> latestActiveStates = statemachine.getActiveStates(
                StatemachineType.TURNOUT);

        TurnoutTraceNode lastNode = (TurnoutTraceNode) getLastNode();
        boolean lastNodeIsOccupied = lastNode.isOccupied();
        boolean latestTurnoutIsOccupied = statemachine.getSCITurnout().getIsOccupied();

        if (!lastActiveStates.equals(latestActiveStates) || lastNodeIsOccupied != latestTurnoutIsOccupied) {
            addNextNode(latestActiveStates, latestTurnoutIsOccupied, lastNode);
            hasChanged = true;
        }

        return hasChanged;
    }

    @Override
    protected TurnoutTraceNode createTraceNode() {
        return new TurnoutTraceNode();
    }

    private void addNextNode(List<State> activeStates, boolean isOccupied,
            TurnoutTraceNode lastNode) {
        TurnoutTraceNode nextNode = (TurnoutTraceNode) createNextNode(
                activeStates);
        lastNode.setNextNode(nextNode);
        nextNode.setIsOccupied(isOccupied);
    }

}
