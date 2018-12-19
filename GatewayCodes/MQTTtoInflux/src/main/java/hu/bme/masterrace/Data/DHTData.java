package hu.bme.masterrace.Data;

import com.google.gson.JsonObject;

public class DHTData extends Data {
    private double Temperature;
    private double Humidity;

    public DHTData(String sensorID, String type, String microTimeStamp, double temperature, double humidity) {
        super(sensorID, type, microTimeStamp);
        Temperature = temperature;
        Humidity = humidity;
    }
    // {"SensorID":"mySensorDHT", "Type":"DHT22", "MicroTimeStamp":"11111", "Temperature":"35.4", "Humidity":"15.5"}
    public DHTData(JsonObject json) {
        super(json);
        Temperature = Double.valueOf(json.get("Temperature").toString().substring(1, json.get("Temperature").toString().length() - 1));
        Humidity = Double.valueOf(json.get("Humidity").toString().substring(1, json.get("Humidity").toString().length() - 1));
    }

    public double getTemperature() {
        return Temperature;
    }

    public double getHumidity() {
        return Humidity;
    }

    @Override
    public String toString(){
        return ("DHTData: " + "Temperature " + getTemperature() + " Humidity "+ getHumidity()
                +" SensorID: " + this.getSensorID() + " MicroTimeStamp" + this.getMicroTimeStamp());
    }
}



