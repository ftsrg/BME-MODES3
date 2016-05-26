package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.data.SectionOccupancyStatusEntry;
import hu.bme.mit.inf.eda.util.TimeSettings;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.OccupancyRequestSender;
import hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import static hu.bme.mit.inf.eda.collector.SectionStatusCollector.LAST_VALID_SECTION_ID;
import static hu.bme.mit.inf.eda.collector.SectionStatusCollector.NON_EXISTANT_SECTIONS;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.FREE;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.OCCUPIED;

/**
 * Collects the sections occupancies (occupied / free) from the railway track.
 *
 * @author benedekh
 */
public class OccupancyStatusCollector implements Collector {

    // the IDs of the sections whose occupancy status shall be collected
    protected Collection<Integer> sectionsToBeCollected = new ArrayList<>();

    // timestamp, sectionId, occupancyStatus (occupied/free)
    protected Collection<SectionOccupancyStatusEntry> statusEntries = new ArrayList<>();

    // request sender to acquire status information
    protected OccupancyRequestSender requestSender;

    // it calls us frequently to collect data
    protected CollectorRunnableSlave collectorSlave;

    /**
     * @param dispatcher   for which it subscribes on a topic for sections
     *                     occupancies
     * @param timeSettings settings for how long and how frequently the data
     *                     should be collected
     * @param path         the output file path of the collected data
     */
    public OccupancyStatusCollector(MQTTPublishSubscribeDispatcher dispatcher,
                                    TimeSettings timeSettings, String path) {
        requestSender = new OccupancyRequestSender(dispatcher);
        collectorSlave = new CollectorRunnableSlave(this, timeSettings,
                path);

        for (int i = 0x01; i <= LAST_VALID_SECTION_ID; ++i) {
            if (!NON_EXISTANT_SECTIONS.contains(i)) {
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
        writer.println("timestamp,section,occupancy");
        writer.flush();

        for (SectionOccupancyStatusEntry entry : statusEntries) {
            writer.println(entry);
            writer.flush();
        }
    }

    /**
     * Appends a new section occupancy status entry to the former ones.
     *
     * @param sectionId the referred section's ID
     * @param status    the occupancy status of the section
     */
    protected void addNewStatusEntry(int sectionId,
                                     SectionOccupancyStatus status) {
        statusEntries.add(new SectionOccupancyStatusEntry(LocalDateTime.now(),
                sectionId,
                status));
    }

}
