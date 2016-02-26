package hu.bme.mit.inf.kv.yakindu.control.helper;

import hu.bme.mit.inf.kv.yakindu.control.sm.Section;
import hu.bme.mit.inf.kv.yakindu.control.sm.handler.TurnoutEventListener;
import java.util.Set;
import org.yakindu.scr.turnout.TurnoutWrapper;

/**
 *
 * @author benedekh
 */
public class YakinduSMConfiguration {

    private TurnoutWrapper turnoutStatemachine;
    private Set<Section> managedSections;

    private int turnoutSectionId;
    private TurnoutEventListener turnoutEventListener;

    public TurnoutEventListener getTurnoutEventListener() {
        return turnoutEventListener;
    }

    public TurnoutWrapper getTurnoutStatemachine() {
        return turnoutStatemachine;
    }

    public Set<Section> getManagedSections() {
        return managedSections;
    }

    public int getTurnoutSectionId() {
        return turnoutSectionId;
    }

    public void setTurnoutStatemachine(TurnoutWrapper turnoutStatemachine) {
        this.turnoutStatemachine = turnoutStatemachine;
    }

    public void setManagedSections(Set<Section> managedSections) {
        this.managedSections = managedSections;
    }

    public void setTurnoutSectionId(int turnoutSectionId) {
        this.turnoutSectionId = turnoutSectionId;
    }

    public void setTurnoutEventListener(TurnoutEventListener eventListener) {
        this.turnoutEventListener = eventListener;
    }

}
