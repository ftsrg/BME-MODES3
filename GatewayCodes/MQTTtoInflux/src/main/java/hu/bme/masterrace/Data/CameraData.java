package hu.bme.masterrace.Data;

import com.google.gson.JsonObject;

public class CameraData extends Data {
    private String LabelText;
    private double BoxLeft;
    private double BoxTop;
    private double BoxRight;
    private double BoxBottom;
    private double LowerBound;
    private double UpperBound;

    public CameraData(String sensorID, String type, String microTimeStamp, String labelText, double boxLeft, double boxTop, double boxRight, double boxBottom, double lowerBound, double upperBound) {
        super(sensorID, type, microTimeStamp);
        LabelText = labelText;
        BoxLeft = boxLeft;
        BoxTop = boxTop;
        BoxRight = boxRight;
        BoxBottom = boxBottom;
        LowerBound = lowerBound;
        UpperBound = upperBound;
    }

    // {"SensorID":"mySensorCamera", "Type":"Camera", "MicroTimeStamp":"11111", "LabelText":"person", "BoxLeft":"0.4", "BoxTop":"0.4", "BoxRight":"0.4","BoxBottom":"0.4", "LowerBound":"0.2", "UpperBound":"0.8"}
    public CameraData(JsonObject json) {
        super(json);
        LabelText = json.get("LabelText").toString();
        BoxLeft = Double.valueOf(json.get("BoxLeft").toString());
        BoxTop = Double.valueOf(json.get("BoxTop").toString());
        BoxRight = Double.valueOf(json.get("BoxRight").toString());
        BoxBottom = Double.valueOf(json.get("BoxBottom").toString());
        LowerBound = Double.valueOf(json.get("LowerBound").toString());
        UpperBound = Double.valueOf(json.get("UpperBound").toString());
    }

    public String getLabelText() {
        return LabelText;
    }

    public double getBoxLeft() {
        return BoxLeft;
    }

    public double getBoxTop() {
        return BoxTop;
    }

    public double getBoxRight() {
        return BoxRight;
    }

    public double getBoxBottom() {
        return BoxBottom;
    }

    public double getLowerBound() {
        return LowerBound;
    }

    public double getUpperBound() {
        return UpperBound;
    }

    @Override
    public String toString() {
        return (" CameraSensorRaw" +
                " LabelText: " + this.getLabelText() +
                " BoxLeft: " + this.getBoxLeft() +
                " BoxTop: " + this.getBoxTop() +
                " BoxRight: " + this.getBoxRight() +
                " BoxBottom: " + this.getBoxBottom() +
                " LoweBound: " + this.getLowerBound() +
                " UpperBound: " + this.getUpperBound()
                +" SensorID: " + this.getSensorID() + " MicroTimeStamp" + this.getMicroTimeStamp()
        );
    }

}