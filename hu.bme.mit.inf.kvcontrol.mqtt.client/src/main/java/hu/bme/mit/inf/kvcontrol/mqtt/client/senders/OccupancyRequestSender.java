package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.FREE;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.OCCUPIED;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getOccupancyPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.mqtt.common.network.RequestSender;
import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.OccupancyPayload;
import hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;

/**
 *
 * @author benedekh
 */
public class OccupancyRequestSender extends RequestSender {

    private final Map<Integer, SectionOccupancyStatus> sectionsOccupied = new ConcurrentHashMap<>();

    public OccupancyRequestSender(MQTTPublisherSubscriber mqtt) throws MqttException {
        super("modes3/kvcontrol/soc", mqtt);
    }

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

    private void updateOccupancies(int occupancy) {
        for (int i = 0x01; i < 0x18; ++i) {
            if (isOccupied(occupancy, i)) {
                sectionsOccupied.put(i, OCCUPIED);
            } else {
                sectionsOccupied.put(i, FREE);
            }
        }
    }

    private boolean isOccupied(long number, int offset) {
        return ((number & (1 << offset)) >> offset) == 1;
    }

}
