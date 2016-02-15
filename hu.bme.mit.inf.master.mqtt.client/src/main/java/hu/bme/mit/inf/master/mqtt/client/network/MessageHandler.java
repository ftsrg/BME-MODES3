package hu.bme.mit.inf.master.mqtt.client.network;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.master.mqtt.client.conf.TurnoutConfiguration;
import hu.bme.mit.inf.mqtt.common.data.Command;

import static hu.bme.mit.inf.mqtt.common.data.Command.GET_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.GET_TURNOUT_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.IDENTIFY;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_DISABLE;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_ENABLE;
import hu.bme.mit.inf.mqtt.common.data.Identity;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionArray;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithPayload;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;

public class MessageHandler implements MqttCallback {

    private TurnoutConfiguration controllerConf;

    private final MQTTPublisherSubscriber mqttConnection;
    private final String subscribedTopic;

    public MessageHandler(MQTTConfiguration conf) {
        this.controllerConf = new TurnoutConfiguration();
        this.mqttConnection = new MQTTPublisherSubscriber(conf);
        this.mqttConnection.subscribe(this);
        this.subscribedTopic = conf.getTopic();
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        try {
            if (!subscribedTopic.equals(topic)) {
                return;
            }

            Payload payloadObj = getPayloadFromMessage(message);
            Command command = payloadObj.getCommand();

            switch (command) {
                case IDENTIFY:
                    String payload = createIdentity().toJson();
                    sendCommandWithPayload(IDENTIFY, payload,
                            mqttConnection);
                    break;
                case GET_SECTION_STATUS:
                    break;
                case GET_TURNOUT_STATUS:
                    break;
                case LINE_ENABLE:
                    break;
                case LINE_DISABLE:
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(getClass().getName(), new Exception(ex));
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        logException(getClass().getName(), new Exception(cause));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

    private Identity createIdentity() {
        SectionArray sections = new SectionArray(
                (Section[]) controllerConf.getManagedSections().toArray());
        Identity identity = new Identity(controllerConf.getManagedTurnout(),
                sections);
        return identity;
    }

}
