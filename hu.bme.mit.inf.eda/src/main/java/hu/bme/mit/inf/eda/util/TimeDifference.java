package hu.bme.mit.inf.eda.util;

/**
 * Stores the difference between two LocalTime timestamps in hours, minutes and
 * seconds.
 *
 * @author benedekh
 */
public class TimeDifference {

    protected long hours;

    protected long minutes;

    protected long seconds;

    public TimeDifference(long hours, long minutes, long seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public long getHours() {
        return hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }
}
