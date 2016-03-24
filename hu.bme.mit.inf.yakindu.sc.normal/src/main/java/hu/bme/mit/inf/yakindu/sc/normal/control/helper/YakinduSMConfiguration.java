package hu.bme.mit.inf.yakindu.sc.normal.control.helper;

import hu.bme.mit.inf.yakindu.sc.normal.control.sm.Section;
import hu.bme.mit.inf.yakindu.sc.normal.control.sm.handler.TurnoutEventListener;
import java.util.Set;
import org.yakindu.scr.turnout.TurnoutWrapper;

/**
 *
 * @author benedekh
 */
public class YakinduSMConfiguration {

    private TurnoutWrapper turnoutStatemachine;
    private Set<Section> managedSections;

    private TurnoutEventListener turnoutEventListener;

    private int turnoutSectionId;

    public TurnoutEventListener getTurnoutEventListener() {
        return this.turnoutEventListener;
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

    public void setTurnoutEventListener(TurnoutEventListener listener) {
        this.turnoutEventListener = listener;
    }

}
