package hu.bme.mit.inf.kvcontrol.bpextension.communication;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PacketSender {

    private PrintStream logger;
    private ConcurrentMap<Integer, SocketChannel> socketContainer;

    public PacketSender(List<String> turnouts, PrintStream logger) {
        this.logger = logger;
        socketContainer = new ConcurrentHashMap<>();

        for (String turnout : turnouts) {
            String[] parts = turnout.split(";");
            int turnoutID = Integer.parseInt(parts[0].substring(2), 16);
            String[] ipAndPort = parts[1].split(":");
            String ip = ipAndPort[0];
            int port = Integer.parseInt(ipAndPort[1]);

            try {
                SocketChannel channel = SocketChannel.open();
                channel.configureBlocking(true);
                channel.connect(new InetSocketAddress(ip, port));
                socketContainer.put(turnoutID, channel);
            } catch (IOException ex) {
                logger.println("[PACKET SENDER EXCEPTION] " + ex.getMessage());
            }
        }
    }

    public void sendTCPPacket(int turnoutID, byte[] message) {
        try {
            SocketChannel channel = socketContainer.get(turnoutID);
            if (channel == null) {
                logger.println(
                        "[PACKET SENDER ERROR] cannot find address " + turnoutID);
                return;
            }
            synchronized (channel) {
                channel.finishConnect();
                ByteBuffer buffer = ByteBuffer.wrap(message);
                while (buffer.hasRemaining()) {
                    channel.write(buffer);
                }
                buffer.clear();
            }
            logger.println(
                    "[PACKET SENDER INFO] " + "packet sent to " + String.format(
                            "0X%02X", turnoutID));
        } catch (IOException ex) {
            logger.println("[PACKET SENDER EXCEPTION] " + ex.getMessage());
        }
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            for (Map.Entry<Integer, SocketChannel> sockets : socketContainer.entrySet()) {
                sockets.getValue().shutdownOutput();
                sockets.getValue().shutdownInput();
                sockets.getValue().close();
            }
        } finally {
            super.finalize();
        }
    }

}
