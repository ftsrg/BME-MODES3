package hu.bme.mit.inf.yakindu.mqtt.client.receiver;

import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_ALLOWED;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_DENIED;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_REQUEST_DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_REQUEST_STRAIGHT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_REQUEST_TOP;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_RESPONSE_DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_RESPONSE_STRAIGHT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_RESPONSE_TOP;
import static hu.bme.mit.inf.mqtt.common.data.Command.SHORT_PASSAGE_REQUEST_DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.Command.SHORT_PASSAGE_REQUEST_STRAIGHT;
import static hu.bme.mit.inf.mqtt.common.data.Command.SHORT_PASSAGE_REQUEST_TOP;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.network.MessageFilter;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance.ALLOWED;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance.DENIED;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandMessage;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class DistributedMessageReceiver implements MessageFilter {

    private static final String topic = "modes3/yakindu";

    private final MQTTPublishSubscribeDispatcher sender;

    // the recipient of the messages is this handler
    private final int recipientID;

    // the target who shall get the received message
    private final IDistributedMessageTransmitter target;

    public DistributedMessageReceiver(MQTTPublishSubscribeDispatcher sender,
            IDistributedMessageTransmitter target, int recipientID) {
        this.sender = sender;
        this.sender.subscribe(topic, this);

        this.recipientID = recipientID;
        this.target = target;
    }

    public void publishPayload(Payload payload) {
        sender.publishMessage(payload, topic);
    }

    @Override
    public void filteredMessageArrived(MqttMessage message) {
        try {
            Payload payload = getPayloadFromMessage(message);
            StatemachineCommandMessage commandPayload = payload.getContentAs(
                    StatemachineCommandMessage.class);

            if (this.recipientID != commandPayload.getRecipientID()) {
                return;
            }

            Command command = payload.getCommand();
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
            logException(getClass().getName(), ex);
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

}
