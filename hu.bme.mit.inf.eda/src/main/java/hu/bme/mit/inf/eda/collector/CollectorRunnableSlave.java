package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.util.TimeDifference;
import hu.bme.mit.inf.eda.util.TimeSettings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

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

    // remaining time until the end of data collection in seconds
    protected TimeDifference timeDifference;

    /**
     * @param collector    who will collect the data
     * @param timeSettings settings for how long and how frequently the data
     *                     should be collected
     * @param path         the output file path of the collected data
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
        timeDifference = calculateDifference(now, finish);

        while (now.isBefore(finish)) {
            try {
                collector.collect();
                sleep(timeSettings.getFrequency());
                now = LocalTime.now();

                calculateAndPrintRemainingTime(now, finish);
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
        } finally {
            logInfoMessage(collector.getClass().getName(), "Saving completed.");
        }
    }

    /**
     * Calculates and prints the remaining time to the end of the data
     * collecting interval.
     *
     * @param now  the current time
     * @param then the time at the end of the data collection
     */
    protected void calculateAndPrintRemainingTime(TemporalAccessor now, Temporal then) {
        TimeDifference newDifference = calculateDifference(now, then);
        if (newDifference.getSeconds() != timeDifference.getSeconds()) {
            timeDifference = newDifference;
            printRemainingTimeTime();
        }
    }

    /**
     * Prints the remaining time to the end of the data collecting interval.
     */
    protected void printRemainingTimeTime() {
        logInfoMessage(collector.getClass().getName(), timeDifference.toString());
    }

    /**
     * Calculate the time difference in hours, minutes and seconds between time
     * 'then' and 'now'.
     *
     * @param now  the start of time difference
     * @param then the end of time difference
     * @return the difference between 'then' and 'now'
     */
    protected TimeDifference calculateDifference(TemporalAccessor now, Temporal then) {
        LocalTime remainingTimeWithSeconds = LocalTime.from(now);

        long hours = remainingTimeWithSeconds.until(then, ChronoUnit.HOURS);
        remainingTimeWithSeconds = remainingTimeWithSeconds.plusHours(hours);
        long minutes = remainingTimeWithSeconds.until(then, ChronoUnit.MINUTES);
        remainingTimeWithSeconds = remainingTimeWithSeconds.plusMinutes(minutes);
        long seconds = remainingTimeWithSeconds.until(then, ChronoUnit.SECONDS);

        return new TimeDifference(hours, minutes, seconds);
    }

}
