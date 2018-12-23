package hu.bme.mit.ftsrg.modes3mobilcontroller.listeners;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface TurnoutStateChangedListener {
    void turnoutStateChanged(MqttMessage message);
}
