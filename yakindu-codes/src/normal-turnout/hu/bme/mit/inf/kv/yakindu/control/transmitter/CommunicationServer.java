package hu.bme.mit.inf.kv.yakindu.control.transmitter;

import hu.bme.mit.inf.kv.yakindu.control.helper.LoggingThread;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * @author benedekh
 */
public class CommunicationServer extends LoggingThread {

    private static final int CSERVER_ARDUINO_PORT = 3300;
    private static final int PACKET_SIZE = 64;

    private static boolean CLOUD_INTEGRATION_ENABLED = false;

    private final DistributedMessageTransmitter messageTransmitter;
    private final int port;

    public CommunicationServer(int offset,
            DistributedMessageTransmitter messageTransmitter) {
        port = CSERVER_ARDUINO_PORT + offset;
        this.messageTransmitter = messageTransmitter;
    }

    public static void setCloudIntegrationEnabled(boolean isEnabled) {
        CLOUD_INTEGRATION_ENABLED = isEnabled;
    }

    @Override
    public void run() {
        logMessage("STARTED");
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            while (!Thread.currentThread().isInterrupted()) {
                SocketChannel connectedChannel = serverSocketChannel.accept();
                logMessage("CLIENT CONNECTED");
                while (!Thread.currentThread().isInterrupted()) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(PACKET_SIZE);
                    try {
                        if (connectedChannel.read(byteBuffer) > 0) {
                            byteBuffer.flip();
                            byte[] buffer = byteBuffer.array();
                            if (CLOUD_INTEGRATION_ENABLED) {
                                buffer = transformByteArrayToByteArray(buffer);
                            }
                            messageTransmitter.addPacket(buffer);
                        }
                    } catch (Exception ex) {
                        logErrorMessage(ex.getMessage());
                    }
                }
            }
        } catch (Exception ex) {
            logErrorMessage(ex.getMessage());
        }
        logErrorMessage("STOPPED");
    }

    /**
     * Required for cloud deployment, to integrate with Node-RED. The byte
     * received through the SocketChannel should be transformed with this
     * function.
     */
    private byte[] transformByteArrayToByteArray(byte[] start) {
        byte[] buffer = start;
        String message = new String(buffer); //create a string and separate by ','. this way the byte[] will be represented correctly
        String[] parts = message.split(",");
        buffer = new byte[parts.length];
        for (int i = 0; i < parts.length; ++i) {
            buffer[i] = (byte) Float.valueOf(parts[i])
                    .intValue(); // float -> int -> byte. in this way -127 will be converted as well.
        }
        return buffer;
    }

}
