package hu.bme.mit.inf.kvcontrol.mqtt.client.util;

import com.google.gson.Gson;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Command;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Payload;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.ISender;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class PayloadHelper {

    public static void sendCommandWithPayload(Command command,
            String payloadContent, ISender sender) {
        Payload payload = new Payload(command, payloadContent);
        sender.send(payload);
    }

    public static Payload getPayloadFromMessage(MqttMessage message) {
        String payload = new String(message.getPayload());
        return new Gson().fromJson(payload, Payload.class);
    }
}
