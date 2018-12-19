package hu.bme.masterrace.InfluxConnector;

import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;

abstract class InfluxConnector {

    static InfluxDB getDatabaseConnection() {
        return databaseConnection;
    }

    static InfluxDB databaseConnection;

    InfluxConnector() {

        String influxURL = "http://grafana.wlap.eu:8086";
        String influxUser = "modes";
        String influxPass = "LaborImage";
        databaseConnection = InfluxDBFactory.connect(influxURL, influxUser, influxPass);
        String influxDBname = "modes";
        databaseConnection.setDatabase(influxDBname);
        databaseConnection.enableBatch(BatchOptions.DEFAULTS);

    }
    /*
    void addData(Temperature temperature) {

        databaseConnection.write(
                Point.measurement("temperature2")

                        .time(Long.valueOf(temperature.timestamp), TimeUnit.MILLISECONDS)
                        .tag("sensorName", temperature.sensorMeta.sensorName)
                        .addField("updateFreq", temperature.sensorMeta.updateFreq)
                        .addField("isValid", temperature.isValid)
                        .addField("locationName", temperature.location.locationName)
                        .addField("value", temperature.value)
                        .build());

        System.out.println( "sent data on "+temperature.timestamp);
    }
    */
}