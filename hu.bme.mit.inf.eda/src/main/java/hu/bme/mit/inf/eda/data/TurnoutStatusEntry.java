package hu.bme.mit.inf.eda.data;

import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import java.time.LocalDateTime;

/**
 *
 * @author benedekh
 */
public class TurnoutStatusEntry {

    protected LocalDateTime timestamp;
    protected int turnoutId;
    protected TurnoutStatus turnoutStatus;

    public TurnoutStatusEntry(LocalDateTime timestamp, int turnoutId,
            TurnoutStatus turnoutStatus) {
        this.timestamp = timestamp;
        this.turnoutId = turnoutId;
        this.turnoutStatus = turnoutStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(timestamp.toString());
        sb.append(",");
        sb.append(turnoutId);
        sb.append(",");
        sb.append(turnoutStatus);

        return sb.toString();
    }
}
