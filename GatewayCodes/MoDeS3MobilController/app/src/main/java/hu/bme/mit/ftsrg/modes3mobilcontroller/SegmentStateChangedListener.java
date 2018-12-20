package hu.bme.mit.ftsrg.modes3mobilcontroller;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface SegmentStateChangedListener {

    void segmentStateChanged(MqttMessage message);

}
