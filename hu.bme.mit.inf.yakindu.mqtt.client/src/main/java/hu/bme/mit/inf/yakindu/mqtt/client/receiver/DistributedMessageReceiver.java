package hu.bme.mit.inf.yakindu.mqtt.client.receiver;

import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_ALLOWED;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_DENIED;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.mqtt.common.network.MessageFilter;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandMessage;

/**
 * It is used for receiving the messages that are sent the referred turnout
 * (switch)'s statechart.
 *
 * Besides, messages between the turnouts statecharts are sent through this
 * class, because it connects to the MQTT Broker.
 *
 * @author benedekh
 */
public class DistributedMessageReceiver implements MessageFilter {

    // the topic used for communication between the different turnout's statcharts
    private static final String topic = "modes3/yakindu";

    // used for transmitting the messages
    private final MQTTPublishSubscribeDispatcher sender;

    // the recipient of the messages is this handler = key
    // the target who shall get the received message = value
    private final Map<Integer, IDistributedMessageTransmitter> targets;

    /**
     * @param sender used for transmitting the messages
     */
    public DistributedMessageReceiver(MQTTPublishSubscribeDispatcher sender) {
        this.sender = sender;
        this.sender.subscribe(topic, this);
        this.targets = new TreeMap<>();
    }

    /**
     * Registers a handler with the referred recipient ID to handle the received
     * statcharts messages from the MQTT Broker, if they are sent to this
     * recipient ID.
     *
     * @param recipientID the recipient statechart's ID
     * @param target the handler for the messages
     */
    public void registerTargetRecipient(Integer recipientID,
            IDistributedMessageTransmitter target) {
        if (!targets.containsKey(recipientID)) {
            targets.put(recipientID, target);
        }
    }

    /**
     * @param payload to be published on the topic
     */
    public void publishPayload(Payload payload) {
        sender.publishMessage(payload, topic);
    }

    /**
     * Receives the filtered MqttMessage, extracts the statechart-specific
     * commands ({@link hu.bme.mit.inf.mqtt.common.data.Command}) and the
     * payload from it. Then finds the registered turnout (switch), who will
     * handle received message and transfer it to its statechart.
     *
     * @param message the message to be handled
     */
    @Override
    public void filteredMessageArrived(MqttMessage message) {
        try {
            Payload payload = getPayloadFromMessage(message);
            StatemachineCommandMessage commandPayload = payload.getContentAs(
                    StatemachineCommandMessage.class);

            IDistributedMessageTransmitter target = targets.get(
                    commandPayload.getRecipientID());

            if (target != null) {
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
            }
        } catch (Exception ex) {
            logException(getClass().getName(), ex);
        }
    }

    /**
     * Convert the allowance enum to byte.
     *
     * @param allowance that shall be converted to byte
     * @return the byte value of the allowance enum
     */
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
