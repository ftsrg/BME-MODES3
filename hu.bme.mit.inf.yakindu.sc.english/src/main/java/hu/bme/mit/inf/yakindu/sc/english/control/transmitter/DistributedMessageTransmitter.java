package hu.bme.mit.inf.yakindu.sc.english.control.transmitter;

import hu.bme.mit.inf.yakindu.sc.english.control.helper.Commands;
import static hu.bme.mit.inf.yakindu.sc.english.control.sm.handler.DirectionConverterHelper.getValueFromDirection;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import hu.bme.mit.inf.yakindu.mqtt.client.receiver.IDistributedMessageTransmitter;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

/**
 * The message handler that transmits the messages TO the statecharts FROM the
 * MQTT.
 *
 * @author benedekh
 */
public class DistributedMessageTransmitter extends Thread implements IDistributedMessageTransmitter {

    // the received packets over MQTT
    private final BlockingQueue<byte[]> distributedPackets = new LinkedBlockingQueue<>();
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    // the statemachine's interface
    private final ITurnoutStatemachine statemachine;

    public DistributedMessageTransmitter(ITurnoutStatemachine sm) {
        statemachine = sm;
    }

    @Override
    public void addPacket(byte[] packet) {
        distributedPackets.add(packet);
    }

    /**
     * Get the latest packets and convert them to statechart specific events
     * with parameters.
     */
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

    /**
     * Remote section lock received from the referred direction.
     *
     * @param from the direction from the remote section lock was received
     */
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

    /**
     * Remote short section lock received from the referred direction.
     *
     * @param from the direction from the remote short section lock was received
     */
    private void remShortSectionLock(final Direction from) {
        final long directionValue = getValueFromDirection(from);

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                statemachine.getSCITurnout().raiseRemShortSectionLockFrom(
                        directionValue);
                logInfoMessage(getClass().getName(),
                        "received remShortSectionLock from " + from);
            }
        });
    }

    /**
     * Remote passage response received from the referred direction.
     *
     * @param isAllowedByte the byte value denoting the passage is allowed or
     * not
     * @param from the direction from the remote passage response was received
     */
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
