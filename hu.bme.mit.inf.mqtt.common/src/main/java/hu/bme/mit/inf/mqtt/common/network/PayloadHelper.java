package hu.bme.mit.inf.mqtt.common.network;

import com.google.gson.Gson;
import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.JsonConvertible;
import hu.bme.mit.inf.mqtt.common.data.OccupancyPayload;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * A common class for connecting MqttMessage with the custom Java classes we use
 * as data classes over MQTT.
 *
 * @author benedekh
 */
public class PayloadHelper {

    /**
     * Creates a Payload object from the referred command and content objects.
     *
     * @param command that denotes what kind of message it is
     * @param content the content of the message
     * @return new Payload object that contains the command and the string
     * serialized version of the content
     */
    public static Payload createCommandWithContent(Command command,
            JsonConvertible content) {
        String payloadContent = content.toJson();
        return new Payload(command, payloadContent);
    }

    /**
     * Creates a Payload object from the MqttMessage.
     *
     * @param message from that the payload will be extracted
     * @return the extracted (deserialized) payload object from the message
     */
    public static Payload getPayloadFromMessage(MqttMessage message) {
        String payload = new String(message.getPayload());
        return new Gson().fromJson(payload, Payload.class);
    }

    /**
     * Extracts the occupancy payload from the MqttMessage.
     *
     * @param message from that the occupancy payload will be extracted
     * @return the extracted (deserialized) occupancy payload object from the
     * message
     */
    public static OccupancyPayload getOccupancyPayloadFromMessage(
            MqttMessage message) {
        String payload = new String(message.getPayload());
        return new Gson().fromJson(payload, OccupancyPayload.class);
    }
}
