package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.data.TimeSettings;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import java.time.LocalTime;

/**
 * A "slave" runnable, which periodically calls the referred collector to call
 * the data.
 *
 * @author benedekh
 */
public class CollectorRunnableSlave implements Runnable {

    // who shall collect data
    protected Collector collector;

    // time settings for the data collection
    protected TimeSettings timeSettings;

    // path for the serialized data
    protected String path;

    /**
     * @param collector who will collect the data
     * @param timeSettings settings for how long and how frequently the data
     * should be collected
     * @param path the output file path of the collected data
     */
    public CollectorRunnableSlave(Collector collector,
            TimeSettings timeSettings, String path) {
        this.collector = collector;
        this.timeSettings = timeSettings;
        this.path = path;
    }

    @Override
    public void run() {
        LocalTime now = LocalTime.now();
        LocalTime finish = now.plusMinutes(timeSettings.getDuration());

        while (now.isBefore(finish)) {
            try {
                collector.collect();
                sleep(timeSettings.getFrequency());
                now = LocalTime.now();
            } catch (InterruptedException ex) {
                logException(getClass().getName(), ex);
                currentThread().interrupt();
            }
        }

        try {
            try (PrintWriter writer = new PrintWriter(new File(path))) {
                collector.print(writer);
                writer.flush();
            }
        } catch (FileNotFoundException ex) {
            logException(getClass().getName(), ex);
        }

    }

}
