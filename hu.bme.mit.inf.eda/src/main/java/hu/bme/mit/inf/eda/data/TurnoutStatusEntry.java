package hu.bme.mit.inf.eda.data;

import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;

import java.time.LocalDateTime;

/**
 * A turnout (switch) status entry.
 *
 * @author benedekh
 */
public class TurnoutStatusEntry {

    // the timestamp of the entry
    protected LocalDateTime timestamp;

    // the referred turnout's ID
    protected int turnoutId;

    // the status of the referred turnout
    protected TurnoutStatus turnoutStatus;

    /**
     * @param timestamp     the timestamp of the entry
     * @param turnoutId     the referred turnout's ID
     * @param turnoutStatus the status of the referred turnout
     */
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
