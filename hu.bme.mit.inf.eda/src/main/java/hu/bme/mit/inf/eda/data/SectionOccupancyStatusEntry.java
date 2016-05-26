package hu.bme.mit.inf.eda.data;

import hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus;

import java.time.LocalDateTime;

/**
 * A section occupancy status entry.
 *
 * @author benedekh
 */
public class SectionOccupancyStatusEntry {

    // the timestamp of the entry
    protected LocalDateTime timestamp;

    // the referred section's ID
    protected int sectionId;

    // the occupancy status of the referred section
    protected SectionOccupancyStatus occupancyStatus;

    /**
     * @param timestamp       the timestamp of the entry
     * @param sectionId       the referred section's ID
     * @param occupancyStatus the occupancy status of the referred section
     */
    public SectionOccupancyStatusEntry(LocalDateTime timestamp, int sectionId,
                                       SectionOccupancyStatus occupancyStatus) {
        this.timestamp = timestamp;
        this.sectionId = sectionId;
        this.occupancyStatus = occupancyStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(timestamp.toString());
        sb.append(",");
        sb.append(sectionId);
        sb.append(",");
        sb.append(occupancyStatus);

        return sb.toString();
    }
}
