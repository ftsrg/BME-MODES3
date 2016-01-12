package hu.bme.mit.inf.kvcontrol.controllers;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static hu.bme.mit.inf.kvcontrol.CommandServer.handleConnectionError;

import hu.bme.mit.inf.kvcontrol.data.Commands;
import hu.bme.mit.inf.kvcontrol.data.PacketsContainer;
import hu.bme.mit.inf.kvcontrol.data.Relations;
import hu.bme.mit.inf.kvcontrol.entities.Section;
import hu.bme.mit.inf.kvcontrol.exceptions.NotFoundException;
import hu.bme.mit.inf.kvcontrol.interfaces.IController;
import hu.bme.mit.inf.kvcontrol.interfaces.IOccupancyController;

/**
 * A controller for handling all sections occupancy.
 * <p>
 *
 * @author zsoltmazlo, benedekh
 */
public class OccupancyController extends AbstractController implements
        IOccupancyController {

    private volatile int occupancyVector;

    public static class OccupancyProcessor {

        private final ConcurrentMap<String, Section> sections;

        public OccupancyProcessor() {
            sections = Relations.getSections();
        }

        public void refreshOccupancies(int vector) {
            for (Map.Entry<String, Section> sectionEntry : sections
                    .entrySet()) {
                Section section = sectionEntry.getValue();
                if (getBit(vector, section.getID()) == 1) {
                    section.setIsOccupied(true);
                } else {
                    section.setIsOccupied(false);
                }
                sections.put(sectionEntry.getKey(), section);
            }
        }

        public boolean isSectionOccupied(int sectionID) throws NotFoundException {
            Section section = sections.get(Relations.getKey(sectionID));
            if (section != null) {
                return section.isOccupied();
            } else {
                throw new NotFoundException(String.format(
                        "Section with %d ID is not found!", sectionID));
            }
        }

        private int getBit(long number, int offset) {
            return ((number & (1 << offset)) >> offset) == 1 ? 1 : 0;
        }
    }

    private final OccupancyProcessor processor;

    public OccupancyController() {
        super();
        requester = new Thread(new Requester(this.heartBeat));
        receiver = new Thread(new Recevier(this.heartBeat));
        occupancyVector = 0;
        processor = new OccupancyProcessor();

    }

    @Override
    public boolean isSectionOccupied(int sectionID) throws NotFoundException {
        return processor.isSectionOccupied(sectionID);
    }

    @Override
    public int getOccupancyVector() {
        return this.occupancyVector;
    }

    /**
     * Receives the sections' occupancy, and sets the sections occupancy
     * according to it.
     */
    private class Recevier extends IController.RunnableStub {

        private final BlockingQueue<byte[]> packets = PacketsContainer.occupancyPackets;

        public Recevier(Object syncObject) {
            super(syncObject);
        }

        private int getOccupancyVector(byte[] received) {
            int[] receivedInt = new int[4];

            for (int i = 1; i < 5; i++) {
                receivedInt[i - 1] = ((int) received[i] & 0xFF);
            }

            int occupancy = (receivedInt[3] << 24) | (receivedInt[2] << 16)
                    | (receivedInt[1] << 8) | (receivedInt[0]);

            return occupancy;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    byte[] received = packets.take();
                    switch (received[0]) {
                        case Commands.COMMAND_SEND_OCCUPANCY:
                            occupancyVector = getOccupancyVector(received);
                            processor.refreshOccupancies(occupancyVector);
                            break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(OccupancyController.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Polls the sections' frequently, whether they are occupied.
     */
    private class Requester extends IController.RunnableStub {

        private static final int SECTION_OCCUPANCY_CONTROLLER_ID = 160;

        /**
         * SectionOccupancyCollector's address. controllerAddress =
         * InetAddress.getByName("192.168.1.160");
         */
        public Requester(Object syncObject) {
            super(syncObject);
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    byte[] message = new byte[]{(byte) Commands.COMMAND_GET_OCCUPANCY};
                    sendTCPPacket(SECTION_OCCUPANCY_CONTROLLER_ID, message);
                    Thread.sleep(10);
                } catch (java.net.NoRouteToHostException | java.nio.channels.NotYetConnectedException e) {
                    handleConnectionError(e);
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(OccupancyController.class.getName()).log(
                            Level.SEVERE, null, ex);
                }

                synchronized (this.heartBeat) {
                    try {
                        this.heartBeat.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(OccupancyController.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
