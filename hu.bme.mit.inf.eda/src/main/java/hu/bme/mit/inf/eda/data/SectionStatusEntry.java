package hu.bme.mit.inf.eda.data;

import hu.bme.mit.inf.mqtt.common.data.SectionStatus;

import java.time.LocalDateTime;

/**
 * A section status entry.
 *
 * @author benedekh
 */
public class SectionStatusEntry {

    // the timestamp of the entry
    protected LocalDateTime timestamp;

    // the referred section's ID
    protected int sectionId;

    // the status of the referred section
    protected SectionStatus sectionStatus;

    /**
     * @param timestamp     the timestamp of the entry
     * @param sectionId     the referred section's ID
     * @param sectionStatus the status of the referred section
     */
    public SectionStatusEntry(LocalDateTime timestamp, int sectionId,
                              SectionStatus sectionStatus) {
        this.timestamp = timestamp;
        this.sectionId = sectionId;
        this.sectionStatus = sectionStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(timestamp.toString());
        sb.append(",");
        sb.append(sectionId);
        sb.append(",");
        sb.append(sectionStatus);

        return sb.toString();
    }

}
