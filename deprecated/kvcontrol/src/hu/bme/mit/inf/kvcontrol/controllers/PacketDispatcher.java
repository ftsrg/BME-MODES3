package hu.bme.mit.inf.kvcontrol.controllers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import hu.bme.mit.inf.kvcontrol.data.Commands;
import hu.bme.mit.inf.kvcontrol.data.Relations;
import hu.bme.mit.inf.kvcontrol.entities.Section;
import hu.bme.mit.inf.kvcontrol.entities.Turnout;

import static hu.bme.mit.inf.kvcontrol.controllers.AbstractController.PACKET_SIZE;
import static hu.bme.mit.inf.kvcontrol.data.PacketsContainer.turnoutPackets;
import static hu.bme.mit.inf.kvcontrol.data.PacketsContainer.sectionPackets;
import static hu.bme.mit.inf.kvcontrol.data.PacketsContainer.occupancyPackets;

/**
 * This class is responsible for handling all UDP packets which send to the host
 * and dispatch them to the controller threads.
 * <p>
 *
 * @author zsoltmazlo, benedekh
 */
public class PacketDispatcher implements Runnable {

    private volatile boolean isRunning = true;

    // Contains the Sockets who we need to connect to.
    private ConcurrentMap<Integer, SocketChannel> socketContainer;

    // Contains the selector for multiplexing purposes.
    private Selector selector;

    public PacketDispatcher() {
        try {

            socketContainer = new ConcurrentHashMap<>();

            // create a selector that will by used for multiplexing. The selector
            // registers the socketchannels that are created
            selector = Selector.open();

            // fill the socketContainer with new SocketChannels
            for (Map.Entry<String, Section> sectionEntry : Relations.getSections().entrySet()) {
                int responsibleControllerID = sectionEntry.getValue().getPhysicalAddress();
                createSocketChannelToSocketContainer(responsibleControllerID);
            }
            for (Map.Entry<String, Turnout> turnoutEntry : Relations.getTurnouts().entrySet()) {
                int responsibleControllerID = turnoutEntry.getValue().getPhysicalAddress();
                createSocketChannelToSocketContainer(responsibleControllerID);
            }

            // insert the SectionOccupancyCollector to the socketContainer (IP 160)
            createSocketChannelToSocketContainer(160);

        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Get channel according to its controller ID.
     *
     * @param responsibleControllerID the Controller's ID
     * @return the SocketChannel that connects to the Controller
     */
    public SocketChannel getChannel(int responsibleControllerID) {
        return socketContainer.get(responsibleControllerID);
    }

    /**
     * Create a new SocketChannel and place it in the socketContainer.
     *
     * @param responsibleControllerID the ID of the responsible controller for
     * the section or the turnout
     * @throws IOException if an I/O error occurs
     */
    private void createSocketChannelToSocketContainer(
            int responsibleControllerID) throws IOException {
        if (!socketContainer.containsKey(responsibleControllerID)) {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false); // set the client connection to be non blocking
            channel.connect(new InetSocketAddress(
                    "192.168.1." + responsibleControllerID, 3300));
            // set the selection key, and register the channel to the selector, so for each channel.read event, the selector can select this channel
            channel.register(selector, SelectionKey.OP_READ);
            socketContainer.put(responsibleControllerID, channel);
        }
    }

    @Override
    public void run() {

        while (isRunning) {
            // the select method is a blocking method which returns when at least
            // one of the registered channel is selected. In this example, when the socket accepts a
            // new connection, this method will return. Once a socketclient is added to the list of
            // registered channels, then this method
            // would also return when one of the clients has data to be read or
            // written. It is also possible to perform a nonblocking select
            // using the selectNow() function.
            // We can also specify the maximum time for which a select function
            // can be blocked using the select(long timeout) function.

            try {
                if (selector.select() == 0) {
                    continue;
                }
                // the select method returns with a list of selected keys
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    SocketChannel connectedChannel = (SocketChannel) key.channel();

                    ByteBuffer byteBuffer = ByteBuffer.allocate(PACKET_SIZE);
                    if (key.isReadable()) {
                        try {
                            if (connectedChannel.read(byteBuffer) > 0) {
                                byteBuffer.flip();
                                byte[] buffer = byteBuffer.array();
                                switch (buffer[0]) {
                                    case Commands.COMMAND_SEND_TURNOUT_STATUS:
                                        turnoutPackets.add(buffer);
                                        break;
                                    case Commands.COMMAND_SEND_SECTION_STATUS:
                                        sectionPackets.add(buffer);
                                        break;
                                    case Commands.COMMAND_SEND_OCCUPANCY:
                                        occupancyPackets.add(buffer);
                                        break;
                                }
                            }
                        } catch (java.net.NoRouteToHostException | java.nio.channels.NotYetConnectedException | java.nio.channels.ClosedChannelException e) {
//                        handleConnectionError(e);
                            // maradjon silent ez, hiszen ez a kapott csomagokat intézi

                        } catch (IOException ex) {
                            Logger.getLogger(PacketDispatcher.class.getName()).log(
                                    Level.SEVERE, null, ex);
                        }
                    }
                    byteBuffer.clear();
                    iterator.remove();
                }

            } catch (IOException ex) {
                Logger.getLogger(PacketDispatcher.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Make the thread stop.
     */
    public void stop() {
        isRunning = false;
    }

    @Override
    protected void finalize() throws Throwable {
        stop();
        for (Map.Entry<Integer, SocketChannel> sockets : socketContainer.entrySet()) {
            sockets.getValue().shutdownOutput();
            sockets.getValue().shutdownInput();
            sockets.getValue().close();
        }
    }

}
