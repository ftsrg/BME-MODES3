package hu.bme.masterrace.Data;

import com.google.gson.JsonObject;

public class RailData extends AccData {
    private int Infra1;
    private int Infra2;

    public RailData(String sensorID, String type, String microTimeStamp, double accX, double accY, double accZ, int infra1, int infra2) {
        super(sensorID, type, microTimeStamp, accX, accY, accZ);
        Infra1 = infra1;
        Infra2 = infra2;
    }

    // {"SensorID":"mySensor1", "Type":"Acc", "MicroTimeStamp":"11111", "AccX":"1", "AccY":"1", "AccZ":"1", "Infra1":"1", "Infra2":"1" }
    public RailData(JsonObject json) {
        super(json);
        Infra1 = Integer.valueOf(json.get("Infra1").toString().substring(1, json.get("Infra1").toString().length() - 1));
        Infra2 = Integer.valueOf(json.get("Infra2").toString().substring(1, json.get("Infra1").toString().length() - 1));
    }

    public int getInfra1() {
        return Infra1;
    }

    public int getInfra2() {
        return Infra2;
    }

    @Override
    public String toString() {
        return ("RailData: " + "Infra1 " + getInfra1() + " Infra2 "+ getInfra2()
                +" SensorID: " + this.getSensorID() + " MicroTimeStamp" + this.getMicroTimeStamp());
    }
}