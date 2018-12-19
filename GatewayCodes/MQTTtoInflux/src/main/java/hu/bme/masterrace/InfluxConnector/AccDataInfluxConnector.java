package hu.bme.masterrace.InfluxConnector;

import hu.bme.masterrace.Data.AccData;
import org.influxdb.dto.Point;

import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class AccDataInfluxConnector extends InfluxConnector  {

    public static void addData(AccData accData) {

        databaseConnection.write(
                Point.measurement("AccSensorRaw")
                        .time(currentTimeMillis(), TimeUnit.MILLISECONDS)
                        .tag("sensorName", accData.getSensorID())
                        .addField("accx", accData.getAccX())
                        .addField("accy", accData.getAccY())
                        .addField("accz", accData.getAccZ())
                        .addField("microTimeStamp", accData.getMicroTimeStamp())
                        .build());
        System.out.println( "sent data on "+ currentTimeMillis() + accData.toString());
    }
}
