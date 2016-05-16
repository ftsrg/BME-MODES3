package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.data.TimeSettings;
import hu.bme.mit.inf.eda.data.TurnoutStatusEntry;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.TurnoutRequestSender;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import static hu.bme.mit.inf.mqtt.common.data.TurnoutStatus.DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.TurnoutStatus.STRAIGHT;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Collects the turnouts (switches) statuses (straight / divergent) from the
 * railway track.
 *
 * Straight means the switch connects the straight and the top sections.
 * Divergent means the switch connects the divergent and the top sections.
 *
 * @author benedekh
 */
public class TurnoutStatusCollector implements Collector {

    // the IDs of the turnouts (switches) whose status shall be collected
    protected Collection<Integer> turnoutsToBeCollected = new ArrayList<>();

    // timestamp, turnoutId, turnoutStatus (divergent/straight)
    protected List<TurnoutStatusEntry> statusEntries = new ArrayList<>();

    // request sender to acquire status information
    protected TurnoutRequestSender requestSender;

    // it calls us frequently to collect data
    protected CollectorRunnableSlave collectorSlave;

    /**
     * @param dispatcher for which it subscribes on a topic for sections
     * statuses
     * @param timeSettings settings for how long and how frequently the data
     * should be collected
     * @param path the output file path of the collected data
     */
    public TurnoutStatusCollector(MQTTPublishSubscribeDispatcher dispatcher,
            TimeSettings timeSettings, String path) {
        this.requestSender = new TurnoutRequestSender(dispatcher);
        this.collectorSlave = new CollectorRunnableSlave(this, timeSettings,
                path);

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

    @Override
    public void startCollectingData() {
        new Thread(collectorSlave).start();
    }

    @Override
    public void print(PrintWriter writer) {
        writer.append("timestamp,turnout,status");
        writer.flush();

        for (TurnoutStatusEntry entry : statusEntries) {
            writer.append(entry.toString());
            writer.flush();
        }
    }
    
    /**
     * Appends a new turnout status entry to the former ones.
     *
     * @param turnoutId the referred turnout's ID
     * @param status status of the turnout
     */
    protected void addNewStatusEntry(int turnoutId,
            TurnoutStatus status) {
        statusEntries.add(new TurnoutStatusEntry(LocalDateTime.now(),
                turnoutId,
                status));
    }

}
