package hu.bme.masterrace.Data;

import com.google.gson.JsonObject;

public class AccData
        extends Data {
    private double AccX;
    private double AccY;
    private double AccZ;

    public AccData(String sensorID, String type, String microTimeStamp, double accX, double accY, double accZ) {
        super(sensorID, type, microTimeStamp);
        AccX = accX;
        AccY = accY;
        AccZ = accZ;
    }


    // {"SensorID":"mySensor1","Type":"Acc","MicroTimeStamp":"11111","AccX":"1","AccY":"1","AccZ":"1" }

    public AccData(JsonObject json) {
        super(json);
        AccX = Double.valueOf(json.get("AccX").toString().substring(1, json.get("AccX").toString().length() - 1)  );
        AccY = Double.valueOf(json.get("AccY").toString().substring(1, json.get("AccY").toString().length() - 1));
        AccZ = Double.valueOf(json.get("AccZ").toString().substring(1, json.get("AccZ").toString().length() - 1));

    }

    @Override
    public String toString() {
        return (" AccSensorRaw" + " AccX: " + this.getAccX() + " AccY: " + this.getAccY() + " AccZ: " + this.getAccZ()
        +" SensorID: " + this.getSensorID() + " MicroTimeStamp" + this.getMicroTimeStamp());
    }

    public double getAccX() {
        return AccX;
    }

    public double getAccY() {
        return AccY;
    }

    public double getAccZ() {
        return AccZ;
    }
}