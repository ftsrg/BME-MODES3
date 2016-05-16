package hu.bme.mit.inf.yakindu.mqtt.client.senders;

import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_RESPONSE_DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_RESPONSE_STRAIGHT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_RESPONSE_TOP;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.createCommandWithContent;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.DIVERGENT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.STRAIGHT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.TOP;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandMessage;
import hu.bme.mit.inf.yakindu.mqtt.client.receiver.DistributedMessageReceiver;

/**
 * Used for sending a passage response to a turnout's statechart.
 *
 * @author benedekh
 */
public class PassageResponseSender {

    // used for transmitting the messages
    private final DistributedMessageReceiver sender;

    /**
     * @param sender used for transmitting the messages
     */
    public PassageResponseSender(DistributedMessageReceiver sender) {
        this.sender = sender;
    }

    /**
     * Send a passage response to the referred turnout's (recipient ID)
     * statechart, that can reach the sender turnout's statemachine from the
     * referred direction.
     *
     * @param direction from which the target (recipient) can reach the sender
     * ("local") turnout's statechart.
     * @param allowance whether the passage is allowed or not, for the train
     * coming from the target turnout's area
     * @param recipientID the recipient turnout (switch)'s ID
     */
    public void sendPassageResponse(Direction direction, Allowance allowance,
            int recipientID) {

        Command command;

        switch (direction) {
            case TOP:
                command = PASSAGE_RESPONSE_TOP;
                break;
            case STRAIGHT:
                command = PASSAGE_RESPONSE_STRAIGHT;
                break;
            case DIVERGENT:
                command = PASSAGE_RESPONSE_DIVERGENT;
                break;
            default:
                return;
        }

        StatemachineCommandMessage content = new StatemachineCommandMessage(
                recipientID, allowance);
        Payload payload = createCommandWithContent(command, content);
        sender.publishPayload(payload);
    }

}
