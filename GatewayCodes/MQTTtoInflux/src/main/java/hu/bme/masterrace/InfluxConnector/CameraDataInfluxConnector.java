package hu.bme.masterrace.InfluxConnector;

import hu.bme.masterrace.Data.CameraData;
import org.influxdb.dto.Point;

import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class CameraDataInfluxConnector extends InfluxConnector  {

    public static void addData(CameraData cameraData) {

        databaseConnection.write(
                Point.measurement("CameraSensorRaw")
                        .time(currentTimeMillis(), TimeUnit.MILLISECONDS)
                        .tag("sensorName", cameraData.getSensorID())
                        .addField("labelText", cameraData.getLabelText())
                        .addField("boxLeft", cameraData.getBoxLeft())
                        .addField("boxTop", cameraData.getBoxTop())
                        .addField("boxRight", cameraData.getBoxRight())
                        .addField("boxBottom", cameraData.getBoxBottom())
                        .addField("boxLower", cameraData.getLowerBound())
                        .addField("boxUpper", cameraData.getUpperBound())
                        .build());

        System.out.println( "sent data on "+ currentTimeMillis() + cameraData.toString());
    }
}
