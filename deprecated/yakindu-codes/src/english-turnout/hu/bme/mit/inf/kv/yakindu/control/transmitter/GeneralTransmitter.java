package hu.bme.mit.inf.kv.yakindu.control.transmitter;

import hu.bme.mit.inf.kv.yakindu.control.sm.Section;

import java.util.Map;
import java.util.Set;

import hu.bme.mit.inf.kvcontrol.senders.OccupancyRequestSender;
import hu.bme.mit.inf.kvcontrol.senders.TurnoutDirectionRequestSender;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import static java.lang.Thread.sleep;
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

    public GeneralTransmitter(int turnoutId, int turnoutSectionId,
            Set<Section> managedSections, ITurnoutStatemachine sm) {
        sectionsWereOccupied = new HashMap<>();
        for (Section section : managedSections) {
            sectionsWereOccupied.put(section, false);
        }
        managedTurnoutId = turnoutId;
        managedTurnoutSectionId = turnoutSectionId;
        statemachine = sm;
    }

    @Override
    public void run() {
        logInfoMessage(getClass().getName(), "STARTED");
        while (!isInterrupted()) {
            updateTurnoutDirection();
            updateOccupancies();
            revokeLock();
        }
        logInfoMessage(getClass().getName(), "INTERRUPTED");
    }

    private void updateTurnoutDirection() {
        boolean turnoutIsStraight = new TurnoutDirectionRequestSender().isTurnoutStraight(
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
        boolean turnoutIsOccupied = new OccupancyRequestSender().isSectionOccupied(
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

            boolean sectionIsOccupied = new OccupancyRequestSender().isSectionOccupied(
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
