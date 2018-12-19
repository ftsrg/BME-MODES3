package hu.bme.masterrace.InfluxConnector;

import hu.bme.masterrace.Data.RailData;
import org.influxdb.dto.Point;

import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class RailDataInfluxConnector extends InfluxConnector {

    public static void addData(RailData railData) {

        databaseConnection.write(
                Point.measurement("RailSensorRaw")
                        .time(currentTimeMillis(), TimeUnit.MILLISECONDS)
                        .tag("sensorName", railData.getSensorID())
                        .addField("infra1", railData.getInfra1())
                        .addField("infra2", railData.getInfra2())
                        .addField("accx", railData.getAccX())
                        .addField("accy", railData.getAccY())
                        .addField("accz", railData.getAccZ())
                        .addField("microTimeStamp", railData.getMicroTimeStamp())
                        .build());

        System.out.println("sent data on " + currentTimeMillis() + railData.toString());
    }
}
