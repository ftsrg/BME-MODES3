package hu.bme.mit.inf.yakindu.mqtt.client.senders;

import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithPayload;
import static hu.bme.mit.inf.mqtt.common.util.ClientIdGenerator.generateId;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.DIVERGENT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.STRAIGHT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.TOP;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.PASSAGE_REQUEST_DIVERGENT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.PASSAGE_REQUEST_STRAIGHT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommand.PASSAGE_REQUEST_TOP;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandPayload;

/**
 *
 * @author benedekh
 */
public class PassageRequestSender {

    private final MQTTPublisherSubscriber sender;

    public PassageRequestSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTPublisherSubscriber(config);
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
