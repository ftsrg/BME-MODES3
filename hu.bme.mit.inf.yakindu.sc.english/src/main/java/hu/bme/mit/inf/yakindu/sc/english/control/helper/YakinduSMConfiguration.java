package hu.bme.mit.inf.yakindu.sc.english.control.helper;

import hu.bme.mit.inf.yakindu.sc.english.control.sm.Section;
import hu.bme.mit.inf.yakindu.sc.english.control.sm.handler.TurnoutEventListener;
import java.util.Set;
import org.yakindu.scr.turnout.TurnoutWrapper;

/**
 * It stores in one place the respective turnout's statechart and the connecting
 * sections statecharts as well.
 *
 * Besides the turnout's ID as a section (because the turnout itself is a
 * section from the occupancy point of view), and an event listener, that
 * handles the outgoing events from the turnout's statechart, for the turnout is
 * stored as well.
 *
 * @author benedekh
 */
public class YakinduSMConfiguration {

    // a thread-safe wrapper of the turnout's statechart
    private TurnoutWrapper turnoutStatemachine;

    /**
     * Sections that connect to the respective turnout. It stores the sections
     * statehcarts as well!
     */
    private Set<Section> managedSections;

    // the ID of the turnout as a section from the occupancy view
    private int turnoutSectionId;

    // the event listener for the outgoing events from the turnout's statechart
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
