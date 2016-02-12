package hu.bme.mit.inf.kv.yakindu.control.transmitter;

import hu.bme.mit.inf.kv.yakindu.control.helper.Commands;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import static hu.bme.mit.inf.kv.yakindu.control.sm.handler.DirectionConverterHelper.getValueFromDirection;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import hu.bme.mit.inf.yakindu.mqtt.client.receiver.IDistributedMessageTransmitter;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

/**
 *
 * @author benedekh
 */
public class DistributedMessageTransmitter extends Thread implements IDistributedMessageTransmitter {

    private final BlockingQueue<byte[]> distributedPackets = new LinkedBlockingQueue<>();
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    private final ITurnoutStatemachine statemachine;

    public DistributedMessageTransmitter(ITurnoutStatemachine sm) {
        statemachine = sm;
    }

    @Override
    public void addPacket(byte[] packet) {
        distributedPackets.add(packet);
    }

    @Override
    public void run() {
        logInfoMessage(getClass().getName(), "STARTED");
        while (!isInterrupted()) {
            try {
                byte[] receivedPacket = distributedPackets.take();

                switch (receivedPacket[0]) {
                    case Commands.DISTRIBUTED_PASSAGE_REQUEST_TOP:
                        remSectionLock(Direction.TOP);
                        break;
                    case Commands.DISTRIBUTED_PASSAGE_REQUEST_STRAIGHT:
                        remSectionLock(Direction.STRAIGHT);
                        break;
                    case Commands.DISTRIBUTED_PASSAGE_REQUEST_DIVERGENT:
                        remSectionLock(Direction.DIVERGENT);
                        break;
                    case Commands.DISTRIBUTED_SHORT_PASSAGE_REQUEST_TOP:
                        remShortSectionLock(Direction.TOP);
                        break;
                    case Commands.DISTRIBUTED_SHORT_PASSAGE_REQUEST_STRAIGHT:
                        remShortSectionLock(Direction.STRAIGHT);
                        break;
                    case Commands.DISTRIBUTED_SHORT_PASSAGE_REQUEST_DIVERGENT:
                        remShortSectionLock(Direction.DIVERGENT);
                        break;
                    case Commands.DISTRIBUTED_PASSAGE_RESPONSE_TOP:
                        remPassageResponse(receivedPacket[1], Direction.TOP);
                        break;
                    case Commands.DISTRIBUTED_PASSAGE_RESPONSE_STRAIGHT:
                        remPassageResponse(receivedPacket[1],
                                Direction.STRAIGHT);
                        break;
                    case Commands.DISTRIBUTED_PASSAGE_RESPONSE_DIVERGENT:
                        remPassageResponse(receivedPacket[1],
                                Direction.DIVERGENT);
                        break;
                }
            } catch (InterruptedException e) {
                logException(getClass().getName(), e);
                Thread.currentThread().interrupt();
            }
        }
        logInfoMessage(getClass().getName(), "INTERRUPTED");
    }

    private void remSectionLock(final Direction from) {
        final long directionValue = getValueFromDirection(from);

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                statemachine.getSCITurnout().raiseRemSectionLockFrom(
                        directionValue);
                logInfoMessage(getClass().getName(),
                        "received remSectionLock from " + from);
            }
        });
    }

    private void remShortSectionLock(final Direction from) {
        // deliberately left empty
    }

    private void remPassageResponse(final byte isAllowedByte,
            final Direction from) {
        final long directionValue = getValueFromDirection(from);

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                boolean isAllowed = (isAllowedByte == Commands.DISTRIBUTED_PASSAGE_ALLOWED);
                if (isAllowed) {
                    statemachine.getSCITurnout().raiseRemPassageAllowedFrom(
                            directionValue);
                    logInfoMessage(getClass().getName(),
                            "received passage allowed from " + from);
                } else {
                    statemachine.getSCITurnout().raiseRemPassageDeniedFrom(
                            directionValue);
                    logInfoMessage(getClass().getName(),
                            "received passage denied from " + from);
                }
            }
        });
    }
}
