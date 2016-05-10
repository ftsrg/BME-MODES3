package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.data.SectionStatusEntry;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.SectionRequestSender;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.DISABLED;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.ENABLED;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benedekh
 */
public class SectionStatusCollector implements Collector {

    protected List<Integer> sectionsToBeCollected = new ArrayList<>();

    // timestamp, sectionId, status (enabled/disabled)
    protected List<SectionStatusEntry> statusEntries = new ArrayList<>();

    // request sender to acquire status information
    protected SectionRequestSender requestSender;

    public SectionStatusCollector(SectionRequestSender requestSender) {
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
            boolean isEnabled = requestSender.isSectionEnabled(sectionId);
            if (isEnabled) {
                addNewStatusEntry(sectionId, ENABLED);
            } else {
                addNewStatusEntry(sectionId, DISABLED);
            }
        }
    }

    protected void addNewStatusEntry(int sectionId,
            SectionStatus status) {
        statusEntries.add(new SectionStatusEntry(LocalDateTime.now(),
                sectionId,
                status));
    }
}
