package hu.bme.mit.inf.eda.collector;

import java.io.PrintWriter;

/**
 * An interface for the EDA data collector implementations.
 *
 * @author benedekh
 */
public interface Collector {

    /**
     * On request collect data by the collector implementation.
     */
    public void collect();

    /**
     * Starts data collection.
     */
    public void startCollectingData();

    /**
     * Print the collected data on the writer.
     *
     * @param writer that prints the collected data
     */
    public void print(PrintWriter writer);
}
