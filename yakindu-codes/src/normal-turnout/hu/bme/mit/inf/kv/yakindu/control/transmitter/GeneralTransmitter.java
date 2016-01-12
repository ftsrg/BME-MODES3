package hu.bme.mit.inf.kv.yakindu.control.transmitter;

import hu.bme.mit.inf.kv.yakindu.control.controller.IYakinduKVController;
import hu.bme.mit.inf.kv.yakindu.control.helper.LoggingThread;
import hu.bme.mit.inf.kv.yakindu.control.sm.Section;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import hu.bme.mit.inf.kvcontrol.senders.OccupancyRequestSender;
import hu.bme.mit.inf.kvcontrol.senders.TurnoutDirectionRequestSender;

/**
 *
 * @author benedekh
 */
public class GeneralTransmitter extends LoggingThread {

    private static final int OCCUPANCY_TRIGGER_SLEEP = 200;
    private static final int TURNOUT_TRIGGER_SLEEP = 200;
    private static final int UNLOCK_TRIGGER_SLEEP = 200;

    private final int managedTurnoutId;
    private final int managedTurnoutSectionId;

    private boolean turnoutWasStraight = true;

    private final Map<Section, Boolean> sectionWasOccupied;
    private boolean turnoutWasOccupied = false;

    private final IYakinduKVController yakinduController;

    public GeneralTransmitter(int turnoutId, int turnoutSectionId,
            Set<Section> managedSections, IYakinduKVController yakinduController) {
        sectionWasOccupied = new HashMap<>();
        for (Section section : managedSections) {
            this.sectionWasOccupied.put(section, false);
        }
        managedTurnoutId = turnoutId;
        managedTurnoutSectionId = turnoutSectionId;
        this.yakinduController = yakinduController;
    }

    @Override
    // TODO maybe start a new thread for each yakinduController method call (sending event to the statemachine)
    public void run() {
        logMessage("STARTED");
        while (!isInterrupted()) {
            boolean turnoutIsStraight = new TurnoutDirectionRequestSender().isTurnoutStraight(
                    managedTurnoutId);
            if (turnoutIsStraight && !turnoutWasStraight) {
                yakinduController.turnoutIsStraight();
                logMessage("turnout is straight");
            } else if (!turnoutIsStraight && turnoutWasStraight) {
                yakinduController.turnoutIsDivergent();
                logMessage("turnout is divergent");
            }
            turnoutWasStraight = turnoutIsStraight;

            try {
                sleep(TURNOUT_TRIGGER_SLEEP);
            } catch (InterruptedException ex) {
                logErrorMessage(ex.getMessage());
            }

            boolean turnoutIsOccupied = new OccupancyRequestSender().isSectionOccupied(
                    managedTurnoutSectionId);
            if (turnoutIsOccupied && !turnoutWasOccupied) {
                yakinduController.turnoutIsOccupied();
                logMessage("turnout is occupied");
            } else if (!turnoutIsOccupied && turnoutWasOccupied) {
                yakinduController.turnoutIsFree();
                logMessage("turnout is free");
            }
            turnoutWasOccupied = turnoutIsOccupied;

            for (Map.Entry<Section, Boolean> section : sectionWasOccupied.entrySet()) {
                int sectionId = section.getKey().getSectionId();
                boolean sectionWasOccupied = section.getValue();

                boolean sectionIsOccupied = new OccupancyRequestSender().isSectionOccupied(
                        sectionId);
                if (sectionIsOccupied && !sectionWasOccupied) {
                    yakinduController.sectionIsOccupied(sectionId);
                    logMessage("section " + sectionId + " is occupied");
                } else if (!sectionIsOccupied && sectionWasOccupied) {
                    yakinduController.sectionIsFree(sectionId);
                    logMessage("section " + sectionId + " is free");
                }
                section.setValue(sectionIsOccupied);
            }

            try {
                sleep(OCCUPANCY_TRIGGER_SLEEP);
            } catch (InterruptedException ex) {
                logErrorMessage(ex.getMessage());
            }

            yakinduController.revokeLock();

            try {
                sleep(UNLOCK_TRIGGER_SLEEP);
            } catch (InterruptedException ex) {
                logErrorMessage(ex.getMessage());
            }
        }
        logErrorMessage("INTERRUPTED");
    }
}
