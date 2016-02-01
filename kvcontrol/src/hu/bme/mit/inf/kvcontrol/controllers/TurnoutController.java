package hu.bme.mit.inf.kvcontrol.controllers;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static hu.bme.mit.inf.kvcontrol.CommandServer.handleConnectionError;

import hu.bme.mit.inf.kvcontrol.data.Commands;
import hu.bme.mit.inf.kvcontrol.data.PacketsContainer;
import hu.bme.mit.inf.kvcontrol.data.Relations;
import hu.bme.mit.inf.kvcontrol.entities.Turnout;
import hu.bme.mit.inf.kvcontrol.exceptions.NotFoundException;
import hu.bme.mit.inf.kvcontrol.interfaces.IController;
import hu.bme.mit.inf.kvcontrol.interfaces.ITurnoutController;

/**
 * A controller for handling all turnouts status defined in turnouts.ini
 *
 * @author zsoltmazlo, benedekh
 */
public class TurnoutController extends AbstractController implements
        ITurnoutController {

    /**
     * a reference of turnouts' Map which contains all turnouts' status
     */
    private final ConcurrentMap<String, Turnout> turnouts;

    private final Requester requesterObject;
    private final Recevier receiverObject;

    public TurnoutController() {
        super();
        this.turnouts = Relations.getTurnouts();
        requesterObject = new Requester(this.heartBeat);
        requester = new Thread(requesterObject);
        receiverObject = new Recevier(this.heartBeat);
        receiver = new Thread(receiverObject);
    }

    @Override
    public boolean isTurnoutDivergent(int turnoutID) throws NotFoundException {
        Turnout t = this.turnouts.get(Relations.getKey(turnoutID));
        if (t == null) {
            throw new NotFoundException(String.format(
                    "Turnout with %d ID is not found!", turnoutID));
        }
        return t.isDivergent();
    }

    @Override
    public boolean isTurnoutStraight(int turnoutID) throws NotFoundException {
        Turnout t = this.turnouts.get(Relations.getKey(turnoutID));
        if (t == null) {
            throw new NotFoundException(String.format(
                    "Turnout with %d ID is not found!", turnoutID));
        }
        return t.isStraight();
    }

    private class Recevier extends IController.RunnableStub {

        private final BlockingQueue<byte[]> packets = PacketsContainer.turnoutPackets;

        public Recevier(Object syncObject) {
            super(syncObject);
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    byte[] received = packets.take();
                    switch (received[0]) {
                        case Commands.COMMAND_SEND_TURNOUT_STATUS:
                            String key = Relations.getKey(received[1]);
                            Turnout t = turnouts.get(key);
                            if (t != null) {
                                t.setMeasuredValues(received[2], received[3]);
                                turnouts.put(key, t);
                            }
                            break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(TurnoutController.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class Requester extends IController.RunnableStub {

        public Requester(Object syncObject) {
            super(syncObject);
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                // sending a TCP message for all controllers requiring
                // turnouts' status
                for (Turnout turnout : turnouts.values()) {
                    try {
                        byte[] message = {Commands.COMMAND_GET_TURNOUT_STATUS,
                            (byte) turnout.getID()};
                        sendTCPPacket(turnout.getPhysicalAddress(),
                                message);
                        Thread.sleep(10);
                    } catch (java.net.NoRouteToHostException | java.nio.channels.NotYetConnectedException | java.nio.channels.ClosedChannelException e) {
                        handleConnectionError(e);
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(TurnoutController.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }

                }

                synchronized (this.heartBeat) {
                    try {
                        this.heartBeat.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TurnoutController.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

}
