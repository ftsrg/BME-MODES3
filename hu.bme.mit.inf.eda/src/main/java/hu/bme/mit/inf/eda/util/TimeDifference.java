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

    public long getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(hours));
        sb.append(" hours ");
        sb.append(minutes);
        sb.append(" minutes ");
        sb.append(seconds);
        sb.append(" seconds.");
        return sb.toString();
    }
}
