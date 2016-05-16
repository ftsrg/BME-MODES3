package hu.bme.mit.inf.yakindu.sc.normal.control.sm;

import org.yakindu.scr.section.ISectionStatemachine.SCISection;
import org.yakindu.scr.section.SectionWrapper;

/**
 * It stores the ID of the section and the respective statechart too.
 *
 * @author benedekh
 */
public class Section {

    // the ID of the section
    private final int sectionId;

    // the statechart of the respective section
    private final SectionWrapper statemachine;

    public Section(int sectionId, SectionWrapper sm) {
        this.sectionId = sectionId;
        this.statemachine = sm;
    }

    public int getSectionId() {
        return this.sectionId;
    }

    // a proxy method for getting the SCISection interface
    public SCISection getSCISection() {
        return statemachine.getSCISection();
    }

    // a proxy method for firing a runCycle
    public void runCycle() {
        statemachine.runCycle();
    }

    // a proxy method for entering the statechart
    public void enter() {
        statemachine.enter();
    }

    public void start() {
        new Thread(statemachine).start();
    }

}
