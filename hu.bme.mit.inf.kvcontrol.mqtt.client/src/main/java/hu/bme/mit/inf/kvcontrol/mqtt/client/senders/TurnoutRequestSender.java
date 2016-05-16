package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.GET_TURNOUT_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.IDENTIFY;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_TURNOUT_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Identity;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionArray;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import static hu.bme.mit.inf.mqtt.common.data.TurnoutStatus.STRAIGHT;
import hu.bme.mit.inf.mqtt.common.network.MessageFilter;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.createCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * This class can query the turnouts (switches) status (straight / divergent) on
 * the railway track.
 *
 * It is based on the turnout (switch) status information provided by the
 * embedded controllers that control the referred switch (turnout).
 *
 * Straight means the switch connects the straight and the top sections.
 * Divergent means the switch connects the divergent and the top sections.
 *
 * @author benedekh
 */
public class TurnoutRequestSender implements MessageFilter {

    // the MQTT topic where the turnout (switch) status data is transferred
    private static final String topic = "modes3/kvcontrol/turnout";

    // the dispatcher for that it subscribes on the referred topic
    private final MQTTPublishSubscribeDispatcher requestSender;

    // is active polling enabled
    private volatile boolean pollingEnabled = false;

    // the status of each turnout (switch), denoted by its ID
    private final Map<Integer, TurnoutStatus> turnoutStatuses = new ConcurrentHashMap<>();

    /**
     * Receives a dispatcher for that it subscribes on the referred topic
     * (@topic field).
     *
     * @param requestSender the dispatcher for that it subscribes
     */
    public TurnoutRequestSender(MQTTPublishSubscribeDispatcher requestSender) {
        this.requestSender = requestSender;
        this.requestSender.subscribe(topic, this);
        this.sendIdentify();
    }

    /**
     * Enables or disables the status polling. If disabled it does not send any
     * request to the embedded controller, instead it waits for the turnout
     * (switch) status change notification from the controllers.
     *
     * If the polling is enabled then the embedded controllers will be queried
     * through the topic. It may generate a lot of network packets if the query
     * is done frequently. So do not use it directly (disable it), and in that
     * way the embedded controller will always send the latest status
     * information to the topic (change notification like approach).
     *
     * @param isPollingEnabled set the polling enabled or not
     */
    public void setPollingEnabled(boolean isPollingEnabled) {
        this.pollingEnabled = isPollingEnabled;
    }

    /**
     * Tells if the referred turnout is divergent (connects the top and the
     * divergent sections).
     *
     * @param turnoutId the referred turnout (switch)
     * @return true, if the referred turnout (switch) is divergent, false
     * otherwise.
     */
    public boolean isTurnoutDivergent(int turnoutId) {
        return !isTurnoutStraight(turnoutId);
    }

    /**
     * Tells if the referred turnout is straight (connects the top and the
     * straight sections).
     *
     * @param turnoutId the referred turnout (switch)
     * @return true, if the referred turnout (switch) is straight, false
     * otherwise.
     */
    public boolean isTurnoutStraight(int turnoutId) {
        if (!turnoutStatuses.containsKey(turnoutId)) {
            turnoutStatuses.put(turnoutId, STRAIGHT);
        }

        if (pollingEnabled) {
            Turnout turnout = new Turnout(turnoutId);
            Payload payload = createCommandWithContent(GET_TURNOUT_STATUS,
                    turnout);
            requestSender.publishMessage(payload, topic);
        }

        TurnoutStatus status = turnoutStatuses.get(turnoutId);
        return status == STRAIGHT;
    }

    /**
     * Sends an identify message to the topic, so every embedded controller
     * responds the controlled turnouts (switches) statuses.
     */
    public void sendIdentify() {
        Turnout dummyTurnout = new Turnout(0x01);
        Section dummySection = new Section(0x01);
        SectionArray dummyArray = new SectionArray(new Section[]{dummySection});
        Identity identity = new Identity(dummyTurnout, dummyArray);
        Payload payload = createCommandWithContent(IDENTIFY, identity);
        requestSender.publishMessage(payload, topic);
    }

    @Override
    public void filteredMessageArrived(MqttMessage message) {
        try {
            Payload payload = getPayloadFromMessage(message);
            Command command = payload.getCommand();

            switch (command) {
                case SEND_TURNOUT_STATUS:
                    Turnout turnout = payload.getContentAs(Turnout.class);
                    turnoutStatuses.put(turnout.getId(), turnout.getStatus());
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(getClass().getName(), ex);
        }
    }

}
