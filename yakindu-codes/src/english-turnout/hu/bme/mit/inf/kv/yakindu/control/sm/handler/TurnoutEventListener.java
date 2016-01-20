package hu.bme.mit.inf.kv.yakindu.control.sm.handler;

import hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger;
import static hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger.STATUS_LOGGER;
import hu.bme.mit.inf.kv.yakindu.control.sm.RemoteTurnout;
import static hu.bme.mit.inf.kv.yakindu.control.sm.handler.DirectionConverterHelper.getDirectionFromValue;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Allowance;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.PassageRequestSender;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.PassageResponseSender;
import java.util.Map;
import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCISectionsListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

/**
 *
 * @author benedekh
 */
public class TurnoutEventListener implements SCITurnoutListener, SCISectionsListener {

    private final Map<Direction, RemoteTurnout> remoteSections;
    private final Map<Direction, ISectionStatemachine> localSections;

    private ITurnoutStatemachine otherHalfOfTurnout;

    public TurnoutEventListener(Map<Direction, RemoteTurnout> remoteSections,
            Map<Direction, ISectionStatemachine> localSections) {
        this.remoteSections = remoteSections;
        this.localSections = localSections;
    }

    public void setOtherHalfOfTurnoutSM(ITurnoutStatemachine otherHalfSM) {
        this.otherHalfOfTurnout = otherHalfSM;
    }

    @Override
    public void onSectionAllowedToRaised(long directionValue) {
        getLocalSectionByDirectionValue(directionValue).raiseSectionAllowedTo(
                directionValue);
    }

    @Override
    public void onLockRequestToRaised(long directionValue) {
        getLocalSectionByDirectionValue(directionValue).raiseLockRequestTo(
                directionValue);
    }

    @Override
    public void onSectionLockedToRaised(long directionValue) {
        getLocalSectionByDirectionValue(directionValue).raiseSectionLockedTo(
                directionValue);
    }

    @Override
    public void onSectionLockedWithReplyToRaised(long directionValue) {
        getLocalSectionByDirectionValue(directionValue).raiseSectionLockedWithReplyTo(
                directionValue);
    }

    private ISectionStatemachine.SCISection getLocalSectionByDirectionValue(
            long directionValue) {
        Direction direction = getDirectionFromValue(directionValue);
        return localSections.get(direction).getSCISection();
    }

    @Override
    public void onRemPassageRequestToRaised(long directionValue) {
        sendPassageRequest(directionValue);
    }

    @Override
    public void onRemPassageAllowedToRaised(long directionValue) {
        sendPassageAllowed(directionValue);
    }

    @Override
    public void onRemPassageDeniedToRaised(long directionValue) {
        sendPassageDeniedTo(directionValue);
    }

    @Override
    public void onSectionLockFromOtherHalfOUTRaised() {
        otherHalfOfTurnout.getSCITurnout().raiseSectionLockFromOtherHalfIN();
    }

    @Override
    public void onRemSectionLockFromOtherHalfOUTRaised() {
        otherHalfOfTurnout.getSCITurnout().raiseRemSectionLockFromOtherHalfIN();
    }

    @Override
    public void onPassingAllowedFromOtherHalfOUTRaised() {
        otherHalfOfTurnout.getSCITurnout().raisePassingAllowedFromOtherHalfIN();
    }

    @Override
    public void onPassingDeniedFromOtherHalfOUTRaised() {
        otherHalfOfTurnout.getSCITurnout().raisePassingDeniedFromOtherHalfIN();
    }

    @Override
    public void onRemPassageDeniedToAllRaised() {
        for (Direction direction : remoteSections.keySet()) {
            sendPassageDenied(direction);
        }
    }

    private void sendPassageRequest(long directionValue) {
        RemoteTurnout remoteTurnout = getRemoteTurnoutByDirectionValue(
                directionValue);

        new PassageRequestSender().sendPassageRequest(
                remoteTurnout.getLocalDirection(), remoteTurnout.getTurnoutId(),
                STATUS_LOGGER);

        SimpleLogger.printLogMessage(TurnoutEventListener.class.getName(),
                "passage request sent to " + remoteTurnout.getTurnoutId());
    }

    private void sendPassageAllowed(long directionValue) {
        RemoteTurnout remoteTurnout = getRemoteTurnoutByDirectionValue(
                directionValue);

        new PassageResponseSender().sendPassageResponse(
                remoteTurnout.getLocalDirection(), Allowance.ALLOWED,
                remoteTurnout.getTurnoutId(), STATUS_LOGGER);

        SimpleLogger.printLogMessage(TurnoutEventListener.class.getName(),
                "passage allowed sent to " + remoteTurnout.getTurnoutId());
    }

    private void sendPassageDeniedTo(long directionValue) {
        Direction direction = getDirectionFromValue(directionValue);
        sendPassageDenied(direction);
    }

    private void sendPassageDenied(Direction direction) {
        RemoteTurnout remoteTurnout = remoteSections.get(direction);

        new PassageResponseSender().sendPassageResponse(
                remoteTurnout.getLocalDirection(), Allowance.DENIED,
                remoteTurnout.getTurnoutId(), STATUS_LOGGER);

        SimpleLogger.printLogMessage(TurnoutEventListener.class.getName(),
                "passage denied sent to " + remoteTurnout.getTurnoutId());
    }

    private RemoteTurnout getRemoteTurnoutByDirectionValue(long directionValue) {
        Direction direction = getDirectionFromValue(directionValue);
        RemoteTurnout remoteTurnout = remoteSections.get(direction);
        return remoteTurnout;
    }

}
