package hu.bme.mit.inf.kv.yakindu.control.transmitter;

import hu.bme.mit.inf.kv.yakindu.control.controller.IYakinduKVController;
import hu.bme.mit.inf.kv.yakindu.control.helper.Commands;
import hu.bme.mit.inf.kv.yakindu.control.helper.LoggingThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;

/**
 *
 * @author benedekh
 */
public class DistributedMessageTransmitter extends LoggingThread {

    private final BlockingQueue<byte[]> distributedPackets = new LinkedBlockingQueue<>();
    private final IYakinduKVController controller;
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public DistributedMessageTransmitter(IYakinduKVController yakinduController) {
        controller = yakinduController;
    }

    public void addPacket(byte[] packet) {
        distributedPackets.add(packet);
    }

    @Override
    public void run() {
        logMessage("STARTED");
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
                logErrorMessage(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        logErrorMessage("INTERRUPTED");
    }

    private void remSectionLock(final Direction from) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                controller.remSectionLock(from);
                logMessage("received remSectionLock " + from);
            }
        });
    }

    private void remShortSectionLock(final Direction from) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                controller.remShortSectionLock(from);
                logMessage("received short remSectionLock " + from);
            }
        });
    }

    private void remPassageResponse(final byte isAllowedByte,
            final Direction from) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                boolean isAllowed = (isAllowedByte == Commands.DISTRIBUTED_PASSAGE_ALLOWED);
                if (isAllowed) {
                    controller.remPassageAllowed(from);
                    logMessage("received passage allowed " + from);
                } else {
                    controller.remPassageDenied(from);
                    logMessage("received passage denied " + from);
                }
            }
        });
    }
}
