package hu.bme.mit.inf.kv.yakindu.control.sm.handler;

import hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger;
import hu.bme.mit.inf.kvcontrol.senders.SectionStateRequestSender;
import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

/**
 *
 * @author benedekh
 */
public class SectionEventListener implements SCISectionListener {

    private final ITurnoutStatemachine localTurnout;

    public SectionEventListener(ITurnoutStatemachine turnoutStatemachine) {
        this.localTurnout = turnoutStatemachine;
    }

    @Override
    public void onEnableSectionRaised(long sectionId) {
        new SectionStateRequestSender().enableSection((int) sectionId);
        SimpleLogger.printLogMessage(SectionEventListener.class.getName(),
                "Section ENABLED " + sectionId);
    }

    @Override
    public void onDisableSectionRaised(long sectionId) {
        new SectionStateRequestSender().disableSection((int) sectionId);
        SimpleLogger.printLogMessage(SectionEventListener.class.getName(),
                "Section DISABLED " + sectionId);
    }

    @Override
    public void onPassingAllowedFromRaised(long value) {
        localTurnout.getSCITurnout().raisePassingAllowedFrom(value);
    }

    @Override
    public void onPassingDeniedFromRaised(long value) {
        localTurnout.getSCITurnout().raisePassingDeniedFrom(value);
    }

    @Override
    public void onSectionLockFromRaised(long value) {
        localTurnout.getSCITurnout().raiseSectionLockFrom(value);
    }

}
