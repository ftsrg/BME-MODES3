package hu.bme.mit.inf.bpcontrol;

import static hu.bme.mit.inf.bpcontrol.transmitters.DistributedMessageTransmitter.distributedPackets;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import bpcontrol.components.Rarduino;
import static bpcontrol.components.Rarduino.BP_SYNC_OBJECT;
import interfaces.ICommunicationFromProvider;

public class BPServer extends NotifyingThread {

    private static final int BPSERVER_ARDUINO_PORT = 3300;
    private static final int PACKET_SIZE = 64;

    private final ICommunicationFromProvider comm;
    private final int port;

    public BPServer(ICommunicationFromProvider comm, int offset) {
        this.comm = comm;
        this.port = BPSERVER_ARDUINO_PORT + offset;
    }

    @Override
    public void doRun() {
        Rarduino.printErrorMessage(getName(), "STARTED");

        synchronized (BP_SYNC_OBJECT) {
            comm.resetSm(null);
        }

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.socket().bind(new InetSocketAddress(port));

            while (!Thread.currentThread().isInterrupted()) {
                SocketChannel connectedChannel = serverSocketChannel.accept();
                while (!Thread.currentThread().isInterrupted()) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(PACKET_SIZE);
                    try {
                        if (connectedChannel.read(byteBuffer) > 0) {
                            byteBuffer.flip();
                            byte[] buffer = byteBuffer.array();
                            distributedPackets.add(buffer);
                            synchronized (distributedPackets) {
                                distributedPackets.notify();
                            }
                        }
                    } catch (Exception ex) {
                        Rarduino.printErrorMessage(getName(), ex.getMessage());
                    }
                }
            }
        } catch (Exception ex) {
            Rarduino.printErrorMessage(getName(), ex.getMessage());
        }
    }
}
