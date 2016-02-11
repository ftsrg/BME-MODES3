package hu.bme.mit.inf.yakindu.mqtt.client.receiver;

import com.google.gson.Gson;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandPayload;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.*;
import hu.bme.mit.inf.yakindu.mqtt.client.data.MQTTConfiguration;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Payload;
import hu.bme.mit.inf.yakindu.mqtt.client.network.MQTTMessageReceiver;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.ClientIdGenerator.generateId;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.LogManager.logException;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.PayloadHelper.getPayloadFromMessage;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class DistributedMessageReceiver implements MqttCallback {

    // the object subscribes as a callback for this receiver in the constuctor
    private MQTTMessageReceiver receiver;
    private final String subscribedTopic;

    // the recipient of the messages is this handler
    private final int recipientID;

    // the target who shall get the received message
    private final IDistributedMessageTransmitter target;

    public DistributedMessageReceiver(MQTTConfiguration config,
            IDistributedMessageTransmitter target, int recipientID) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.receiver = new MQTTMessageReceiver(config, this);
        this.subscribedTopic = config.getTopic();
        this.recipientID = recipientID;
        this.target = target;
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        try {
            if (!subscribedTopic.equals(topic)) {
                return;
            }
            Payload payloadObj = getPayloadFromMessage(message);
            StatemachineCommandPayload commandPayload = new Gson().fromJson(
                    payloadObj.getContent(), StatemachineCommandPayload.class);

            if (this.recipientID != commandPayload.getRecipientID()) {
                return;
            }

            StatemachineCommand command = payloadObj.getCommand();
            byte[] packet = new byte[2];

            switch (command) {
                case PASSAGE_REQUEST_TOP:
                    // deliberately left empty
                    break;
                case PASSAGE_REQUEST_STRAIGHT:
                    // deliberately left empty
                    break;
                case PASSAGE_REQUEST_DIVERGENT:
                    // deliberately left empty
                    break;
                case SHORT_PASSAGE_REQUEST_TOP:
                    // deliberately left empty
                    break;
                case SHORT_PASSAGE_REQUEST_STRAIGHT:
                    // deliberately left empty
                    break;
                case SHORT_PASSAGE_REQUEST_DIVERGENT:
                    // deliberately left empty
                    break;
                case PASSAGE_RESPONSE_TOP:
                    packet[1] = getByteFromAllowance(
                            commandPayload.getAllowance());
                    break;
                case PASSAGE_RESPONSE_STRAIGHT:
                    packet[1] = getByteFromAllowance(
                            commandPayload.getAllowance());
                    break;
                case PASSAGE_RESPONSE_DIVERGENT:
                    packet[1] = getByteFromAllowance(
                            commandPayload.getAllowance());
                    break;
                default:
                    return;
            }

            packet[0] = command.getValue();

            target.addPacket(packet);
        } catch (Exception ex) {
            logException(getClass().getName(), new Exception(ex));
        }
    }

    private byte getByteFromAllowance(Allowance allowance) {
        switch (allowance) {
            case ALLOWED:
                return PASSAGE_ALLOWED.getValue();
            case DENIED:
                return PASSAGE_DENIED.getValue();
            default:
                return -1;
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
}
