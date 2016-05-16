package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.FREE;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.OCCUPIED;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getOccupancyPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.OccupancyPayload;
import hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus;
import hu.bme.mit.inf.mqtt.common.network.MessageFilter;

/**
 *
 * This class can query the sections occupancy on the railway track.
 *
 * It is based on the section occupancy sensors information provided through the
 * S88 protocol to a dedicated unit which occasionally queries the whole
 * occupancy vector.
 *
 * @author benedekh
 */
public class OccupancyRequestSender implements MessageFilter {

    // the MQTT topic where the occupancy data is transferred
    private static final String topic = "modes3/kvcontrol/soc";

    // the dispatcher for that it subscribes on the referred topic
    private final MQTTPublishSubscribeDispatcher requestSender;

    // the occupancy status of each section, denoted by its ID
    private final Map<Integer, SectionOccupancyStatus> sectionsOccupied = new ConcurrentHashMap<>();

    /**
     * Receives a dispatcher for that it subscribes on the referred topic
     * (@topic field).
     *
     * @param requestSender the dispatcher for that it subscribes
     */
    public OccupancyRequestSender(MQTTPublishSubscribeDispatcher requestSender) {
        this.requestSender = requestSender;
        this.requestSender.subscribe(topic, this);
    }

    /**
     * Tells whether the referred section is occupied.
     *
     * @param sectionId the section's ID whose occupancy is being queried
     * @return true if the section is occupied, false otherwise
     */
    public boolean isSectionOccupied(int sectionId) {
        SectionOccupancyStatus status;
        try {
            status = sectionsOccupied.get(sectionId);
        } catch (NullPointerException ex) {
            status = FREE;
            sectionsOccupied.put(sectionId, status);
        }
        return status == OCCUPIED;
    }

    @Override
    public void filteredMessageArrived(MqttMessage message) {
        try {
            OccupancyPayload payload = getOccupancyPayloadFromMessage(message);
            Command command = payload.getCommand();

            switch (command) {
                case OCCUPANCY:
                    int occupancy = payload.getOccupancyVector();
                    updateOccupancies(occupancy);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(getClass().getName(), ex);
        }
    }

    /**
     * Updates the sections' occupancies based on the received occupancy vector.
     *
     * 1 at the given position of the bitwise version of the number (vector)
     * denotes the section is occupied. 0 at the given position of the bitwise
     * version of the number (vector) denotes the section is free.
     *
     * @param occupancy the vector which stores all sections occupancy
     */
    private void updateOccupancies(int occupancy) {
        for (int i = 0x01; i < 0x18; ++i) {
            if (isOccupied(occupancy, i)) {
                sectionsOccupied.put(i, OCCUPIED);
            } else {
                sectionsOccupied.put(i, FREE);
            }
        }
    }

    /**
     * Tells whether at the given offset of the number there is a 1 or not.
     *
     * @param number the number whose bitwise version will be inspected
     * @param offset the offset on which the value is examined
     * @return true, if at the given offset of the number there is 1
     */
    private boolean isOccupied(long number, int offset) {
        return ((number & (1 << offset)) >> offset) == 1;
    }

}
