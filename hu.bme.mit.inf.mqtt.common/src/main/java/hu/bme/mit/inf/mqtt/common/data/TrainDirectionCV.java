package hu.bme.mit.inf.mqtt.common.data;

/**
 * Direction of the train according to the CV (Computer Vision).
 *
 * The top-left corner of the railway track is the (0,0) and from this point of
 * view, in which direction the train goes comparing to the middle of the track.
 *
 * @author benedekh
 */
public enum TrainDirectionCV {

    NONE, CW, CCW;
}
