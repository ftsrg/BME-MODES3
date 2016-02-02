package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.ClientIdGenerator.generateId;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class TurnoutRequestSender implements MqttCallback {

    private final ISender messageSender;

    public TurnoutRequestSender(String topic, int qos, String address) {
        this.messageSender = new MQTTMessageSender(topic, qos, address,
                generateId(getClass().getSimpleName()), this);
    }

    public boolean isTurnoutDivergent(int turnoutId) {
        return false;
    }

    public boolean isTurnoutStraight(int turnoutId) {
        return false;
    }

    @Override
    public void connectionLost(Throwable cause) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
