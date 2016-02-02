package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.ClientIdGenerator.generateId;

/**
 *
 * @author benedekh
 */
public class OccupancyRequestSender implements MqttCallback {

    private final ISender messageSender;

    public OccupancyRequestSender(String topic, int qos, String address) {
        this.messageSender = new MQTTMessageSender(topic, qos, address,
                generateId(getClass().getSimpleName()), this);
    }

    public boolean isSectionOccupied(int sectionId) {
        return false;
    }

    public int getOccupancyVector() {
        return -1;
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
