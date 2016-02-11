package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import com.google.gson.Gson;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Command;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.MQTTConfiguration;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Payload;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Section;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.SectionArray;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.SectionOccupancyStatus;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.data.SectionOccupancyStatus.OCCUPIED;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.ClientIdGenerator.generateId;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.LogManager.logException;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.PayloadHelper.getPayloadFromMessage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author benedekh
 */
public class OccupancyRequestSender implements MqttCallback {

    // the object subscribes as a callback for this sender in the constuctor
    private final ISender sender;
    private final String subscribedTopic;

    private final Map<Integer, SectionOccupancyStatus> sectionsOccupied = new ConcurrentHashMap<>();

    public OccupancyRequestSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTMessageSender(config, this);
        this.subscribedTopic = config.getTopic();
    }

    public boolean isSectionOccupied(int sectionId) {
        SectionOccupancyStatus status = sectionsOccupied.get(sectionId);
        return status == OCCUPIED;
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        try {
            if (!subscribedTopic.equals(topic)) {
                return;
            }

            Payload payloadObj = getPayloadFromMessage(message);
            Command command = payloadObj.getCommand();

            switch (command) {
                case SEND_OCCUPANCY:
                    SectionArray sectionsArray = new Gson().fromJson(
                            payloadObj.getContent(),
                            SectionArray.class);
                    Section[] sections = sectionsArray.getSectionArray();
                    for (Section section : sections) {
                        sectionsOccupied.put(section.getId(),
                                section.getOccupancyStatus());
                    }
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

    }

}
