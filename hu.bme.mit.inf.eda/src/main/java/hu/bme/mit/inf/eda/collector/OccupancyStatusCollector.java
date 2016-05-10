package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.data.SectionOccupancyStatusEntry;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.OccupancyRequestSender;
import hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.FREE;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.OCCUPIED;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benedekh
 */
public class OccupancyStatusCollector implements Collector {

    protected List<Integer> sectionsToBeCollected = new ArrayList<>();

    // timestamp, sectionId, occupancyStatus (occupied/free)
    protected List<SectionOccupancyStatusEntry> statusEntries = new ArrayList<>();

    // request sender to acquire status information
    protected OccupancyRequestSender requestSender;

    public OccupancyStatusCollector(OccupancyRequestSender requestSender) {
        this.requestSender = requestSender;
        
        for (int i = 0x01; i < 0x18; ++i) {
            // sections with ID 0x07 or 0x12 do not exist
            if (i != 0x07 && i != 0x12) {
                sectionsToBeCollected.add(i);
            }
        }
    }

    @Override
    public void collect() {
        for (Integer sectionId : sectionsToBeCollected) {
            boolean isOccupied = requestSender.isSectionOccupied(sectionId);
            if (isOccupied) {
                addNewStatusEntry(sectionId, OCCUPIED);
            } else {
                addNewStatusEntry(sectionId, FREE);
            }
        }
    }

    protected void addNewStatusEntry(int sectionId,
            SectionOccupancyStatus status) {
        statusEntries.add(new SectionOccupancyStatusEntry(LocalDateTime.now(),
                sectionId,
                status));
    }

}
