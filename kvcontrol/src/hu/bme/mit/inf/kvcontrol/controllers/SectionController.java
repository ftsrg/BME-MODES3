package hu.bme.mit.inf.kvcontrol.controllers;

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
import hu.bme.mit.inf.kvcontrol.interfaces.ISectionController;

/**
 * A controller for handling all sections status defined in sections.ini
 * <p>
 *
 * @author zsoltmazlo, benedekh
 */
public class SectionController extends AbstractController implements
        ISectionController {

    private final ConcurrentMap<String, Section> sections;

    private final Requester requesterObject;
    private final Recevier receiverObject;

    public SectionController() {
        super();
        sections = Relations.getSections();
        requesterObject = new Requester(this.heartBeat);
        requester = new Thread(requesterObject);
        receiverObject = new Recevier(this.heartBeat);
        receiver = new Thread(receiverObject);
    }

    @Override
    public void setSectionEnabled(int sectionID) throws NotFoundException {
        Section section = sections.get(Relations.getKey(sectionID));
        if (section != null) {
            if (!section.isEnabled()) {
                this.sendSectionCommand(section, Commands.COMMAND_LINE_ENABLE);
                section.setIsEnabled(true);
                Logger.getLogger(SectionController.class.getName())
                        .log(Level.SEVERE, null, "Section " + sectionID
                                + " becomes enabled.");
            }
        } else {
            throw new NotFoundException(String.format(
                    "Section with %d ID is not found!", sectionID));
        }
    }

    @Override
    public void setSectionDisabled(int sectionID) throws NotFoundException {
        Section section = sections.get(Relations.getKey(sectionID));
        if (section != null) {
            if (section.isEnabled()) {
                this.sendSectionCommand(section, Commands.COMMAND_LINE_DISABLE);
                section.setIsEnabled(false);
                Logger.getLogger(SectionController.class.getName())
                        .log(Level.SEVERE, null, "Section " + sectionID
                                + " becomes disabled.");
            }
        } else {
            throw new NotFoundException(String.format(
                    "Section with %d ID is not found!", sectionID));
        }
    }

    @Override
    public boolean isSectionEnabled(int sectionID) throws NotFoundException {
        Section section = sections.get(Relations.getKey(sectionID));
        if (section != null) {
            return section.isEnabled();
        } else {
            throw new NotFoundException(String.format(
                    "Section with %d ID is not found!", sectionID));
        }
    }

    /**
     * Sends an UDP message to the selected section's controller. The content of
     * the message depends on the command.
     *
     * @param section the selected section, whose controller should be contacted
     * @param command the command to be sent to the section's controller
     */
    private void sendSectionCommand(Section section, byte command) {
        try {
            int controllerID = section.getResponsibleControllerID();
            byte[] message = new byte[]{command, (byte) section.getID()};
            sendTCPPacket(controllerID, message);
        } catch (java.net.NoRouteToHostException | java.nio.channels.NotYetConnectedException | java.nio.channels.ClosedChannelException e) {
            handleConnectionError(e);
        } catch (Exception ex) {
            Logger.getLogger(SectionController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Receives and stores the sections' status frequently, whether they are
     * enabled.
     */
    private class Recevier extends IController.RunnableStub {

        private final BlockingQueue<byte[]> packets = PacketsContainer.sectionPackets;

        public Recevier(Object syncObject) {
            super(syncObject);
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    byte[] received = packets.take();
                    switch (received[0]) {
                        case Commands.COMMAND_SEND_SECTION_STATUS:
                            String key = Relations.getKey(received[1]);
                            Section section = sections.get(key);
                            if (section != null) {
                                if (received[2] == 0) {
                                    section.setIsEnabled(true);
                                } else {
                                    section.setIsEnabled(false);
                                }
                                sections.put(key, section);
                            }
                            break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(SectionController.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Polls the sections' frequently, whether they are enabled.
     */
    private class Requester extends IController.RunnableStub {

        public Requester(Object syncObject) {
            super(syncObject);
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    for (String sectionID : sections.keySet()) {
                        sendSectionCommand(sections.get(sectionID),
                                Commands.COMMAND_GET_SECTION_STATUS);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(SectionController.class.getName()).log(
                            Level.SEVERE, null, ex);
                }

                synchronized (this.heartBeat) {
                    try {
                        this.heartBeat.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SectionController.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
