package hu.bme.masterrace.InfluxConnector;

import hu.bme.masterrace.Data.DHTData;
import org.influxdb.dto.Point;

import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class DHTDataInfluxConnector extends InfluxConnector  {

    public static void addData(DHTData dhtData) {

        databaseConnection.write(
                Point.measurement("DHTSensorRaw")
                        .time(currentTimeMillis(), TimeUnit.MILLISECONDS)
                        .tag("sensorName", dhtData.getSensorID())
                        .addField("temperature", dhtData.getTemperature())
                        .addField("humidity", dhtData.getHumidity())
                        .addField("microTimeStamp", dhtData.getMicroTimeStamp())
                        .build());

        System.out.println( "sent data on "+ currentTimeMillis() + dhtData.toString());
    }
}
