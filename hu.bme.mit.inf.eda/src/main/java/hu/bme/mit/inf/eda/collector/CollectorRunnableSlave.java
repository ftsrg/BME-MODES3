package hu.bme.mit.inf.eda.collector;

import hu.bme.mit.inf.eda.util.TimeDifference;
import hu.bme.mit.inf.eda.util.TimeSettings;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

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
     * @param now the current time
     * @param then the time at the end of the data collection
     */
    protected void calculateAndPrintRemainingTime(LocalTime now, LocalTime then) {
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
        StringBuilder sb = new StringBuilder(String.valueOf(
                timeDifference.getHours()));
        sb.append(" hours ");
        sb.append(timeDifference.getMinutes());
        sb.append(" minutes ");
        sb.append(timeDifference.getSeconds());
        sb.append(" seconds.");
        logInfoMessage(collector.getClass().getName(), sb.toString());
    }

    /**
     * Calculate the time difference in hours, minutes and seconds between time
     * 'then' and 'now'.
     *
     * @param now the start of time difference
     * @param then the end of time difference
     *
     * @return the difference between 'then' and 'now'
     */
    protected TimeDifference calculateDifference(LocalTime now, LocalTime then) {
        LocalTime remainingTimeWithSeconds = LocalTime.from(now);

        long hours = remainingTimeWithSeconds.until(then, ChronoUnit.HOURS);
        remainingTimeWithSeconds = remainingTimeWithSeconds.plusHours(hours);
        long minutes = remainingTimeWithSeconds.until(then, ChronoUnit.MINUTES);
        remainingTimeWithSeconds = remainingTimeWithSeconds.plusMinutes(minutes);
        long seconds = remainingTimeWithSeconds.until(then, ChronoUnit.SECONDS);

        TimeDifference difference = new TimeDifference(hours, minutes, seconds);
        return difference;
    }

}
