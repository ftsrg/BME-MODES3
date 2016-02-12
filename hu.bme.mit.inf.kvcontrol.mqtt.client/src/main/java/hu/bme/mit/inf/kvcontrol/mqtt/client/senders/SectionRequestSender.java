package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import com.google.gson.Gson;
import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.GET_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_DISABLE;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_ENABLE;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_SECTION_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.DISABLED;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.ENABLED;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithPayload;
import static hu.bme.mit.inf.mqtt.common.util.ClientIdGenerator.generateId;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class SectionRequestSender implements MqttCallback {

    private final MQTTPublisherSubscriber sender;
    private final String subscribedTopic;

    private final Map<Integer, CompletableFuture<SectionStatus>> sectionStatuses = new ConcurrentHashMap<>();

    public SectionRequestSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTPublisherSubscriber(config);
        this.sender.subscribe(this);
        this.subscribedTopic = config.getTopic();
    }

    public boolean isSectionEnabled(int sectionId) {
        if (!sectionStatuses.containsKey(sectionId)) {
            sectionStatuses.put(sectionId, new CompletableFuture<>());
        }

        String payload = new Section(sectionId).toJson();
        sendCommandWithPayload(GET_SECTION_STATUS, payload, sender);

        SectionStatus status = null;
        try {
            status = sectionStatuses.get(sectionId).get();
            sectionStatuses.remove(sectionId);
        } catch (InterruptedException | ExecutionException ex) {
            logException(getClass().getName(), ex);
        }

        return status == ENABLED;
    }

    public void enableSection(int sectionId) {
        String payload = new Section(sectionId, ENABLED).toJson();
        sendCommandWithPayload(LINE_ENABLE, payload, sender);
    }

    public void disableSection(int sectionId) {
        String payload = new Section(sectionId, DISABLED).toJson();
        sendCommandWithPayload(LINE_DISABLE, payload, sender);
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
                case SEND_SECTION_STATUS:
                    Section section = new Gson().fromJson(
                            payloadObj.getContent(),
                            Section.class);
                    CompletableFuture<SectionStatus> future = sectionStatuses.get(
                            section.getId());

                    if (future != null) {
                        future.complete(section.getStatus());
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
