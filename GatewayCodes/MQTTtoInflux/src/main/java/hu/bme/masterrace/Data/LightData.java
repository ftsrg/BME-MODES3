package hu.bme.masterrace.Data;

import com.google.gson.JsonObject;

public class LightData extends Data {

    private int light;

    public LightData(String sensorID, String type, String microTimeStamp, int light) {
        super(sensorID, type, microTimeStamp);
        this.light = light;
    }
    // {"SensorID":"007","Light":"1024","MicroTimeStamp":"1568917","Type":"light"}
    LightData(JsonObject json) {
        super(json);
        System.out.println("lightDataConstructor" + json.get("Light").toString());
        light =Integer.parseInt(json.get("Light").toString().substring(1, json.get("Light").toString().length() - 1));
        System.out.println(this.toString());
    }

    public int getLight() {
        return light;
    }

    public String toString(){
        return ("LightData: " + "Light: " + getLight()
                +" SensorID: " + this.getSensorID() + " MicroTimeStamp " + this.getMicroTimeStamp());
    }

}