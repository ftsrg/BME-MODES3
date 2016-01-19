package hu.bme.mit.inf.kv.yakindu.control.sm.handler;

import hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger;
import static hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger.STATUS_LOGGER;
import hu.bme.mit.inf.kv.yakindu.control.sm.RemoteTurnout;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Allowance;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.PassageRequestSender;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.PassageResponseSender;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.ShortPassageRequestSender;
import java.util.Map;
import static hu.bme.mit.inf.kv.yakindu.control.sm.handler.DirectionConverterHelper.getDirectionFromValue;
import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.ISectionStatemachine.SCISection;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCISectionsListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

/**
 *
 * @author benedekh
 */
public class TurnoutEventListener implements SCITurnoutListener, SCISectionsListener {

    private final Map<Direction, RemoteTurnout> remoteSections;

    private final Map<Direction, ISectionStatemachine> localSections;

    public TurnoutEventListener(Map<Direction, RemoteTurnout> remoteSections,
            Map<Direction, ISectionStatemachine> localSections) {
        this.remoteSections = remoteSections;
        this.localSections = localSections;
    }

    @Override
    public void onSectionAllowedToRaised(long value) {
        getLocalSectionByDirectionValue(value).raiseSectionAllowedTo(value);
    }

    @Override
    public void onSectionLockedToRaised(long value) {
        getLocalSectionByDirectionValue(value).raiseSectionLockedTo(value);
    }

    @Override
    public void onSectionLockedWithReplyToRaised(long value) {
        getLocalSectionByDirectionValue(value).raiseSectionLockedWithReplyTo(
                value);
    }

    @Override
    public void onLockRequestToRaised(long value) {
        getLocalSectionByDirectionValue(value).raiseLockRequestTo(value);
    }

    private SCISection getLocalSectionByDirectionValue(long value) {
        Direction direction = getDirectionFromValue(value);
        return localSections.get(direction).getSCISection();
    }

    @Override
    public void onRemShortPassageRequestToRaised(long value) {
        sendShortPassageRequest(value);
    }

    @Override
    public void onRemPassageAllowedToRaised(long value) {
        sendPassageAllowed(value);
    }

    @Override
    public void onRemPassageDeniedToRaised(long value) {
        sendPassageDeniedTo(value);
    }

    @Override
    public void onRemPassageRequestToRaised(long value) {
        sendPassageRequest(value);
    }

    @Override
    public void onRemPassageDeniedToAllRaised() {
        for (Direction direction : remoteSections.keySet()) {
            sendPassageDenied(direction);
        }
    }

    private void sendShortPassageRequest(long value) {
        RemoteTurnout remoteTurnout = getRemoteTurnoutByDirectionValue(value);

        new ShortPassageRequestSender().sendShortPassageRequest(
                remoteTurnout.getLocalDirection(),
                remoteTurnout.getTurnoutId(), STATUS_LOGGER);

        SimpleLogger.printLogMessage(TurnoutEventListener.class.getName(),
                "short passage request sent to " + remoteTurnout.getTurnoutId());
    }

    private void sendPassageRequest(long value) {
        RemoteTurnout remoteTurnout = getRemoteTurnoutByDirectionValue(value);

        new PassageRequestSender().sendPassageRequest(
                remoteTurnout.getLocalDirection(), remoteTurnout.getTurnoutId(),
                STATUS_LOGGER);

        SimpleLogger.printLogMessage(TurnoutEventListener.class.getName(),
                "passage request sent to " + remoteTurnout.getTurnoutId());
    }

    private void sendPassageAllowed(long value) {
        RemoteTurnout remoteTurnout = getRemoteTurnoutByDirectionValue(value);

        new PassageResponseSender().sendPassageResponse(
                remoteTurnout.getLocalDirection(), Allowance.ALLOWED,
                remoteTurnout.getTurnoutId(), STATUS_LOGGER);

        SimpleLogger.printLogMessage(TurnoutEventListener.class.getName(),
                "passage allowed sent to " + remoteTurnout.getTurnoutId());
    }

    private void sendPassageDeniedTo(long value) {
        Direction direction = getDirectionFromValue(value);
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

    private RemoteTurnout getRemoteTurnoutByDirectionValue(long value) {
        Direction direction = getDirectionFromValue(value);
        RemoteTurnout remoteTurnout = remoteSections.get(direction);
        return remoteTurnout;
    }

}
