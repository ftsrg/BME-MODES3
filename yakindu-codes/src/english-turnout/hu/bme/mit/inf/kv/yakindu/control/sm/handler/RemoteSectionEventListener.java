package hu.bme.mit.inf.kv.yakindu.control.sm.handler;

import hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger;
import static hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger.STATUS_LOGGER;
import hu.bme.mit.inf.kv.yakindu.control.sm.RemoteTurnout;

import java.util.Set;

import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Allowance;
import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.PassageRequestSender;
import hu.bme.mit.inf.kvcontrol.bpextension.senders.PassageResponseSender;
import hu.bme.mit.inf.kvcontrol.senders.SectionStateRequestSender;

import org.yakindu.scr.kv.IKvStatemachine.SCISectionsListener;

/**
 *
 * @author benedekh
 */
public class RemoteSectionEventListener implements SCISectionsListener {

    private final Set<RemoteTurnout> remoteSections;

    public RemoteSectionEventListener(Set<RemoteTurnout> remoteSections) {
        this.remoteSections = remoteSections;
    }

    @Override
    public void onEnableSectionRaised(long sectionId) {
        new SectionStateRequestSender().enableSection((int) sectionId);
        SimpleLogger.printLogMessage(RemoteSectionEventListener.class.getName(),
                "Section ENABLED " + sectionId);
    }

    @Override
    public void onDisableSectionRaised(long sectionId) {
        new SectionStateRequestSender().disableSection((int) sectionId);
        SimpleLogger.printLogMessage(RemoteSectionEventListener.class.getName(),
                "Section DISABLED " + sectionId);
    }

    @Override
    public void onRemPassageRequestToDivergentRaised() {
        this.sendPassageRequest(Direction.DIVERGENT);
    }

    @Override
    public void onRemPassageRequestToStraightRaised() {
        this.sendPassageRequest(Direction.STRAIGHT);
    }

    @Override
    public void onRemPassageAllowedToDivergentRaised() {
        this.sendPassageAllowed(Direction.DIVERGENT);
    }

    @Override
    public void onRemPassageAllowedToStraightRaised() {
        this.sendPassageAllowed(Direction.STRAIGHT);
    }

    @Override
    public void onRemPassageDeniedToDivergentRaised() {
        this.sendPassageDenied(Direction.DIVERGENT);
    }

    @Override
    public void onRemPassageDeniedToStraightRaised() {
        this.sendPassageDenied(Direction.STRAIGHT);
    }

    @Override
    public void onRemPassageDeniedToAllRaised() {
        for (RemoteTurnout turnout : remoteSections) {
            this.sendPassageDenied(turnout.getRemoteDirection());
        }
    }

    private void sendPassageRequest(Direction direction) {
        RemoteTurnout remoteTurnout = this.getTurnoutByRemoteDirection(direction);
        new PassageRequestSender().sendPassageRequest(
                remoteTurnout.getLocalDirection(), remoteTurnout.getTurnoutId(),
                STATUS_LOGGER);
        SimpleLogger.printLogMessage(RemoteSectionEventListener.class.getName(),
                "passage request sent to " + remoteTurnout.getTurnoutId());
    }

    private void sendPassageAllowed(Direction direction) {
        RemoteTurnout remoteTurnout = this.getTurnoutByRemoteDirection(direction);
        new PassageResponseSender().sendPassageResponse(
                remoteTurnout.getLocalDirection(), Allowance.ALLOWED,
                remoteTurnout.getTurnoutId(), STATUS_LOGGER);
        SimpleLogger.printLogMessage(RemoteSectionEventListener.class.getName(),
                "passage allowed sent to " + remoteTurnout.getTurnoutId());
    }

    private void sendPassageDenied(Direction direction) {
        RemoteTurnout remoteTurnout = this.getTurnoutByRemoteDirection(direction);
        new PassageResponseSender().sendPassageResponse(
                remoteTurnout.getLocalDirection(), Allowance.DENIED,
                remoteTurnout.getTurnoutId(), STATUS_LOGGER);
        SimpleLogger.printLogMessage(RemoteSectionEventListener.class.getName(),
                "passage denied sent to " + remoteTurnout.getTurnoutId());
    }

    private RemoteTurnout getTurnoutByRemoteDirection(Direction direction) {
        for (RemoteTurnout turnout : remoteSections) {
            if (turnout.getRemoteDirection() == direction) {
                return turnout;
            }
        }
        return null;
    }

}
