package hu.bme.mit.inf.bpcontrol.transmitters;

import static bpcontrol.components.Rarduino.STATUS_LOG_ENABLED;
import static bpcontrol.components.Rarduino.BP_SYNC_OBJECT;
import interfaces.ICommunicationFromProvider;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import types.Direction;
import hu.bme.mit.inf.bpcontrol.Commands;
import hu.bme.mit.inf.bpcontrol.NotifyingThread;

import bpcontrol.components.Rarduino;

/**
 * This class is responsible for transmitting the received distributed messages
 * to the model.
 *
 * @author benedekh
 */
public class DistributedMessageTransmitter extends NotifyingThread {

    public static final BlockingQueue<byte[]> distributedPackets = new LinkedBlockingQueue<>();

    private final ICommunicationFromProvider comm;

    public DistributedMessageTransmitter(ICommunicationFromProvider comm) {
        this.comm = comm;
    }

    @Override
    public void doRun() {
        Rarduino.printErrorMessage(getName(), "STARTED");

        synchronized (BP_SYNC_OBJECT) {
            comm.resetSm(null);
        }

        while (!Thread.currentThread().isInterrupted()) {
            try {
                while (!distributedPackets.isEmpty()) {
                    if (STATUS_LOG_ENABLED) {
                        Rarduino.printLogMessage(getName(), "REMOTE MESSAGE RECEIVED!");
                    }
                    byte[] received = distributedPackets.poll();

                    Integer receiverId = null;
                    Direction direction = null;
                    Boolean isAllowed = null;

                    switch (received[0]) {
                        case Commands.DISTRIBUTED_PASSAGE_REQUEST_TOP:
                            direction = Direction.Top;
                            receiverId = (int) received[1] & 0xFF;
                            break;
                        case Commands.DISTRIBUTED_PASSAGE_REQUEST_STRAIGHT:
                            direction = Direction.Straight;
                            receiverId = (int) received[1] & 0xFF;
                            break;
                        case Commands.DISTRIBUTED_PASSAGE_REQUEST_DIVERGENT:
                            direction = Direction.Divergent;
                            receiverId = (int) received[1] & 0xFF;
                            break;
                        case Commands.DISTRIBUTED_SHORT_PASSAGE_REQUEST_TOP:
                            direction = Direction.Top;
                            receiverId = (int) received[1] & 0xFF;
                            break;
                        case Commands.DISTRIBUTED_SHORT_PASSAGE_REQUEST_STRAIGHT:
                            direction = Direction.Straight;
                            receiverId = (int) received[1] & 0xFF;
                            break;
                        case Commands.DISTRIBUTED_SHORT_PASSAGE_REQUEST_DIVERGENT:
                            direction = Direction.Divergent;
                            receiverId = (int) received[1] & 0xFF;
                            break;
                        case Commands.DISTRIBUTED_PASSAGE_RESPONSE_TOP:
                            direction = Direction.Top;
                            isAllowed = (received[1] == Commands.DISTRIBUTED_PASSAGE_ALLOWED) ? true : false;
                            receiverId = (int) received[2] & 0xFF;
                            break;
                        case Commands.DISTRIBUTED_PASSAGE_RESPONSE_STRAIGHT:
                            direction = Direction.Straight;
                            isAllowed = (received[1] == Commands.DISTRIBUTED_PASSAGE_ALLOWED) ? true : false;
                            receiverId = (int) received[2] & 0xFF;
                            break;
                        case Commands.DISTRIBUTED_PASSAGE_RESPONSE_DIVERGENT:
                            direction = Direction.Divergent;
                            isAllowed = (received[1] == Commands.DISTRIBUTED_PASSAGE_ALLOWED) ? true : false;
                            receiverId = (int) received[2] & 0xFF;
                            break;
                    }
                    if (direction != null) {
                        if (isAllowed == null) {
                            if (STATUS_LOG_ENABLED) {
                                Rarduino.printLogMessage(getName(), "receivePassage Request " + receiverId + " " + direction);
                            }
                            synchronized (BP_SYNC_OBJECT) {
                                comm.receivePassageRequest(null, receiverId, direction);
                            }
                        } else {
                            if (STATUS_LOG_ENABLED) {
                                Rarduino.printLogMessage(getName(), "receivePassage Response " + receiverId + " " + direction + " isAllowed: " + isAllowed);
                            }
                            synchronized (BP_SYNC_OBJECT) {
                                comm.receivePassageResponse(null, receiverId, isAllowed, direction);
                            }
                        }
                    } else {
                        Rarduino.printErrorMessage(getName(), " Message received without direction being defined. " + String.format("0X%02X", received[0]));
                    }
                }
                synchronized (distributedPackets) {
                    distributedPackets.wait();
                }
            } catch (InterruptedException e) {
                Rarduino.printErrorMessage(getName(), e.getMessage());
                return;
            }
        }
    }
}
