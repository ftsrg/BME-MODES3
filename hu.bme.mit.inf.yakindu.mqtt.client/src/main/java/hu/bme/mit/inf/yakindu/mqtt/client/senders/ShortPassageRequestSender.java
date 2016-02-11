package hu.bme.mit.inf.yakindu.mqtt.client.senders;

import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import hu.bme.mit.inf.yakindu.mqtt.client.data.MQTTConfiguration;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.SHORT_PASSAGE_REQUEST_DIVERGENT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.SHORT_PASSAGE_REQUEST_STRAIGHT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.SHORT_PASSAGE_REQUEST_TOP;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandPayload;
import hu.bme.mit.inf.yakindu.mqtt.client.network.ISender;
import hu.bme.mit.inf.yakindu.mqtt.client.network.MQTTMessageSender;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.ClientIdGenerator.generateId;
import static hu.bme.mit.inf.yakindu.mqtt.client.util.PayloadHelper.sendCommandWithPayload;

/**
 *
 * @author benedekh
 */
public class ShortPassageRequestSender {

    private final ISender sender;

    public ShortPassageRequestSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTMessageSender(config);
    }

    public void sendShortPassageRequest(Direction direction, int recipientID) {
        StatemachineCommand command;

        switch (direction) {
            case TOP:
                command = SHORT_PASSAGE_REQUEST_TOP;
                break;
            case STRAIGHT:
                command = SHORT_PASSAGE_REQUEST_STRAIGHT;
                break;
            case DIVERGENT:
                command = SHORT_PASSAGE_REQUEST_DIVERGENT;
                break;
            default:
                return;
        }

        String content = new StatemachineCommandPayload(recipientID).toJson();
        sendCommandWithPayload(command, content, sender);
    }

}
