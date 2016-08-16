package hu.bme.mit.inf.yakindu.mqtt.client.senders;

import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_REQUEST_DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_REQUEST_STRAIGHT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_REQUEST_TOP;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.createCommandWithContent;

import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandMessage;
import hu.bme.mit.inf.yakindu.mqtt.client.receiver.DistributedMessageReceiver;

/**
 * Used for sending a passage request to a turnout's statechart.
 *
 * @author benedekh
 */
public class PassageRequestSender {

    // used for transmitting the messages
    private final DistributedMessageReceiver sender;

    /**
     * @param sender used for transmitting the messages
     */
    public PassageRequestSender(DistributedMessageReceiver sender) {
        this.sender = sender;
    }

    /**
     * Send a passage request to the referred turnout's (recipient ID)
     * statechart, that can reach the sender turnout's statemachine from the
     * referred direction.
     *
     * @param direction from which the target (recipient) can reach the sender
     * ("local") turnout's statechart.
     * @param recipientID the recipient turnout (switch)'s ID
     */
    public void sendPassageRequest(Direction direction, int recipientID) {
        Command command;

        switch (direction) {
            case TOP:
                command = PASSAGE_REQUEST_TOP;
                break;
            case STRAIGHT:
                command = PASSAGE_REQUEST_STRAIGHT;
                break;
            case DIVERGENT:
                command = PASSAGE_REQUEST_DIVERGENT;
                break;
            default:
                return;
        }

        StatemachineCommandMessage content = new StatemachineCommandMessage(
                recipientID);
        Payload payload = createCommandWithContent(command, content);
        sender.publishPayload(payload);
    }

}
