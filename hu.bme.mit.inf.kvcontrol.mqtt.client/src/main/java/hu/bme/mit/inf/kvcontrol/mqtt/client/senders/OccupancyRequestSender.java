package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_OCCUPANCY;
import hu.bme.mit.inf.mqtt.common.data.OccupancyVector;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.FREE;
import static hu.bme.mit.inf.mqtt.common.data.SectionOccupancyStatus.OCCUPIED;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.util.ClientIdGenerator.generateId;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class OccupancyRequestSender implements MqttCallback {

    // the object subscribes as a callback for this sender in the constuctor
    private final MQTTPublisherSubscriber sender;

    private final Map<Integer, SectionOccupancyStatus> sectionsOccupied = new ConcurrentHashMap<>();

    public OccupancyRequestSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTPublisherSubscriber(config);
        this.sender.subscribe(this);
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
    public void messageArrived(String topic, MqttMessage message) {
        try {
            if (!sender.getSubscribedTopic().equals(topic)) {
                return;
            }

            Payload payload = getPayloadFromMessage(message);
            Command command = payload.getCommand();

            switch (command) {
                case SEND_OCCUPANCY:
                    OccupancyVector occupancyVector = payload.getContentAs(
                            OccupancyVector.class);
                    int occupancy = occupancyVector.getOccupancyVector();
                    updateOccupancies(occupancy);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(getClass().getName(), new Exception(ex));
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        logException(getClass().getName(), new Exception(cause));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // deliberately left empty
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
