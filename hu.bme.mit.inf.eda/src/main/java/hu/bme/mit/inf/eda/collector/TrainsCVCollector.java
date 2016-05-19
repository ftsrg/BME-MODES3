package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.interceptor.TrainCVInterceptor;
import hu.bme.mit.inf.eda.util.TimeSettings;
import hu.bme.mit.inf.mqtt.common.data.TrainsCV;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Collects trains information based on CV (Computer Vision).
 *
 * @author benedekh
 */
public class TrainsCVCollector implements Collector {

    // list of <timestamp, <ID, X, Y, speed, direction>> entries
    protected final List<TrainsCV> statusEntries = new ArrayList<>();

    // request sender to acquire status information
    protected final TrainCVInterceptor requestSender;

    // it calls us frequently to collect data
    protected final CollectorRunnableSlave collectorSlave;

    public TrainsCVCollector(MQTTPublishSubscribeDispatcher dispatcher,
            TimeSettings timeSettings, String path) {
        this.requestSender = new TrainCVInterceptor(dispatcher);
        this.collectorSlave = new CollectorRunnableSlave(this, timeSettings,
                path);
    }

    @Override
    public void collect() {
        TrainsCV latestInfo = requestSender.getLatestTrainsInfo();
        if (latestInfo != null) {
            statusEntries.add(latestInfo);
        }
    }

    @Override
    public void startCollectingData() {
        new Thread(collectorSlave).start();
    }

    @Override
    public void print(PrintWriter writer) {
        writer.println("timestamp,id,x,y,speed,direction");
        writer.flush();

        for (TrainsCV entry : statusEntries) {
            writer.println(entry.toString());
            writer.flush();
        }
    }

}
