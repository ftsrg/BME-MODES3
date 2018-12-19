package hu.bme.masterrace.Data;

import com.google.gson.JsonObject;

public abstract class Data {

    private String SensorID;
    private String Type;
    private String MicroTimeStamp;

    Data(String sensorID, String type, String microTimeStamp) {
        SensorID = sensorID;
        Type = type;
        MicroTimeStamp = microTimeStamp;
    }

    Data(JsonObject json) {
        try {
            System.out.println("dataConstr");
            SensorID = json.get("SensorID").toString().substring(1, json.get("SensorID").toString().length() - 1);
            Type = json.get("Type").toString().substring(1, json.get("Type").toString().length() - 1);
            MicroTimeStamp = json.get("MicroTimeStamp").toString().substring(1, json.get("MicroTimeStamp").toString().length() - 1);
        } catch (Exception e) {
            System.out.println("Parse failed" + json.get("SensorID").toString());
        }
    }
    public String getSensorID() {
        return SensorID;
    }
    public String getType() {
        return Type;
    }
    public String getMicroTimeStamp() {
        return MicroTimeStamp;
    }
}