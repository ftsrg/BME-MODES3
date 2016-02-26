package hu.bme.mit.inf.yakindu.sc.english.control.sm;

import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.SectionWrapper;

/**
 *
 * @author benedekh
 */
public class Section {

    private final int sectionId;
    private final SectionWrapper statemachine;

    public Section(int sectionId, SectionWrapper sm) {
        this.sectionId = sectionId;
        this.statemachine = sm;
    }

    public int getSectionId() {
        return this.sectionId;
    }

    public ISectionStatemachine.SCISection getSCISection() {
        return statemachine.getSCISection();
    }

    public void runCycle() {
        statemachine.runCycle();
    }

    public void enter() {
        statemachine.enter();
    }

    public void start() {
        new Thread(statemachine).start();
    }

}
