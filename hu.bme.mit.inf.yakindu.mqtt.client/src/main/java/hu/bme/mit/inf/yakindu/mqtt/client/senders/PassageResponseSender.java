package hu.bme.mit.inf.yakindu.mqtt.client.senders;

import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_RESPONSE_DIVERGENT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_RESPONSE_STRAIGHT;
import static hu.bme.mit.inf.mqtt.common.data.Command.PASSAGE_RESPONSE_TOP;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithPayload;
import static hu.bme.mit.inf.mqtt.common.util.ClientIdGenerator.generateId;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.DIVERGENT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.STRAIGHT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.TOP;
import hu.bme.mit.inf.yakindu.mqtt.client.data.StatemachineCommandMessage;

/**
 *
 * @author benedekh
 */
public class PassageResponseSender {

    private final MQTTPublisherSubscriber sender;

    public PassageResponseSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTPublisherSubscriber(config);
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

        String content = new StatemachineCommandMessage(recipientID, allowance).toJson();
        sendCommandWithPayload(command, content, sender);
    }

}
