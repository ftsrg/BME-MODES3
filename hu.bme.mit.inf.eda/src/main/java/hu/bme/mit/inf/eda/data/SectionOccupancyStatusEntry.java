package hu.bme.mit.inf.eda.data;

import hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus;
import java.time.LocalDateTime;

/**
 *
 * @author benedekh
 */
public class SectionOccupancyStatusEntry {

    protected LocalDateTime timestamp;
    protected int sectionId;
    protected SectionOccupancyStatus occupancyStatus;

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
