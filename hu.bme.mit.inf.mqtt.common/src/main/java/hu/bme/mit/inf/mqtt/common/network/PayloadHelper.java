package hu.bme.mit.inf.mqtt.common.network;

import com.google.gson.Gson;
import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.JsonConvertible;
import hu.bme.mit.inf.mqtt.common.data.OccupancyPayload;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class PayloadHelper {

    public static Payload createCommandWithContent(Command command,
            JsonConvertible content) {
        String payloadContent = content.toJson();
        return new Payload(command, payloadContent);
    }

    public static Payload getPayloadFromMessage(MqttMessage message) {
        String payload = new String(message.getPayload());
        return new Gson().fromJson(payload, Payload.class);
    }

    public static OccupancyPayload getOccupancyPayloadFromMessage(
            MqttMessage message) {
        String payload = new String(message.getPayload());
        return new Gson().fromJson(payload, OccupancyPayload.class);
    }
}
