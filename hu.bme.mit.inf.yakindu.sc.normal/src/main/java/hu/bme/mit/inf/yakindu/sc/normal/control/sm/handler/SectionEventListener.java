package hu.bme.mit.inf.yakindu.sc.normal.control.sm.handler;

import hu.bme.mit.inf.kvcontrol.senders.SectionStateRequestSender;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
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
        logInfoMessage(getClass().getName(), "Section ENABLED " + sectionId);
    }

    @Override
    public void onDisableSectionRaised(long sectionId) {
        new SectionStateRequestSender().disableSection((int) sectionId);
        logInfoMessage(getClass().getName(), "Section DISABLED " + sectionId);
    }

    @Override
    public void onPassingAllowedFromRaised(long directionValue) {
        localTurnout.getSCITurnout().raisePassingAllowedFrom(directionValue);
    }

    @Override
    public void onPassingDeniedFromRaised(long directionValue) {
        localTurnout.getSCITurnout().raisePassingDeniedFrom(directionValue);
    }

    @Override
    public void onSectionLockFromRaised(long directionValue) {
        localTurnout.getSCITurnout().raiseSectionLockFrom(directionValue);
    }

}
