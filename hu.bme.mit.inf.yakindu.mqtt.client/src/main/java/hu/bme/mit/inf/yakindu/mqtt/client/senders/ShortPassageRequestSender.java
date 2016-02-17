package hu.bme.mit.inf.yakindu.mqtt.client.senders;

import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.SHORT_PASSAGE_REQUEST_DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.Command.SHORT_PASSAGE_REQUEST_STRAIGHT;
import static hu.bme.mit.inf.mqtt.common.data.Command.SHORT_PASSAGE_REQUEST_TOP;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.util.ClientIdGenerator.generateId;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.DIVERGENT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.STRAIGHT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.TOP;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandMessage;

/**
 *
 * @author benedekh
 */
public class ShortPassageRequestSender {

    private final MQTTPublisherSubscriber sender;

    public ShortPassageRequestSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTPublisherSubscriber(config);
    }

    public void sendShortPassageRequest(Direction direction, int recipientID) {
        Command command;

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

        StatemachineCommandMessage content = new StatemachineCommandMessage(
                recipientID);
        sendCommandWithContent(command, content, sender);
    }

}
