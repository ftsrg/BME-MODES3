package hu.bme.masterrace;


import hu.bme.masterrace.InfluxConnector.*;

public class Main {

    public static AccDataInfluxConnector accDataInfluxConnector = null;
    public static CameraDataInfluxConnector cameraDataInfluxConnector = null;
    public static DHTDataInfluxConnector dhtDataInfluxConnector = null;
    public static LightDataInfluxConnector lightDataInfluxConnector = null;
    public static RailDataInfluxConnector railDataInfluxConnector = null;

    public static void main(String[] args) {

                accDataInfluxConnector = new AccDataInfluxConnector();
                cameraDataInfluxConnector = new CameraDataInfluxConnector();
                dhtDataInfluxConnector = new DHTDataInfluxConnector();
                lightDataInfluxConnector = new LightDataInfluxConnector();
                railDataInfluxConnector = new RailDataInfluxConnector();

                String serverURL = "tcp://192.168.1.150:1883";
                new MqttSubscriber(serverURL, "raw/acc", "AccData");
                new MqttSubscriber(serverURL, "raw/dht", "DHTData");
                new MqttSubscriber(serverURL, "raw/cameradata", "CameraData");
                new MqttSubscriber(serverURL, "raw/rail", "RailData");
                new MqttSubscriber(serverURL, "raw/light", "LightData");
    }
}
