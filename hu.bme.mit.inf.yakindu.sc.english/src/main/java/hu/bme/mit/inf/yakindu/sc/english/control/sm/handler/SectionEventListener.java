package hu.bme.mit.inf.yakindu.sc.english.control.sm.handler;

import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.SectionRequestSender;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

/**
 * Event handler for outgoing events from the section's statechart.
 *
 * @author benedekh
 */
public class SectionEventListener implements SCISectionListener {

    // the statechart of the local turnout to which the section connects
    private final ITurnoutStatemachine localTurnout;

    // the request sender for the railway track
    private final SectionRequestSender sectionRequestSender;

    /**
     * @param turnoutStatemachine the statechart of the local turnout to which
     * the section connects
     * @param sectionRequester the request sender for the railway track
     */
    public SectionEventListener(ITurnoutStatemachine turnoutStatemachine,
            SectionRequestSender sectionRequester) {
        this.localTurnout = turnoutStatemachine;
        this.sectionRequestSender = sectionRequester;
    }

    @Override
    public void onEnableSectionRaised(long sectionId) {
        sectionRequestSender.enableSection((int) sectionId);
        logInfoMessage(getClass().getName(), "Section ENABLED " + sectionId);
    }

    @Override
    public void onDisableSectionRaised(long sectionId) {
        sectionRequestSender.disableSection((int) sectionId);
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
