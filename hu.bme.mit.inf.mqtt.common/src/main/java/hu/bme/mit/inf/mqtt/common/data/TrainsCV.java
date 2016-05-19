package hu.bme.mit.inf.mqtt.common.data;

/**
 * Stores the positions of trains detected by CV (Computer Vision).
 *
 * @author benedekh
 */
public class TrainsCV {

    // trains detected by CV
    private final TrainCV[] trains;

    public TrainsCV(TrainCV[] trains) {
        this.trains = trains;
    }

    /**
     * @return trains detected by CV
     */
    public TrainCV[] getTrains() {
        return trains;
    }
}
