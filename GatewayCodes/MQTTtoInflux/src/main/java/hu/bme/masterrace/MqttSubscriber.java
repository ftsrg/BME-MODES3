package hu.bme.masterrace;

import hu.bme.masterrace.Data.CreateObjectFromData;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.sql.Date;

class MqttSubscriber {


    private String myClass;

    MqttSubscriber(String serverURL, String TOPIC, String targetClassName) {
        myClass = targetClassName;
        MqttClient mqtt = null;
        try {
            mqtt = new MqttClient(serverURL, MqttClient.generateClientId());
            mqtt.connect();
            subscribe(mqtt, TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void subscribe(MqttClient client, String TOPIC) throws Exception {
        client.subscribe(TOPIC);
        client.setCallback(new MqttCallback() {

            public void connectionLost(Throwable throwable) {
                System.out.println("Connection lost " + Date.valueOf(String.valueOf(System.currentTimeMillis())));
            }

            public void messageArrived(String topic, MqttMessage message) {
                System.out.println("messageArrived: " + message);
                CreateObjectFromData createObjectFromData = new CreateObjectFromData(myClass, message);
            }

            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken){}
        });
    }
}
