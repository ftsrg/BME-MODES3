package hu.bme.mit.inf.eda.data;

/**
 *
 * @author benedekh
 */
public class CollectionTimeSettings {
    
    // the time interval of data collection in minutes
    private final int duration;
    
    // the frequency in milliseconds the collection should be refreshed
    private final int frequency;
    
    public CollectionTimeSettings(int duration, int frequency){
        this.duration = duration;
        this.frequency = frequency;
    }
    
    public int getDuration(){
        return duration;
    }
    
    public int getFrequency(){
        return frequency;
    }
}
