package hu.bme.mit.inf.kvcontrol.controllers;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import hu.bme.mit.inf.kvcontrol.interfaces.IController;

/**
 * general controller class for common functionality
 * <p>
 * @author zsoltmazlo
 */
public abstract class AbstractController implements IController {

    /**
     * The port address.
     */
    public static final int port = 3300;

    protected static final int PACKET_SIZE = 64;

    protected final Object heartBeat = new Object();

    protected Thread requester;
    protected Thread receiver;

    protected static Thread commonReceiver;
    private static PacketDispatcher commonDispatcher;

    public AbstractController() {
        if (commonDispatcher == null) {
            commonDispatcher = new PacketDispatcher();
            AbstractController.commonReceiver = new Thread(commonDispatcher);
        }

    }

    @Override
    public void startThreads() {
        if (this.receiver != null) {
            this.receiver.start();
        }
        if (this.requester != null) {
            this.requester.start();
        }
        if (!AbstractController.commonReceiver.isAlive()) {
            AbstractController.commonReceiver.start();
        }
    }

    @Override
    public void sendTCPPacket(int responsibleControllerID, byte[] message)
            throws IOException {
        SocketChannel channel = commonDispatcher.getChannel(responsibleControllerID);
        channel.finishConnect();
        ByteBuffer buffer = ByteBuffer.wrap(message);
        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
        buffer.clear();
    }

    @Override
    public void sendHeartBeat() {
        synchronized (this.heartBeat) {
            this.heartBeat.notifyAll();
        }
    }
}
