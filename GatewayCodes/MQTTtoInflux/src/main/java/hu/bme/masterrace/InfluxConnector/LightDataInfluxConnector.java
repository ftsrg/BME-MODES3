package hu.bme.masterrace.InfluxConnector;

import hu.bme.masterrace.Data.LightData;
import org.influxdb.dto.Point;

import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class LightDataInfluxConnector extends InfluxConnector {

    public static void addData(LightData lightData) {
        System.out.println("addData LightDataInfluxConnector" );

        databaseConnection.write(
                Point.measurement("LightSensorRaw")
                        .time(currentTimeMillis(), TimeUnit.MILLISECONDS)
                        .tag("sensorName", lightData.getSensorID())
                        .addField("light", lightData.getLight())
                        .addField("type", lightData.getType())
                        .addField("microTimeStamp", lightData.getMicroTimeStamp())
                        .build());

        System.out.println("sent data on " + currentTimeMillis() + lightData.toString());
    }
}
