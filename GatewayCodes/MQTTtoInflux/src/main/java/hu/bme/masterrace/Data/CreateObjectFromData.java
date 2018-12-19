package hu.bme.masterrace.Data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hu.bme.masterrace.InfluxConnector.*;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class CreateObjectFromData {

    public CreateObjectFromData(String myClass, MqttMessage message) {

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(message.toString());

        switch (myClass) {
            case "AccData":
                AccData accData = new AccData(jsonObject);
                AccDataInfluxConnector.addData(accData);
                break;
            case "CameraData":
                CameraData cameraData = new CameraData(jsonObject);
                CameraDataInfluxConnector.addData(cameraData);
                break;
            case "DHTData":
                DHTData dhtData = new DHTData(jsonObject);
                DHTDataInfluxConnector.addData(dhtData);
                break;
            case "LightData":
                System.out.println("Light Data create object from data");
                LightData lightData = new LightData(jsonObject);
                LightDataInfluxConnector.addData(lightData);
                break;
            case "RailData":
                RailData railData = new RailData(jsonObject);
                RailDataInfluxConnector.addData(railData);
                break;
        }

    }

}
