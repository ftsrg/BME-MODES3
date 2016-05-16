package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.data.TimeSettings;
import hu.bme.mit.inf.eda.data.SectionStatusEntry;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.SectionRequestSender;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.DISABLED;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.ENABLED;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Collects the sections statuses (disabled / enabled) from the railway track.
 *
 * Disabled means no train can move on that section. Enabled means anyone can go
 * on that section.
 *
 * @author benedekh
 */
public class SectionStatusCollector implements Collector {

    // the IDs of the sections whose status shall be collected
    protected Collection<Integer> sectionsToBeCollected = new ArrayList<>();

    // timestamp, sectionId, status (enabled/disabled)
    protected List<SectionStatusEntry> statusEntries = new ArrayList<>();

    // request sender to acquire status information
    protected SectionRequestSender requestSender;

    // it calls us frequently to collect data
    protected CollectorRunnableSlave collectorSlave;

    /**
     * @param dispatcher for which it subscribes on a topic for sections
     * statuses
     * @param timeSettings settings for how long and how frequently the data
     * should be collected
     * @param path the output file path of the collected data
     */
    public SectionStatusCollector(MQTTPublishSubscribeDispatcher dispatcher,
            TimeSettings timeSettings, String path) {
        this.requestSender = new SectionRequestSender(dispatcher);
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
            boolean isEnabled = requestSender.isSectionEnabled(sectionId);
            if (isEnabled) {
                addNewStatusEntry(sectionId, ENABLED);
            } else {
                addNewStatusEntry(sectionId, DISABLED);
            }
        }
    }

    @Override
    public void startCollectingData() {
        new Thread(collectorSlave).start();
    }

    @Override
    public void print(PrintWriter writer) {
        writer.append("timestamp,section,status");
        writer.flush();

        for (SectionStatusEntry entry : statusEntries) {
            writer.append(entry.toString());
            writer.flush();
        }
    }
    
    /**
     * Appends a new section status entry to the former ones.
     *
     * @param sectionId the referred section's ID
     * @param status status of the section
     */
    protected void addNewStatusEntry(int sectionId,
            SectionStatus status) {
        statusEntries.add(new SectionStatusEntry(LocalDateTime.now(),
                sectionId,
                status));
    }
}
