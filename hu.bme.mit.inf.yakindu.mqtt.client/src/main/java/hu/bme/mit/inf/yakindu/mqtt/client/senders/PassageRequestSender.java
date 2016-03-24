package hu.bme.mit.inf.yakindu.mqtt.client.senders;

import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_REQUEST_DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_REQUEST_STRAIGHT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_REQUEST_TOP;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.createCommandWithContent;
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
public class PassageRequestSender {
    
    private final DistributedMessageReceiver sender;
    
    public PassageRequestSender(DistributedMessageReceiver sender) {
        this.sender = sender;
    }
    
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
