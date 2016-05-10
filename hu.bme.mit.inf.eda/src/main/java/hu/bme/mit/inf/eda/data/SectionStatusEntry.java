package hu.bme.mit.inf.eda.data;

import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import java.time.LocalDateTime;

/**
 *
 * @author benedekh
 */
public class SectionStatusEntry {

    protected LocalDateTime timestamp;
    protected int sectionId;
    protected SectionStatus sectionStatus;

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
