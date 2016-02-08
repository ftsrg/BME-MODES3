package hu.bme.mit.inf.kv.yakindu.control.sm.handler;

import static hu.bme.mit.inf.kv.yakindu.control.helper.NullSection.NULL_SECTION;
import hu.bme.mit.inf.kv.yakindu.control.sm.RemoteTurnout;
import static hu.bme.mit.inf.kv.yakindu.control.sm.handler.DirectionConverterHelper.getDirectionFromValue;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.getStateMachineMQTTConfiguration;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance.ALLOWED;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance.DENIED;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import hu.bme.mit.inf.yakindu.mqtt.client.data.MQTTConfiguration;
import hu.bme.mit.inf.yakindu.mqtt.client.senders.PassageRequestSender;
import hu.bme.mit.inf.yakindu.mqtt.client.senders.PassageResponseSender;
import hu.bme.mit.inf.yakindu.mqtt.client.senders.ShortPassageRequestSender;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.LogManager.logInfoMessage;
import java.util.Map;
import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.ISectionStatemachine.SCISection;
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

    private final PassageRequestSender passageRequest;
    private final ShortPassageRequestSender shortPassageRequest;
    private final PassageResponseSender passageResponse;

    public TurnoutEventListener(Map<Direction, RemoteTurnout> remoteSections,
            Map<Direction, ISectionStatemachine> localSections) {
        this.remoteSections = remoteSections;
        this.localSections = localSections;

        MQTTConfiguration conf = getStateMachineMQTTConfiguration();
        this.passageRequest = new PassageRequestSender(conf);
        this.shortPassageRequest = new ShortPassageRequestSender(conf);
        this.passageResponse = new PassageResponseSender(conf);
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

    private SCISection getLocalSectionByDirectionValue(
            long directionValue) {
        Direction direction = getDirectionFromValue(directionValue);
        SCISection section;
        try {
            section = localSections.get(direction).getSCISection();
        } catch (NullPointerException ex) {
            section = NULL_SECTION;
        }
        return section;
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
    public void onRemPassingAllowedFromOtherHalfOUTRaised() {
        otherHalfOfTurnout.getSCITurnout().raiseRemPassingAllowedFromOtherHalfIN();
    }

    @Override
    public void onRemPassingDeniedFromOtherHalfOUTRaised() {
        otherHalfOfTurnout.getSCITurnout().raiseRemPassingDeniedFromOtherHalfIN();
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

        passageRequest.sendPassageRequest(remoteTurnout.getLocalDirection(),
                remoteTurnout.getTurnoutId());

        logInfoMessage(getClass().getName(),
                "passage request sent to " + remoteTurnout.getTurnoutId());
    }

    private void sendPassageAllowed(long directionValue) {
        RemoteTurnout remoteTurnout = getRemoteTurnoutByDirectionValue(
                directionValue);

        passageResponse.sendPassageResponse(remoteTurnout.getLocalDirection(),
                ALLOWED, remoteTurnout.getTurnoutId());

        logInfoMessage(getClass().getName(),
                "passage allowed sent to " + remoteTurnout.getTurnoutId());
    }

    private void sendPassageDeniedTo(long directionValue) {
        Direction direction = getDirectionFromValue(directionValue);
        sendPassageDenied(direction);
    }

    private void sendPassageDenied(Direction direction) {
        RemoteTurnout remoteTurnout = remoteSections.get(direction);

        passageResponse.sendPassageResponse(remoteTurnout.getLocalDirection(),
                DENIED, remoteTurnout.getTurnoutId());

        logInfoMessage(getClass().getName(),
                "passage denied sent to " + remoteTurnout.getTurnoutId());
    }

    private RemoteTurnout getRemoteTurnoutByDirectionValue(long directionValue) {
        Direction direction = getDirectionFromValue(directionValue);
        RemoteTurnout remoteTurnout = remoteSections.get(direction);
        return remoteTurnout;
    }

}
