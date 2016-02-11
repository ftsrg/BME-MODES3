package hu.bme.mit.inf.yakindu.mqtt.client.senders;

import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import hu.bme.mit.inf.yakindu.mqtt.client.data.MQTTConfiguration;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.PASSAGE_REQUEST_DIVERGENT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.PASSAGE_REQUEST_STRAIGHT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.PASSAGE_REQUEST_TOP;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandPayload;
import hu.bme.mit.inf.yakindu.mqtt.client.network.ISender;
import hu.bme.mit.inf.yakindu.mqtt.client.network.MQTTMessageSender;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.ClientIdGenerator.generateId;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.PayloadHelper.sendCommandWithPayload;

/**
 *
 * @author benedekh
 */
public class PassageRequestSender {

    private final ISender sender;

    public PassageRequestSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTMessageSender(config);
    }

    public void sendPassageRequest(Direction direction, int recipientID) {
        StatemachineCommand command;

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

        String content = new StatemachineCommandPayload(recipientID).toJson();
        sendCommandWithPayload(command, content, sender);
    }

}
