package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.data.CollectionTimeSettings;
import hu.bme.mit.inf.eda.data.SectionOccupancyStatusEntry;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.OccupancyRequestSender;
import hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.FREE;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.OCCUPIED;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author benedekh
 */
public class OccupancyStatusCollector implements Collector {

    protected Collection<Integer> sectionsToBeCollected = new ArrayList<>();

    // timestamp, sectionId, occupancyStatus (occupied/free)
    protected List<SectionOccupancyStatusEntry> statusEntries = new ArrayList<>();

    // request sender to acquire status information
    protected OccupancyRequestSender requestSender;

    // it calls us frequently to collect data
    protected CollectorRunnableSlave collectorSlave;

    public OccupancyStatusCollector(MQTTPublishSubscribeDispatcher dispatcher,
            CollectionTimeSettings timeSettings, String path) {
        this.requestSender = new OccupancyRequestSender(dispatcher);
        this.collectorSlave = new CollectorRunnableSlave(this, timeSettings,
                path);

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

    @Override
    public void startCollectingData() {
        new Thread(collectorSlave).start();
    }

    @Override
    public void print(PrintWriter writer) {
        writer.append("timestamp,section,occupancy");
        writer.flush();

        for (SectionOccupancyStatusEntry entry : statusEntries) {
            writer.append(entry.toString());
            writer.flush();
        }
    }

    protected void addNewStatusEntry(int sectionId,
            SectionOccupancyStatus status) {
        statusEntries.add(new SectionOccupancyStatusEntry(LocalDateTime.now(),
                sectionId,
                status));
    }

}
