package hu.bme.mit.inf.mqtt.common.data;

/**
 * It represents a train on the track according to the CV (Computer Vision).
 *
 * @author benedekh
 */
public class TrainCV {

    // train ID
    private final int id;

    // x coordinate of the train
    private final int x;

    // y coordinate of the train
    private final int y;

    /**
     * speed of the train is calculated on a 5 frame long buffer.
     */
    private final int speed;

    // moving direction of the train
    private final TrainDirectionCV dir;

    public TrainCV(int id, int x, int y, int speed, TrainDirectionCV dir) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dir = dir;
    }

    /**
     * @return train ID
     */
    public int getID() {
        return this.id;
    }

    /**
     * @return x coordinate of the train
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return y coordinate of the train
     */
    public int getY() {
        return this.y;
    }

    /**
     *
     * @return speed of the train
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * @return moving direction of the train
     */
    public TrainDirectionCV getDirection() {
        return this.dir;
    }
}
