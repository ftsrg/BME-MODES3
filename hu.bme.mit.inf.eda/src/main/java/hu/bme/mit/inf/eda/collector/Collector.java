package hu.bme.mit.inf.eda.collector;

import java.io.PrintWriter;

/**
 *
 * @author benedekh
 */
public interface Collector {

    public void collect();
    
    public void startCollectingData();
    
    public void print(PrintWriter writer);
}
