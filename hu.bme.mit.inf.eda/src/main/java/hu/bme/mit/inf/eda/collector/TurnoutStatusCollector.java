package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.data.TurnoutStatusEntry;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.TurnoutRequestSender;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import static hu.bme.mit.inf.mqtt.common.data.TurnoutStatus.DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.TurnoutStatus.STRAIGHT;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benedekh
 */
public class TurnoutStatusCollector implements Collector {

    protected List<Integer> turnoutsToBeCollected = new ArrayList<>();

    // timestamp, turnoutId, turnoutStatus (divergent/straight)
    protected List<TurnoutStatusEntry> statusEntries = new ArrayList<>();

    // request sender to acquire status information
    protected TurnoutRequestSender requestSender;

    public TurnoutStatusCollector(TurnoutRequestSender requestSender) {
        this.requestSender = requestSender;

        for (int i = 0x81; i <= 0x87; ++i) {
            turnoutsToBeCollected.add(i);
        }
    }

    @Override
    public void collect() {
        for (Integer turnoutId : turnoutsToBeCollected) {
            boolean isStraight = requestSender.isTurnoutStraight(turnoutId);
            if (isStraight) {
                addNewStatusEntry(turnoutId, STRAIGHT);
            } else {
                addNewStatusEntry(turnoutId, DIVERGENT);
            }
        }
    }

    protected void addNewStatusEntry(int turnoutId,
            TurnoutStatus status) {
        statusEntries.add(new TurnoutStatusEntry(LocalDateTime.now(),
                turnoutId,
                status));
    }

}
