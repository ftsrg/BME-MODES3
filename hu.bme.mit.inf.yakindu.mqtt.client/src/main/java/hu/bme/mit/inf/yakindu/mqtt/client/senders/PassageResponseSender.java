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
 *
 * @author benedekh
 */
public class PassageResponseSender {

    private final DistributedMessageReceiver sender;

    public PassageResponseSender(DistributedMessageReceiver sender) {
        this.sender = sender;
    }

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
