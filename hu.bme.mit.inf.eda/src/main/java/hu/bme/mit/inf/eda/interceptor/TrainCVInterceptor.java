package hu.bme.mit.inf.eda.interceptor;

import com.google.gson.Gson;
import hu.bme.mit.inf.mqtt.common.data.TrainsCV;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.mqtt.common.network.MessageFilter;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Stores the latest trains information received from the CV (Computer Vision).
 *
 * @author benedekh
 */
public class TrainCVInterceptor implements MessageFilter {

    // the MQTT topic where the train cv data is transferred
    private static final String topic = "modes3/cv";

    // the dispatcher for that it subscribes on the referred topic
    private final MQTTPublishSubscribeDispatcher requestSender;

    // latest trains information
    private volatile TrainsCV latestCVinfo;

    /**
     * Receives a dispatcher for that it subscribes on the referred topic
     * (@topic field).
     *
     * @param requestSender the dispatcher for that it subscribes
     */
    public TrainCVInterceptor(MQTTPublishSubscribeDispatcher requestSender) {
        this.requestSender = requestSender;
        this.requestSender.subscribe(topic, this);
    }

    @Override
    public void filteredMessageArrived(MqttMessage message) {
        try {
            String payload = new String(message.getPayload());
            latestCVinfo = new Gson().fromJson(payload, TrainsCV.class);
        } catch (Exception ex) {
            logException(getClass().getName(), ex);
        }
    }

    /**
     * @return latest trains information
     */
    public TrainsCV getLatestTrainsInfo() {
        return latestCVinfo;
    }

}
