package hu.bme.mit.inf.eda.util;

/**
 * The time settings (duration and frequency) of the data collection.
 *
 * @author benedekh
 */
public class TimeSettings {

    // the time interval of data collection in minutes
    private final int duration;

    // the frequency in milliseconds the collection should be refreshed
    private final int frequency;

    /**
     * @param duration  the time interval of data collection in minutes
     * @param frequency the frequency in milliseconds the collection should be
     *                  refreshed
     */
    public TimeSettings(int duration, int frequency) {
        this.duration = duration;
        this.frequency = frequency;
    }

    /**
     * @return the time interval of data collection in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @return the frequency in milliseconds the collection should be refreshed
     */
    public int getFrequency() {
        return frequency;
    }
}
