package hu.bme.mit.inf.yakindu.sc.normal.control.transmitter;

import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.OccupancyRequestSender;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.TurnoutRequestSender;
import hu.bme.mit.inf.yakindu.sc.normal.control.sm.Section;

import java.util.Map;
import java.util.Set;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import java.util.HashMap;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

/**
 *
 * @author benedekh
 */
public class GeneralTransmitter extends Thread {

    private static final int OCCUPANCY_TRIGGER_SLEEP = 150;
    private static final int TURNOUT_TRIGGER_SLEEP = 150;
    private static final int UNLOCK_TRIGGER_SLEEP = 150;

    private final ITurnoutStatemachine statemachine;

    private final int managedTurnoutId;
    private final int managedTurnoutSectionId;

    private boolean turnoutWasStraight = true;

    private final Map<Section, Boolean> sectionsWereOccupied;
    private boolean turnoutWasOccupied = false;

    private final OccupancyRequestSender occupancyRequester;
    private final TurnoutRequestSender turnoutRequester;

    public GeneralTransmitter(int turnoutId, int turnoutSectionId,
            Set<Section> managedSections, ITurnoutStatemachine sm,
            OccupancyRequestSender occupancyRequester,
            TurnoutRequestSender turnoutRequester) {
        sectionsWereOccupied = new HashMap<>();
        for (Section section : managedSections) {
            sectionsWereOccupied.put(section, false);
        }
        managedTurnoutId = turnoutId;
        managedTurnoutSectionId = turnoutSectionId;
        statemachine = sm;
        this.occupancyRequester = occupancyRequester;
        this.turnoutRequester = turnoutRequester;
    }

    @Override
    public void run() {
        logInfoMessage(getClass().getName(), "STARTED");
        turnoutRequester.sendIdentify();
        while (!isInterrupted()) {
            updateTurnoutDirection();
            updateOccupancies();
            revokeLock();
        }
        logInfoMessage(getClass().getName(), "INTERRUPTED");
    }

    private void updateTurnoutDirection() {
        boolean turnoutIsStraight = turnoutRequester.isTurnoutStraight(
                managedTurnoutId);
        if (turnoutIsStraight && !turnoutWasStraight) {
            statemachine.getSCITurnout().raiseTurnoutStraight();
            logInfoMessage(getClass().getName(), "turnout is straight");
        } else if (!turnoutIsStraight && turnoutWasStraight) {
            statemachine.getSCITurnout().raiseTurnoutDivergent();
            logInfoMessage(getClass().getName(), "turnout is divergent");
        }
        turnoutWasStraight = turnoutIsStraight;

        try {
            sleep(TURNOUT_TRIGGER_SLEEP);
        } catch (InterruptedException ex) {
            logException(getClass().getName(), ex);
        }
    }

    private void updateOccupancies() {
        updateTurnoutOccupancy();
        updateSectionsOccupancy();
        try {
            sleep(OCCUPANCY_TRIGGER_SLEEP);
        } catch (InterruptedException ex) {
            logException(getClass().getName(), ex);
        }
    }

    private void updateTurnoutOccupancy() {
        boolean turnoutIsOccupied = occupancyRequester.isSectionOccupied(
                managedTurnoutSectionId);
        if (turnoutIsOccupied && !turnoutWasOccupied) {
            statemachine.getSCITurnout().setIsOccupied(true);
            logInfoMessage(getClass().getName(), "turnout is occupied");
        } else if (!turnoutIsOccupied && turnoutWasOccupied) {
            statemachine.getSCITurnout().setIsOccupied(false);
            logInfoMessage(getClass().getName(), "turnout is free");
        }
        turnoutWasOccupied = turnoutIsOccupied;
    }

    private void updateSectionsOccupancy() {
        for (Map.Entry<Section, Boolean> section : sectionsWereOccupied.entrySet()) {
            int sectionId = section.getKey().getSectionId();
            boolean sectionWasOccupied = section.getValue();

            boolean sectionIsOccupied = occupancyRequester.isSectionOccupied(
                    sectionId);
            if (sectionIsOccupied && !sectionWasOccupied) {
                section.getKey().getSCISection().raiseSectionOccupied();
                logInfoMessage(getClass().getName(),
                        "section " + sectionId + " is occupied");
            } else if (!sectionIsOccupied && sectionWasOccupied) {
                section.getKey().getSCISection().raiseSectionFree();
                logInfoMessage(getClass().getName(),
                        "section " + sectionId + " is free");
            }
            section.setValue(sectionIsOccupied);
        }
    }

    private void revokeLock() {
        for (Section section : sectionsWereOccupied.keySet()) {
            section.getSCISection().raiseRevokeLock();
        }

        try {
            sleep(UNLOCK_TRIGGER_SLEEP);
        } catch (InterruptedException ex) {
            logException(getClass().getName(), ex);
        }
    }
}
