package hu.bme.mit.inf.bpcontrol.transmitters;

import hu.bme.mit.inf.bpcontrol.NotifyingThread;
import static bpcontrol.components.Rarduino.BP_SYNC_OBJECT;
import static bpcontrol.components.Rarduino.STATUS_LOG_ENABLED;
import interfaces.ICommunicationFromProvider;

import java.util.Map;
import java.util.TreeMap;

import bpcontrol.components.Rarduino;
import hu.bme.mit.inf.kvcontrol.senders.OccupancyRequestSender;
import hu.bme.mit.inf.kvcontrol.senders.TurnoutDirectionRequestSender;

/**
 *
 * @author benedekh
 */
public class GeneralTransmitter extends NotifyingThread {

    private static final int OCCUPANCY_TRIGGER_SLEEP = 500;
    private static final int TURNOUT_TRIGGER_SLEEP = 500;
    private static final int UNLOCK_TRIGGER_SLEEP = 500;

    private static final int ENGLISH_TURNOUT_ID = 0x86;

    private final ICommunicationFromProvider comm;

    /**
     * The id of the turnout, that is managed by the realized component. The
     * Boolean value indicates whether the turnout straight is.
     */
    private Map<Integer, Boolean> managedTurnouts;

    public GeneralTransmitter(ICommunicationFromProvider comm, int turnoutId) {
        this.comm = comm;

        managedTurnouts = new TreeMap<>();
        managedTurnouts.put(turnoutId, true);
        if (turnoutId == ENGLISH_TURNOUT_ID) {
            managedTurnouts.put(turnoutId + 1, true); // 0x86 Arduino handles both 0x86 and 0x87 turnouts
        }
    }

    public void doRun() {
        Rarduino.printErrorMessage(getName(), "STARTED");

        synchronized (BP_SYNC_OBJECT) {
            comm.resetSm(null);
        }

        while (!Thread.currentThread().isInterrupted()) {
            try {
                int occupancyVector = new OccupancyRequestSender().getOccupancyVector();
                if (STATUS_LOG_ENABLED) {
                    Rarduino.printLogMessage(getName(), Integer.toString(
                            occupancyVector, 2));
                }
                synchronized (BP_SYNC_OBJECT) {
                    comm.receiveOccupancy(null, occupancyVector);
                }
                Thread.sleep(OCCUPANCY_TRIGGER_SLEEP);

                for (Map.Entry<Integer, Boolean> turnout : managedTurnouts.entrySet()) {
                    int turnoutId = turnout.getKey();
                    boolean wasStraightBefore = turnout.getValue();

                    boolean isStraightNow = new TurnoutDirectionRequestSender().isTurnoutStraight(
                            turnoutId);

                    if (wasStraightBefore && !isStraightNow) {
                        synchronized (BP_SYNC_OBJECT) {
                            comm.turnoutDirection(null, turnoutId, true);
                        }

                        if (STATUS_LOG_ENABLED) {
                            Rarduino.printLogMessage(getName(),
                                    "turnout " + turnoutId + " is divergent");
                        }
                    } else if (!wasStraightBefore && isStraightNow) {
                        synchronized (BP_SYNC_OBJECT) {
                            comm.turnoutDirection(null, turnoutId, false);
                        }

                        if (STATUS_LOG_ENABLED) {
                            Rarduino.printLogMessage(getName(),
                                    "turnout " + turnoutId + " is straight");
                        }
                    }

                    turnout.setValue(isStraightNow);
                }
                Thread.sleep(TURNOUT_TRIGGER_SLEEP);

                synchronized (BP_SYNC_OBJECT) {
                    comm.triggerUnlock(null);
                }
                Thread.sleep(UNLOCK_TRIGGER_SLEEP);
            } catch (InterruptedException e) {
                Rarduino.printErrorMessage(getName(), e.getMessage());
                return;
            }
        }
    }
}
