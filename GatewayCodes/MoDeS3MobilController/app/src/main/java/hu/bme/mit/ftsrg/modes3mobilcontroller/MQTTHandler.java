package hu.bme.mit.ftsrg.modes3mobilcontroller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

import hu.bme.mit.ftsrg.modes3mobilcontroller.listeners.SegmentStateChangedListener;
import hu.bme.mit.ftsrg.modes3mobilcontroller.listeners.TurnoutStateChangedListener;
import hu.bme.mit.ftsrg.modes3mobilcontroller.network.NetworkUtil;

;


public class MQTTHandler {

    private static SegmentStateChangedListener segmentStateChangedListener;
    private static TurnoutStateChangedListener turnoutStateChangedListener;


    public static void setEventListener(SegmentStateChangedListener listener) {
        segmentStateChangedListener = listener;
    }

    public static void setEventListener(TurnoutStateChangedListener listener) {
        turnoutStateChangedListener = listener;
    }

    public void turnoutStateChanged(MqttMessage msg) {

        if (turnoutStateChangedListener != null)
            turnoutStateChangedListener.turnoutStateChanged(msg); // event result object :)

    }


    public void segmentStateChanged(MqttMessage msg) {

        if (segmentStateChangedListener != null)
            segmentStateChangedListener.segmentStateChanged(msg); // event result object :)

    }

    public static MqttAndroidClient client;
    private static Context mycontext;

    public MQTTHandler(Context context, String serverURI) {
        mycontext = context;
        if ((NetworkUtil.getConnectivityStatusString(context)).equals("Wifi enabled")) {

            client = new MqttAndroidClient(context, serverURI, MqttClient.generateClientId());
            try {
                Log.d("mqtt", "try connect to server");
                Toast.makeText(mycontext, mycontext.getString(R.string.tryingToConnectTo) +" " +client.getServerURI(), Toast.LENGTH_SHORT).show();
                IMqttToken token = client.connect();
                token.setActionCallback(new IMqttActionListener() {
                    @Override
                    public void onSuccess(IMqttToken asyncActionToken) {
                        // We are connected
                        Toast.makeText(mycontext, mycontext.getString(R.string.connectedTo) +" "+ client.getServerURI(), Toast.LENGTH_SHORT).show();
                        Log.d("mqtt", "onSuccess connected");
                        try {
                            MQTTHandler.client.subscribe("segment/state", 0, new IMqttMessageListener() {
                                @Override
                                public void messageArrived(String topic, MqttMessage message) throws Exception {
                                    Log.d("mqtt", "arrived " + message);
                                    segmentStateChanged(message);
                                }
                            });
                        } catch (MqttException e) {
                            e.printStackTrace();
                        }

                        try {
                            MQTTHandler.client.subscribe("turnout/state", 0, new IMqttMessageListener() {
                                @Override
                                public void messageArrived(String topic, MqttMessage message) throws Exception {
                                    Log.d("mqtt", "arrived " + message);
                                    turnoutStateChanged(message);
                                }
                            });
                        } catch (MqttException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        // Something went wrong e.g. connection timeout or firewall problems
                        Log.d("mqtt", "onFailure mqtt");
                        Toast.makeText(mycontext, mycontext.getString(R.string.failedToConnectTo) +" "+ client.getServerURI(), Toast.LENGTH_LONG).show();
                    }
                });

            } catch (Exception e) {
                Log.d("mqtt",e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void mypublish(String topic, String message) {
        if ((NetworkUtil.getConnectivityStatusString(mycontext)).equals("Wifi enabled")) {
            if (MQTTHandler.client.isConnected()) {

                byte[] encodedPayload = new byte[0];
                try {
                    encodedPayload = message.getBytes("UTF-8");
                    MqttMessage messages = new MqttMessage(encodedPayload);
                    messages.setRetained(true);
                    Log.d("mqtt", "mqtt message sent on topic: " + topic + " message:" + message);
                    MQTTHandler.client.publish(topic, messages);
                } catch (UnsupportedEncodingException | MqttException e) {
                    e.printStackTrace();
                }
            }
        }

    }




}
