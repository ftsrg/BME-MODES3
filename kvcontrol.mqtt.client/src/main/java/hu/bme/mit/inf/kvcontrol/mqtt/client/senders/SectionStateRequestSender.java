package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import static hu.bme.mit.inf.kvcontrol.mqtt.client.util.ClientIdGenerator.generateId;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class SectionStateRequestSender implements MqttCallback {

    private final ISender messageSender;

    public SectionStateRequestSender(String topic, int qos, String address) {
        this.messageSender = new MQTTMessageSender(topic, qos, address,
                generateId(getClass().getSimpleName()), this);
    }

    public boolean isSectionEnabled(int sectionId) {
        return false;
    }

    public void enableSection(int sectionId) {

    }

    public void disableSection(int sectionId) {

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
