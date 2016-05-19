package hu.bme.mit.inf.eda.data;

import hu.bme.mit.inf.mqtt.common.data.TrainCV;
import hu.bme.mit.inf.mqtt.common.data.TrainsCV;
import java.time.LocalDateTime;

/**
 * A trains status entry based on information acquired from CV (Computer
 * vision).
 *
 * @author benedekh
 */
public class TrainsCVEntry {

    // the timestamp of the entry
    protected LocalDateTime timestamp;

    // latest trains status information
    protected TrainsCV latestStatus;

    public TrainsCVEntry(LocalDateTime timestamp, TrainsCV latestStatus) {
        this.timestamp = timestamp;
        this.latestStatus = latestStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (TrainCV latestTrainCVStatus : latestStatus.getTrains()) {
            sb.append(timestamp.toString());
            sb.append(",");
            sb.append(latestTrainCVStatus.getID());
            sb.append(",");
            sb.append(latestTrainCVStatus.getX());
            sb.append(",");
            sb.append(latestTrainCVStatus.getY());
            sb.append(",");
            sb.append(latestTrainCVStatus.getSpeed());
            sb.append(",");
            sb.append(latestTrainCVStatus.getDirection());
            sb.append("\n");
        }

        // remove trailing line break
        String trimmed = sb.toString().trim();

        return trimmed;
    }

}
